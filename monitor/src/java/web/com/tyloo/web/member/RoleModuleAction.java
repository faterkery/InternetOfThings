package com.tyloo.web.member;

import javax.servlet.ServletException;

import com.tyloo.fw.ServiceLocator;
import com.tyloo.fw.waf.WebContext;
import com.tyloo.modules.member.RoleModuleService;
import com.tyloo.po.RoleModule;
import com.tyloo.util.searchcontext.SearchContext;
import com.tyloo.web.DispatchActions;

public class RoleModuleAction extends DispatchActions {
	private static RoleModuleService service = (RoleModuleService) ServiceLocator
			.getService("roleModuleService");



	@Override
	protected RoleModuleService getService() {
		return service;
	}

	@Override
	protected Class getActionClass() {
		return RoleModule.class;
	}

	@Override
	protected SearchContext getListSearchContext(WebContext context) {
		SearchContext searchContext = new SearchContext();
//		int moduleId = delIntSearchOption(context, "moduleId");
//		int roleId = delIntSearchOption(context, "roleId");
//		if (moduleId > 0) {
//			searchContext.addOption(new SearchOption("moduleId", moduleId,
//					SearchOption.Option.eqaul));
//		}
//
//		if (roleId > 0) {
//			searchContext.addOption(new SearchOption("roleId", roleId,
//					SearchOption.Option.eqaul));
//		}
		return searchContext;

	}

	@Override
	public String getWebMenuType(WebContext context) throws ServletException {
		return "";
	}

}
