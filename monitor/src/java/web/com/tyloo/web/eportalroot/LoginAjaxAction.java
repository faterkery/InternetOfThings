package com.tyloo.web.eportalroot;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import com.tyloo.fw.ServiceLocator;
import com.tyloo.fw.waf.WebContext;
import com.tyloo.modules.service.ShopUserService;
import com.tyloo.po.ShopUser;
import com.tyloo.web.VMUtils;
import com.tyloo.web.WebAction;
import com.tyloo.web.po.ResultInfo;
import com.tyloo.web.util.MD5;

public class LoginAjaxAction extends WebAction{
	private static final ShopUserService shopUserService = (ShopUserService) ServiceLocator
			.getService("shopUserService");
	@Override
	public String webProcess(WebContext context, Object member)
			throws ServletException {
		 ShopUser user = (ShopUser)member;
		 String action = context.getParameter("action");
		 ResultInfo info = new ResultInfo();
		 if("checklogin".equals(action))
		 {
			 if(user != null)
			 {
				 info.setResult(AJAX_SUCCESS);
				 info.setObj(user.getMtel());
			 }
			 else
			 {
				 info.setResult(AJAX_FAIL);
			 }
		 }
		 else if("login".equals(action))
		 {
			 String mtel = context.getParameter("mtel");
			 String pwd = context.getParameter("pwd");
			 String md5pwd = MD5.encryptMD5(pwd);
			 ShopUser userDB = shopUserService.getShopUserByMtel(mtel, md5pwd);
			 if(userDB != null)
			 {
				context.setTempClientValue("shopUserId", userDB.getId() + "");
				context.setTempClientValue("shopUser", userDB);
				HttpSession session = context.getRequest().getSession();
				session.setAttribute("shopUser", userDB);
				info.setResult(AJAX_SUCCESS);
				info.setObj(userDB.getMtel());
			 }
			 else
			 {
				 info.setResult(AJAX_FAIL);
			 }
		 }
		 else if("vcode".equals(action))
		 {
			 
			 Object vcode = context.getRequest().getSession().getAttribute("validateCode");
		     String code =  context.getRequest().getParameter("yzm");
		     if(code == null)
		     {
		    	 code = "";
		     }
			 if(code.toUpperCase().equals(vcode))
			 {
				info.setResult(AJAX_SUCCESS);
				
			 }
			 else
			 {
				 info.setResult(AJAX_FAIL);
			 }
		 }
		 
		 String jsonStr = VMUtils.toJsonStr(info);
		 try {
			context.getResponse().getOutputStream().write(jsonStr.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		 return null;
	}

}
