package com.tyloo.web.member;


import javax.servlet.ServletException;

import org.apache.commons.lang.StringUtils;


import com.tyloo.fw.ServiceLocator;
import com.tyloo.fw.waf.WebContext;
import com.tyloo.modules.CommonService;
import com.tyloo.modules.member.ModuleService;
import com.tyloo.po.Module;
import com.tyloo.util.searchcontext.SearchContext;
import com.tyloo.util.searchcontext.SearchOption;
import com.tyloo.web.DispatchActions;

@SuppressWarnings("unchecked")
public class ModuleAction extends DispatchActions {
     private static final ModuleService service = (ModuleService) ServiceLocator
     			.getService("moduleService");

	@Override
	protected Class getActionClass() {
		return Module.class;
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
		//return searchContext;
	}

	@Override
	public String insertProcess(WebContext context) throws ServletException {
		return super.insertProcess(context);
	}
	
	
	public String updateProcess(WebContext context) throws ServletException {
		return super.updateProcess(context);
	}
	

	@Override
	protected CommonService getService() {
		return service;
	}

	@Override
	public String getWebMenuType(WebContext context) throws ServletException {
		return "module";
	}

}
