package com.tyloo.web.eportalaction;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;

import net.sf.json.JSONObject;

import com.tyloo.fw.ServiceLocator;
import com.tyloo.fw.waf.WebContext;
import com.tyloo.modules.service.ShopUserService;
import com.tyloo.po.ShopUser;
import com.tyloo.web.WebAction;
import com.tyloo.web.po.ResultInfo;

public class FindPwdAjaxAction extends WebAction {
	private static final ShopUserService service = (ShopUserService) ServiceLocator
			.getService("shopUserService");
	@Override
	public String webProcess(WebContext context, Object member)
			throws ServletException {
		
		String phone = context.getParameter("mtel");
		ShopUser user = service.getShopUserByMtel(phone);
		JSONObject jsonObject = new JSONObject();;
		ResultInfo info = new ResultInfo();
		if(user != null)
		{
			
			info.setResult("success");
			info.setCode("0000");
			info.setMessage("存在");
			jsonObject = JSONObject.fromObject(info);
		}
		else
		{
			info.setResult("fail");
			info.setCode("0001");
			info.setMessage("不存在");
			jsonObject = JSONObject.fromObject(info);
		}
		
		System.out.println(jsonObject.toString());
		
		try {
			context.getResponse().getOutputStream().write(jsonObject.toString().getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

}
