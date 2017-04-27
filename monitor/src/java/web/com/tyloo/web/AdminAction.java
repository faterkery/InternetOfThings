package com.tyloo.web;

import javax.servlet.ServletException;

import com.tyloo.fw.waf.BaseAction;
import com.tyloo.fw.waf.WebContext;

public abstract class AdminAction extends BaseAction implements WebConstants {
	@Override
	public String process(WebContext context) throws ServletException {
		if (!WebHelper.isSigned(context)) {
			return LOGIN_FORWARD;
		} else {
			return adminProcess(context);
		}
	}

	public abstract String adminProcess(WebContext context)
			throws ServletException;

}