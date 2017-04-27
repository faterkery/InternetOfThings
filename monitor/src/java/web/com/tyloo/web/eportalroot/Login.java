package com.tyloo.web.eportalroot;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import com.tyloo.fw.ServiceLocator;
import com.tyloo.fw.waf.WebContext;
import com.tyloo.modules.service.ShopUserService;
import com.tyloo.po.ShopUser;
import com.tyloo.web.VMUtils;
import com.tyloo.web.WebAction;
import com.tyloo.web.po.ResultInfo;
import com.tyloo.web.util.MD5;

/**
 * 登陆
 * 
 * @author luoxn
 */
public class Login extends WebAction {
	private static ShopUserService shopUserService = (ShopUserService) ServiceLocator.getService("shopUserService");

	@Override
	public String webProcess(WebContext context, Object member)
			throws ServletException {
		context.put("action", "login");
		ShopUser user = null;
		ResultInfo resultinfo = new ResultInfo();
		context.put("returnURL", context.getParameter("context"));
		if (context.getParameter("login") != null) 
		{
				String mtel = context.getParameter("username");
				String pwd = context.getParameter("pwd");
				String md5pwd = MD5.encryptMD5(pwd);
				user = shopUserService.getShopUserByMtel(mtel, md5pwd);
				
				if (user != null) {
					resultinfo.setResult(AJAX_SUCCESS);
					context.setTempClientValue("shopUserId", user.getId().toString());
					context.setTempClientValue("shopUser", user);
					HttpSession session = context.getRequest().getSession();
					session.setAttribute("shopUser", user);
					
					//保存到cookie
					int autologin = context.getIntParameter("autologin");
					if(autologin == 1)
					{
						Cookie nameCookie = new Cookie("mtel", mtel);
						nameCookie.setMaxAge(60 * 60 * 24 * 7);
						nameCookie.setPath(COOKIE_PATH);
						Cookie pwdCookie = new Cookie("md5pwd", md5pwd);
						pwdCookie.setMaxAge(60 * 60 * 24 * 7);
						pwdCookie.setPath(COOKIE_PATH); 
						context.getResponse().addCookie(nameCookie);
						context.getResponse().addCookie(pwdCookie);
					}
				}
				else 
				{
					resultinfo.setResult(AJAX_FAIL);
				}

		} else if (context.getParameter("logout") != null) {
			context.setTempClientValue("shopUserId", "");
			context.setTempClientValue("shopUser", "");
			HttpSession session = context.getRequest().getSession();
			session.removeAttribute("shopUser");
			
			Cookie nameCookie = new Cookie("mtel", null);
			nameCookie.setPath(COOKIE_PATH);
			nameCookie.setMaxAge(-1);
			Cookie pwdCookie = new Cookie("md5pwd", null);
			pwdCookie.setPath(COOKIE_PATH);
			pwdCookie.setMaxAge(-1);
			context.getResponse().addCookie(nameCookie);
			context.getResponse().addCookie(pwdCookie);
			
			return "/index.html";
		}
		else
		{
			
			return "show";
		}
		
		try {
			context.getResponse().getOutputStream().write(VMUtils.toJsonStr(resultinfo).getBytes("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}



}
