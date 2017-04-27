package com.tyloo.web;

import javax.servlet.ServletException;

import org.apache.commons.lang.StringUtils;

import com.tyloo.fw.waf.BaseAction;
import com.tyloo.fw.waf.WebContext;

/**
 * 
 * Title:
 * 
 * Description:
 * 
 * Copyright: Copyright (c) 2005
 * 
 * @author luoxn
 */
public abstract class WebAction extends BaseAction implements WebConstants {
	/**
	 * @see com.tyloo.fw.waf.BaseAction#process(com.tyloo.fw.waf.WebContext)
	 */
	@Override
	public String process(WebContext context) throws ServletException {
		Object member = WebHelper.getShopUserContext(context);

		if (context.getParameter("rmsg") != null) {
			context.put("rmsg", context.getParameter("rmsg"));
		}
		if (context.getParameter("emsg") != null) {
			context.put("emsg", context.getParameter("emsg"));
		}
		if (context.getParameter("wmsg") != null) {
			context.put("wmsg", context.getParameter("wmsg"));
		}
		
		String showtext = context.getParameter("showtext");
		if (StringUtils.isEmpty(showtext)) {
			showtext = "原料";
		}
		context.put("showtext", showtext);
		
		String topSearch = context.getParameter("topSearch");
		if (StringUtils.isEmpty(topSearch)) {
			topSearch = "1";
		}
		context.put("topSearch", topSearch);
		
		String kword = context.getParameter("kword");
		context.put("kword", kword);
		
		
		return webProcess(context, member);
	}

	/**
	 * ����������.
	 * 
	 * @param mapping
	 * @param form
	 * @param req
	 * @param response
	 * @return
	 * @throws
	 * @throws ServletException
	 */
	public abstract String webProcess(WebContext context, Object member)
			throws ServletException;

}