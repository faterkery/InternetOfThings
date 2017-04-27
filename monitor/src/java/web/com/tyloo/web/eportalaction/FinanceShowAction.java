package com.tyloo.web.eportalaction;

import javax.servlet.ServletException;

import com.tyloo.fw.waf.WebContext;
import com.tyloo.web.WebAction;

public class FinanceShowAction extends WebAction {
	@Override
	public String webProcess(WebContext context, Object member)
			throws ServletException {
		context.put("action", "finance");
		return "finance";
	}
}


