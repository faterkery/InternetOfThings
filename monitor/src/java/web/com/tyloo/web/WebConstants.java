package com.tyloo.web;

import com.tyloo.fw.Config;

/**
 * 
 * 
 * Title:
 * 
 * Description:
 * 
 * Copyright: Copyright (c) 2006
 * 
 * @author luoxn
 * @created 2006-6-6 15:45:21
 * @version $Id: WebConstants.java,v 1.1.1.1 2008/01/22 05:25:20 luoxn Exp $
 */
public interface WebConstants {

	public static int perPage = 10;//pageSize
	// public static String DEFAULT_FORWARD = "show";
	public static final String LOGIN_FORWARD = "login";

	public static final String NO_PRI_FORWARD = "noPrivileage";
	public static final String AJAX_SUCCESS = "success";
	public static final String AJAX_FAIL = "fail";
	public static String COOKIE_PATH = Config.getString("cookie.path"); //网站前台图片上传路径
}
