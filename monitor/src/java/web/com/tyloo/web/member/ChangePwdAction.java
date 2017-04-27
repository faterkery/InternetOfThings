package com.tyloo.web.member;

import javax.servlet.ServletException;

import com.tyloo.fw.ServiceLocator;
import com.tyloo.fw.waf.WebContext;
import com.tyloo.modules.member.MemberService;
import com.tyloo.po.Member;
import com.tyloo.web.AdminAction;
import com.tyloo.web.WebHelper;
import com.tyloo.web.form.ChangePwdForm;

public class ChangePwdAction extends AdminAction {

	private static MemberService memberService = (MemberService) ServiceLocator
			.getService("memberService");

	@Override
	public String adminProcess(WebContext context) throws ServletException {
		if (context.getParameter("insert") != null
				|| context.getParameter("insert2") != null) {
				Member member = WebHelper.getMemberContext(context);
			 if (member != null) {
			 ChangePwdForm form = (ChangePwdForm) context.getForm();
			 String oldpass = form.getOldPassword();
			
			 if (member != null) {
			 if (!member.getPassword().equals(oldpass)) {
			 context.put("passError", true);
			 return DEFAULT_FORWARD;
			 }
			 }
			 member.setPassword(form.getNewPassword());
			 memberService.updateObject(member);
			 context.put("updated", true);
			 }
		}
		return DEFAULT_FORWARD;
	}
}
