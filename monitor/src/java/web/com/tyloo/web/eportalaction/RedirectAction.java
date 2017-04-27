package com.tyloo.web.eportalaction;

import javax.servlet.ServletException;

import com.tyloo.fw.waf.WebContext;
import com.tyloo.web.WebAction;

public class RedirectAction extends WebAction {

	@Override
	public String webProcess(WebContext context, Object member)
			throws ServletException {
		
		String show = context.getParameter("show");
		if("cartAddSuccess".equals(show))
		{
			return "cartaddsuccess";
		}
		else
		{	
			return "defaultshow";
		}
	}

}
