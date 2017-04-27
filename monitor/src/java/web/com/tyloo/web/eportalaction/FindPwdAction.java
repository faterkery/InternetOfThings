package com.tyloo.web.eportalaction;

import javax.servlet.ServletException;

import com.tyloo.fw.ServiceLocator;
import com.tyloo.fw.waf.WebContext;
import com.tyloo.modules.service.ShopUserService;
import com.tyloo.po.SmsValidate;
import com.tyloo.web.VMUtils;
import com.tyloo.web.WebAction;

public class FindPwdAction extends WebAction {
	private static final ShopUserService service = (ShopUserService) ServiceLocator
			.getService("shopUserService");
	
	@Override
	public String webProcess(WebContext context, Object member)
			throws ServletException {
		
		context.put("action", "login");
		
		String insert = context.getParameter("insert");
		if(insert != null)
		{
			String mtel = context.getParameter("mtel");
			String sms = context.getParameter("code");
			boolean bool=  validateSMS(mtel, sms);
			
			if(bool)
			{
				context.put("mtel", mtel);
				context.getRequest().getSession().setAttribute("smodifykey", VMUtils.getRandomString(20));
				return "resetpwd";
			}
			else
			{
				context.put("info", "-1");
				context.put("mtel", mtel);
				return "findpwd";
			}
		}
		return "findpwd";
	}
	
    private boolean validateSMS(String phone, String vsms)
    {
    	//验证短信
		SmsValidate smsObj = service.getSendRecord(phone, vsms);
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
