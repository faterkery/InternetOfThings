package com.tyloo.web.action;

import javax.servlet.ServletException;

import com.tyloo.fw.waf.WebContext;
import com.tyloo.web.WebAction;

public class PageChangAction extends WebAction{

	@Override
	public String webProcess(WebContext context, Object member)
			throws ServletException {
		String type = context.getParameter("type");
		if("indexinit".equals(type))
		{
			return "indexinit" ;
		}
		return "show";
	}

}
