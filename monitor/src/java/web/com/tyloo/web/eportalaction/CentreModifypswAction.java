package com.tyloo.web.eportalaction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;

import com.tyloo.fw.ServiceLocator;
import com.tyloo.fw.waf.WebContext;
import com.tyloo.modules.service.ShopUserService;
import com.tyloo.po.ShopUser;
import com.tyloo.web.WebAction;

public class CentreModifypswAction extends WebAction {
	private static final ShopUserService service = (ShopUserService) ServiceLocator
			.getService("shopUserService");
	
	@Override
	public String webProcess(WebContext context, Object member)
			throws ServletException {
		
		String insert = context.getParameter("insert");
		if(member == null)
		{
			return "/shopuser/login.html";
		}
		ShopUser user = (ShopUser)member;
		if(insert != null)
		{
			String oldpwd = context.getParameter("oldpwd");
			if(oldpwd == null)
			{
				oldpwd ="";
			}
			String pwd = context.getParameter("pwd");
			
			if(user.getPwd().equals(com.tyloo.web.util.MD5.encryptMD5(oldpwd)))
            {
				// 验证密码合法性
				Pattern p = Pattern.compile("(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}");
				Matcher m = p.matcher(pwd);
				if (!m.matches()) {
					context.put("updated", "-2");
					return "show";
				}
				else
				{
					user.setPwd(com.tyloo.web.util.MD5.encryptMD5(pwd));
					service.updateObject(user);
					context.put("updated", "0000");
					return "show";
				}
				
			}
			else
			{
				context.put("updated", "-1");
				return "show";
			}
		}
		context.put("action", "pwdmodify");
		return "show";
	}
	
}
