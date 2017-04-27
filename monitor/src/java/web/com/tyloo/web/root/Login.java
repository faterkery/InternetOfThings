package com.tyloo.web.root;

import javax.servlet.ServletException;

import com.tyloo.fw.orm.Persistent;
import com.tyloo.fw.waf.BaseAction;
import com.tyloo.fw.waf.WebContext;
import com.tyloo.modules.ServiceManager;
import com.tyloo.modules.member.MemberService;
import com.tyloo.po.Member;
import com.tyloo.po.Role;
import com.tyloo.web.form.LoginForm;

public class Login extends BaseAction {

	private static final MemberService memberService = ServiceManager
			.getMemberService();
	
	@Override
	public String process(WebContext context) throws ServletException {
		String re = DEFAULT_FORWARD;
		Member member = null;
		if (context.getParameter("login") != null) {

			LoginForm form = (LoginForm) context.getForm();
			member = memberService.getMemberByNameAndPwd(form.getLoginName(),
					form.getPassword(), 0);
			
			if (member != null) {
				context.setTempClientValue("memberId", member.getId());
				context.put("member", member);
//				Persistent roleP = memberService.getObjectById(Role.class, member.getRoleId());
				context.getRequest().getSession().setAttribute("memberRole", member);
				re = "/login.html";
			} else {
				re = "/admin.html?logerror=1"; 
			}

		} else if (context.getParameter("logout") != null) {
			context.setTempClientValue("memberId", "");
			context.setTempClientValue("member", "");
			context.getRequest().getSession().setAttribute("logerror", null);
			context.getRequest().getSession().removeAttribute("memberRole");
			re = "/admin.html";
		}
		else
		{
			re = "/admin.html";
		}
		
		return re;
	}
}
