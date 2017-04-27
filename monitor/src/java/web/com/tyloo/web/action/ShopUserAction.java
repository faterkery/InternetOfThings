package com.tyloo.web.action;


import javax.servlet.ServletException;

import org.apache.commons.lang.StringUtils;

import com.tyloo.fw.ServiceLocator;
import com.tyloo.fw.waf.WebContext;
import com.tyloo.modules.CommonService;
import com.tyloo.modules.service.ShopUserService;
import com.tyloo.po.ShopUser;
import com.tyloo.util.searchcontext.SearchContext;
import com.tyloo.util.searchcontext.SearchOption;
import com.tyloo.web.DispatchActions;

public class ShopUserAction extends DispatchActions {
	private static ShopUserService service = (ShopUserService) ServiceLocator.getService("shopUserService");

	@Override
	protected Class<ShopUser> getActionClass() {
		return ShopUser.class;
	}

	@Override
	protected SearchContext getListSearchContext(WebContext context) {
		SearchContext searchContext = new SearchContext();
		 String mtel = delSearchOption(context, "mtel");
	        if (!StringUtils.isEmpty(mtel)) {
	            searchContext.addOption(new SearchOption("mtel", "%" + mtel + "%", SearchOption.Option.like));
	        }
		return searchContext;
	}

	@Override
	protected CommonService getService() {
		return service;
	}

	@Override
	public String getWebMenuType(WebContext context) throws ServletException {
		return "shopUser";
	}
}
