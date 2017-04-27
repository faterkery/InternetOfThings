package com.tyloo.web.member;

import javax.servlet.ServletException;

import org.apache.commons.lang.StringUtils;

import com.tyloo.fw.ServiceLocator;
import com.tyloo.fw.waf.BasePOForm;
import com.tyloo.fw.waf.WebContext;
import com.tyloo.modules.CommonService;
import com.tyloo.modules.member.ModuleService;
import com.tyloo.modules.member.RoleService;
import com.tyloo.po.Role;
import com.tyloo.util.searchcontext.SearchContext;
import com.tyloo.util.searchcontext.SearchOption;
import com.tyloo.web.DispatchActions;

public class RoleAction extends DispatchActions {
	private static RoleService service = (RoleService) ServiceLocator
			.getService("roleService");
	
	private static ModuleService moduleService = (ModuleService) ServiceLocator
	.getService("moduleService");

	@Override
	public String updateProcess(WebContext context) throws ServletException {
		context.put("moduleList", moduleService.getModuleList());
		if (context.getParameter("insert") != null) {
			int roleId = context.getIntParameter("id");
			dealRoleModule(context, roleId);
		}
		return super.updateProcess(context);
	}

	@Override
	public String insertProcess(WebContext context) throws ServletException {
		context.put("moduleList", moduleService.getModuleList());
		String forword = DispatchActions.INSERT_FORWARD;
		int roleId = 0;
		if (context.getParameter("insert") != null) {
			BasePOForm form = (BasePOForm) context.getForm();

			roleId = (Integer) (getService().insertObject(form, Role.class));
			context.put("inserted", true);
			forword = INSERT_SUCCESS_FORWARD;
			dealRoleModule(context, roleId);
		}

		return forword;
	}

	private void dealRoleModule(WebContext context, int roleId) {
		int[] modules = context.getIntParameterValues("moduleIds");
		if (modules != null && modules.length > 0) {
			String[] pris = new String[modules.length];
			String[] prises;
			String pri = "";
			for (int i = 0; i < modules.length; i++) {
				prises = context.getParameterValues("pri_" + modules[i]);
				if (prises != null) {
					for (int j = 0; j < prises.length; j++) {
						pri += prises[j] + ",";
						pris[i] = pri;
					}
					pri = "";
				}
			}
			moduleService.updateRoleModules(roleId, modules, pris);
		} else {
			moduleService.updateRoleModules(roleId, null, null);
		}
	}


	@Override
	protected SearchContext getListSearchContext(WebContext context) {
		SearchContext searchContext = new SearchContext();
		String name = delSearchOption(context, "name");
		if (!StringUtils.isEmpty(name)) {
			searchContext.addOption(new SearchOption("name", "%" + name + "%",
					SearchOption.Option.like));
		}
		return searchContext;
	}

	@Override
	public String getWebMenuType(WebContext context) throws ServletException {
		return "";
	}

	@Override
	protected Class getActionClass() {
		return Role.class;
	}

	@Override
	protected CommonService getService() {
		return service;
	}

}
