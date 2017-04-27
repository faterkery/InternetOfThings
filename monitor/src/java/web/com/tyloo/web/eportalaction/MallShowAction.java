package com.tyloo.web.eportalaction;

import javax.servlet.ServletException;

import com.tyloo.fw.waf.WebContext;
import com.tyloo.web.WebAction;

public class MallShowAction extends WebAction {
	@Override
	public String webProcess(WebContext context, Object member)
			throws ServletException {
		context.put("action", "mall");
		return "mall";
	}
}


