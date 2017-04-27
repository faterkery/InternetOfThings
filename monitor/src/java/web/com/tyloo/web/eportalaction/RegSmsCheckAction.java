package com.tyloo.web.eportalaction;

import java.io.IOException;

import javax.servlet.ServletException;

import com.tyloo.fw.ServiceLocator;
import com.tyloo.fw.waf.WebContext;
import com.tyloo.modules.service.ShopUserService;
import com.tyloo.po.SmsValidate;
import com.tyloo.web.VMUtils;
import com.tyloo.web.WebAction;
import com.tyloo.web.po.ResultInfo;

public class RegSmsCheckAction extends WebAction {
	private static final ShopUserService service = (ShopUserService) ServiceLocator
			.getService("shopUserService");
    
	@Override
	public String webProcess(WebContext context, Object member)
			throws ServletException {
		String phone = context.getParameter("mtel");
		String sms = context.getParameter("smscode");
		ResultInfo info = new ResultInfo();
		String backStr = "";
		
		boolean bool =  validateSMS(phone, sms);
		if(bool)
		{
			info.setResult(AJAX_SUCCESS);
			info.setMessage("验证通过");
		}
		else
		{
			SmsValidate smsObj = service.getSendRecord(phone, sms);
			long currentMS = System.currentTimeMillis();
			
			info.setResult(AJAX_FAIL);
			if(smsObj!=null&&(currentMS - smsObj.getTime())> 300*1000)
			{
				info.setMessage("验证码超时");
			}
			else
			{
				info.setMessage("验证失败");
			}
			
			
		}
		
		backStr = VMUtils.toJsonStr(info);
		
		try {
			context.getResponse().getOutputStream().write(backStr.getBytes("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
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
		if((currentMS - smsObj.getTime())> 300*1000)
		{
			return false;
		}
		return true;
    }
}
