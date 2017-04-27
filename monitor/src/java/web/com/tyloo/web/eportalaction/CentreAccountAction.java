package com.tyloo.web.eportalaction;

import javax.servlet.ServletException;

import org.apache.commons.lang.StringUtils;

import com.tyloo.fw.ServiceLocator;
import com.tyloo.fw.waf.WebContext;
import com.tyloo.modules.service.ShopUserService;
import com.tyloo.po.ShopUser;
import com.tyloo.web.WebAction;

public class CentreAccountAction extends WebAction {
	private static final ShopUserService service = (ShopUserService) ServiceLocator
			.getService("shopUserService");
	
	@Override
	public String webProcess(WebContext context, Object member)
			throws ServletException {
		if(member == null)
		{
			return "/shopuser/login.html";
		}
		String insert = context.getParameter("insert");
		
		if(insert != null)
		{
			String img = context.getParameter("img");
			
			String trueName = context.getParameter("trueName");
			int sex = context.getIntParameter("sex");
			String companyName = context.getParameter("companyName");
			String email = context.getParameter("email");
			String qq = context.getParameter("qq");
			
			ShopUser user = (ShopUser)member;
			user.setImg(img);
			
			user.setTrueName(trueName);
			user.setSex(sex);
			user.setCompanyName(companyName);
			
			if(StringUtils.isNotEmpty(email))
			{
				user.setEmail(email);
			}
			
			user.setQq(qq);
			
			service.updateObject(user);
			context.put("updated", true);
			context.put("user", user);
			
		}
		context.put("user", member);
		context.put("action", "account");
		return DEFAULT_FORWARD;
	}

}
