package com.tyloo.web.root;

import javax.servlet.ServletException;

import com.tyloo.fw.ServiceLocator;
import com.tyloo.fw.waf.WebContext;
import com.tyloo.modules.service.ShopUserService;
import com.tyloo.web.WebAction;
import com.tyloo.web.WebHelper;

public class Index extends WebAction {
	private static ShopUserService shopUserService = (ShopUserService) ServiceLocator.getService("shopUserService");
	@Override
	public String webProcess(WebContext context, Object member)
			throws ServletException {
		member = WebHelper.getMemberContext(context);
		context.put("logerror", context.getParameter("logerror"));
		if(member == null)
		{
			return "login";
		}
		else
		{
			return "index";
		}
	}

}
