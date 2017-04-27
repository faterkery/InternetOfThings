package com.tyloo.web.eportalroot;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import com.tyloo.fw.ServiceLocator;
import com.tyloo.fw.orm.Persistent;
import com.tyloo.fw.waf.WebContext;
import com.tyloo.modules.member.ResourcesService;
import com.tyloo.modules.service.ShopUserService;
import com.tyloo.po.Resources;
import com.tyloo.po.ShopUser;
import com.tyloo.util.searchcontext.SearchContext;
import com.tyloo.util.searchcontext.SearchOption;
import com.tyloo.web.WebAction;

public class Index extends WebAction {
	
	private static ShopUserService shopUserService = (ShopUserService) ServiceLocator.getService("shopUserService");
	
	@Override
	public String webProcess(WebContext context, Object member)
			throws ServletException {
		
		context.put("action", "index");
		
		
		return DEFAULT_FORWARD;
	}
}
