package com.tyloo.web.eportalaction;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;

import com.tyloo.fw.ServiceLocator;
import com.tyloo.fw.waf.WebContext;
import com.tyloo.modules.service.ShopUserService;
import com.tyloo.po.ShopUser;
import com.tyloo.po.SmsValidate;
import com.tyloo.web.VMUtils;
import com.tyloo.web.WebAction;
import com.tyloo.web.po.ResultInfo;
import com.tyloo.web.util.LanzSMS;

public class EchartsShowAction extends WebAction {
	private static final ShopUserService service = (ShopUserService) ServiceLocator
			.getService("shopUserService");
    
	@Override
	public String webProcess(WebContext context, Object member)
			throws ServletException {
		
		return "show";
}
}