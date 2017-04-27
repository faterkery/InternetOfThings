package com.tyloo.web.member;

import java.util.List;

import javax.servlet.ServletException;

import org.apache.commons.lang.StringUtils;

import com.tyloo.fw.ServiceLocator;
import com.tyloo.fw.waf.WebContext;
import com.tyloo.modules.CommonService;
import com.tyloo.modules.ServiceManager;
import com.tyloo.modules.member.MemberService;
import com.tyloo.modules.member.RoleService;
import com.tyloo.po.Member;
import com.tyloo.po.Role;
import com.tyloo.util.searchcontext.SearchContext;
import com.tyloo.util.searchcontext.SearchOption;
import com.tyloo.web.DispatchActions;
import com.tyloo.web.form.MemberForm;

@SuppressWarnings("unchecked")
public class MemberAction extends DispatchActions {
	private static final MemberService memberService = ServiceManager
			.getMemberService();

	private static final RoleService roleService = (RoleService) ServiceLocator
			.getService("roleService");



	@Override
	protected Class getActionClass() {
		return Member.class;
	}

	@Override
	protected SearchContext getListSearchContext(WebContext context) {
		SearchContext searchContext = new SearchContext();
		String loginName = delSearchOption(context, "loginName");
		String username = delSearchOption(context, "username");
		if (!StringUtils.isEmpty(username)) {
			searchContext.addOption(new SearchOption("username", "%" + username
					+ "%", SearchOption.Option.like));
		}
		if (!StringUtils.isEmpty(loginName)) {
			searchContext.addOption(new SearchOption("loginName", "%" + loginName
					+ "%", SearchOption.Option.like));
		}
		return searchContext;
	}

	@Override
	public String insertProcess(WebContext context) throws ServletException {		
		List<Role> roleList= roleService.getRole();
		context.put("roleList", roleList);
		
		MemberForm form = (MemberForm) context.getForm();
		if (form != null) {
			Member meber = memberService.getMemberByName(form.getLoginName());
			if (meber != null) {
				context.put("nameExits", true);
				return "insert";
			}
			
		}
		return super.insertProcess(context);
	}

	public String updateProcess(WebContext context) throws ServletException {
		if("dianyuan".equals(context.getParameter("role"))){
			if (context.getParameter("insert") != null
					|| context.getParameter("insert2") != null) {
				int id = context.getIntParameter("id");
				Member member = (Member)this.getService().getObjectById(getActionClass(), id);
				member.setPassword(context.getParameter("password"));
				this.getService().updateObject(member);
				context.put("bizObj", member);
				context.put("updated", "true");
			}else{
				super.updateProcess(context);
			}
			return "updateDianyuan";
		}
		
		List<Role> roleList = roleService.getRole();
		context.put("roleList", roleList);
		
		return super.updateProcess(context);
	}


	@Override
	protected CommonService getService() {
		return memberService;
	}

	@Override
	public String getWebMenuType(WebContext context) throws ServletException {
		return "member";
	}

}
