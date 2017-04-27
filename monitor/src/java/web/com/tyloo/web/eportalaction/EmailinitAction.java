package com.tyloo.web.eportalaction;

import javax.servlet.ServletException;

import com.tyloo.fw.ServiceLocator;
import com.tyloo.fw.waf.WebContext;
import com.tyloo.modules.service.ShopUserService;
import com.tyloo.po.ShopUser;
import com.tyloo.web.WebAction;

public class EmailinitAction extends WebAction {
	private static final ShopUserService service = (ShopUserService) ServiceLocator
			.getService("shopUserService");
	
	@Override
	public String webProcess(WebContext context, Object user)
			throws ServletException {
		context.put("action", "login");
		String insert = context.getParameter("insert");
		if(user == null)
		{
			return "/shopuser/login.html";
		}
		context.put("user", user);
		return "emailinit";
	}
}
