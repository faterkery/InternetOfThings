package com.tyloo.web.eportalroot;

import javax.servlet.ServletException;

import com.tyloo.fw.ServiceLocator;
import com.tyloo.fw.waf.WebContext;
import com.tyloo.modules.service.ShopUserService;
import com.tyloo.po.ShopUser;
import com.tyloo.po.SmsValidate;
import com.tyloo.web.WebAction;
import com.tyloo.web.WebHelper;
import com.tyloo.web.util.MD5;

public class RegisterAction extends WebAction{
	private static ShopUserService shopUserService = (ShopUserService) ServiceLocator
			.getService("shopUserService");

	@Override
	public String webProcess(WebContext context, Object member)
			throws ServletException {
		WebHelper.putCommonValues(context);
		context.put("base", context.getRequest().getContextPath());
		context.put("action", "login");

		String code = context.getParameter("code");
		String mtel = context.getParameter("mtel");
		boolean bool =  validateSMS(mtel, code);
		if (context.getParameter("insert") != null && bool) {
			String password = context.getParameter("pwd");
			ShopUser temp = shopUserService.getShopUserByMtel(mtel);
			if (temp != null) {
				// 用户已经存在
				context.put("name", temp.getMtel());
				return "secucess";
			}

			ShopUser user = new ShopUser();
			user.setMtel(context.getParameter("mtel"));
			user.setTrueName(context.getParameter("trueName"));
			user.setSex(-1); //0女  1男  -1保密
			user.setPwd(MD5.encryptMD5(password));
			user.setCompanyName(context.getParameter("companyName"));
			user.setImg("");
			user.setEmail("");
			user.setEmailCheck(0);
			user.setQq("");
			context.put("name", user.getMtel());
//			context.put("name", user.getMtel());
//			context.put("md5psw", user.getPwd());

			/**
			HttpSession session = context.getRequest().getSession();

			// 验证密码合法性
			Pattern p = Pattern
					.compile("(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}");
			Matcher m = p.matcher(password);
			if (!m.matches()) {
				session.setAttribute("regTemp", user);
				session.setAttribute("errinfo", "密码复杂度不够，不能是纯数字或者纯字母");
				return "error_info_page";
			}

			// 密码不能包含用户名
			if (password != null && password.contains(user.getUserName())) {
				session.setAttribute("regTemp", user);
				session.setAttribute("errinfo", "密码不能包含用户名");
				return "error_info_page";
			}*/

			shopUserService.insertObject(user);
			if (null != user.getId()) {
				context.put("inserted", true);
				context.setTempClientValue("shopUser", user);
				return "secucess";
			}
		}

		return "show";

	}
	
	 private boolean validateSMS(String phone, String vsms)
	    {
	    	//验证短信
			SmsValidate smsObj = shopUserService.getSendRecord(phone, vsms);
			long currentMS = System.currentTimeMillis();
			if(smsObj==null)
			{
				return false;
			}
			if(currentMS - smsObj.getTime()> 300*1000)
			{
				return false;
			}
			return true;
	    }

}
