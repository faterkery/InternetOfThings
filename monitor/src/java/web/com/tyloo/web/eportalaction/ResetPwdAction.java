package com.tyloo.web.eportalaction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;

import org.apache.commons.lang.StringUtils;

import com.tyloo.fw.ServiceLocator;
import com.tyloo.fw.waf.WebContext;
import com.tyloo.modules.service.ShopUserService;
import com.tyloo.po.ShopUser;
import com.tyloo.web.VMUtils;
import com.tyloo.web.WebAction;

public class ResetPwdAction extends WebAction {
	private static final ShopUserService service = (ShopUserService) ServiceLocator
			.getService("shopUserService");
	
	@Override
	public String webProcess(WebContext context, Object member)
			throws ServletException {
		
		context.put("action", "login");
		
		String insert = context.getParameter("insert");
		
		if(insert != null)
		{
			String pwdtext = context.getParameter("pwdtext");
			Object smodifykey = context.getRequest().getSession().getAttribute("smodifykey");
			
			String mtel = context.getParameter("mtel");
			String modifykey = context.getParameter("modifykey");
			
			if(StringUtils.isNotEmpty(modifykey)&& modifykey.equals(smodifykey) )
			{
				ShopUser user = service.getShopUserByMtel(mtel);

				// 验证密码合法性
				Pattern p = Pattern.compile("(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}");
				Matcher m = p.matcher(pwdtext);
				if (!m.matches()) {
					context.put("updated", "-2");
					context.getRequest().getSession().setAttribute("smodifykey", VMUtils.getRandomString(20));
					context.put("mtel", mtel);
					return "resetpwd";
				}
				else
				{
					user.setPwd(com.tyloo.web.util.MD5.encryptMD5(pwdtext));
					service.updateObject(user);
					context.put("updated", "0000");
					return "success";
				}
			}
			
		}
		else{
			return "findpwd";
		}
	
		return "success";
	}
	
    

}
