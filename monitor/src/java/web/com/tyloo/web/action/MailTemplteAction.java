package com.tyloo.web.action;


import javax.servlet.ServletException;

import org.apache.commons.lang.StringUtils;

import com.tyloo.fw.ServiceLocator;
import com.tyloo.fw.waf.WebContext;
import com.tyloo.modules.CommonService;
import com.tyloo.modules.service.MailService;
import com.tyloo.po.MailTemplte;
import com.tyloo.util.searchcontext.SearchContext;
import com.tyloo.util.searchcontext.SearchOption;
import com.tyloo.web.DispatchActions;

public class MailTemplteAction extends DispatchActions {
	private static MailService service = (MailService) ServiceLocator.getService("mailService");

	@Override
	protected Class<MailTemplte> getActionClass() {
		return MailTemplte.class;
	}

	@Override
	protected SearchContext getListSearchContext(WebContext context) {
		SearchContext searchContext = new SearchContext();
		 String numbers = delSearchOption(context, "numbers");
	        if (!StringUtils.isEmpty(numbers)) {
	            searchContext.addOption(new SearchOption("numbers", "%" + numbers + "%", SearchOption.Option.like));
	        }
		return searchContext;
	}

	@Override
	protected CommonService getService() {
		return service;
	}

	@Override
	public String getWebMenuType(WebContext context) throws ServletException {
		return "consultation";
	}
}
