package com.tyloo.web.action;

import javax.servlet.ServletException;

import org.apache.commons.lang.StringUtils;

import com.tyloo.fw.ServiceLocator;
import com.tyloo.fw.waf.WebContext;
import com.tyloo.modules.service.ShopUserService;
import com.tyloo.po.ShopUser;
import com.tyloo.util.searchcontext.SearchContext;
import com.tyloo.util.searchcontext.SearchOption;
import com.tyloo.web.DispatchActions;

/**
 * 注册用户管理管理
 * 
 * @author jiangtao
 * 
 */
public class RegisterUserAction extends DispatchActions {

	private static ShopUserService shopUserService = (ShopUserService) ServiceLocator
			.getService("shopUserService");

	@Override
	protected SearchContext getListSearchContext(WebContext context) {
		SearchContext searchContext = new SearchContext();
		String userName = delSearchOption(context, "userName");
		if (StringUtils.isNotEmpty(userName)) {
			searchContext.addOption(new SearchOption("userName", "%" + userName + "%",
					SearchOption.Option.like));
		}
		return searchContext;
	}

	@Override
	protected Class getActionClass() {
		return ShopUser.class;
	}

	@Override
	protected ShopUserService getService() {
		return shopUserService;
	}

	@Override
	public String getWebMenuType(WebContext context) throws ServletException {
		return null;
	}

}
