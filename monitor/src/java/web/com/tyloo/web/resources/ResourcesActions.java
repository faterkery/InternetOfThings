package com.tyloo.web.resources;

import javax.servlet.ServletException;

import org.apache.commons.lang.StringUtils;

import com.tyloo.fw.ServiceLocator;
import com.tyloo.fw.waf.WebContext;
import com.tyloo.modules.CommonService;
import com.tyloo.modules.member.ResourcesService;
import com.tyloo.po.Resources;
import com.tyloo.util.searchcontext.SearchContext;
import com.tyloo.util.searchcontext.SearchOption;
import com.tyloo.web.DispatchActions;
import com.tyloo.web.form.ResourcesForm;

public class ResourcesActions extends DispatchActions {
	private static ResourcesService service = (ResourcesService) ServiceLocator
			.getService("resourcesService");

	@Override
	protected CommonService getService() {
		return service;
	}

	@Override
	protected Class<Resources> getActionClass() {
		return Resources.class;
	}

	@Override
	protected SearchContext getListSearchContext(WebContext context) {
		SearchContext searchContext = new SearchContext();

		String type = context.getParameter("type");
		if (type == null) {
			type = context.getTempClientValue("type");
		}
		if ("null".equals(type)) {
			type = context.getTempClientValue("type");
		}
		context.put("type", type);

		if (!StringUtils.isEmpty(type)) {
			searchContext.addOption(new SearchOption("type", type,
					SearchOption.Option.eqaul));
		}
		String searchvalue = delSearchOption(context, "searchvalue");
		if(StringUtils.isNotEmpty(searchvalue))
		{
			searchContext.addOption(new SearchOption("value", "%"+searchvalue+"%", SearchOption.Option.like));
		}

		ResourcesForm form = new ResourcesForm();
		form.setType(type);
		context.put("bizObj", form);

		return searchContext;
	}

	@Override
	public String insertProcess(WebContext context) throws ServletException {
		String type = context.getParameter("type");
		context.setTempClientValue("type", type);
		super.insertProcess(context);
		return "/resources/actions.html?method=list&type=" + type;
	}

	@Override
	public String updateProcess(WebContext context) throws ServletException {
		String type = context.getParameter("type");
		context.put("type", type);
		return super.updateProcess(context);

	}

	@Override
	public String deleteProcess(WebContext context) throws ServletException {
		String type = context.getParameter("type");
		context.put("type", type);
		super.deleteProcess(context);

		return "/resources/actions.html?method=list&type=" + type;

	}

	@Override
	public String getWebMenuType(WebContext context) throws ServletException {
		return "";
	}

}
