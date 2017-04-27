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

public class RegSmsAction extends WebAction {
	private static final ShopUserService service = (ShopUserService) ServiceLocator
			.getService("shopUserService");
    private static String content = "(E螺杆短信校验码，请勿泄露，将在300秒后失效)";
    
	@Override
	public String webProcess(WebContext context, Object member)
			throws ServletException {
		String phone = context.getParameter("phone");
		ResultInfo info = new ResultInfo();
		String backStr = "";
		
		//验证账户唯一
		ShopUser f = service.getShopUserByMtel(phone);
		if(f!=null)
		{
			info.setResult(AJAX_FAIL);
			info.setMessage("账户已经被注册");
			info.setCode("0001");
		}
		else
		{
			SmsValidate smsObj = service.getSendRecord(phone);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String todayStr = sdf.format(new Date());
			if(smsObj==null)
			{
				//insert
				SmsValidate smsTemp = new SmsValidate();
				smsTemp.setPhone(phone);
				String yzm = creatYZM();
				smsTemp.setYzm(yzm);
				smsTemp.setNum(1);
				smsTemp.setTime(System.currentTimeMillis());
				smsTemp.setIsused(0);
				smsTemp.setSdate(todayStr);
				service.insertObject(smsTemp);
				//send
				LanzSMS.sendsms(phone, yzm+content);
				System.out.println(phone+"=="+yzm);
				info.setResult(AJAX_SUCCESS);
				info.setMessage("发送成功");
			}
			else
			{
				String sdate = smsObj.getSdate();
				if(todayStr.equals(sdate))
				{
					if(smsObj.getNum()>4)
					{
						info.setResult(AJAX_FAIL);
						info.setMessage("发送超出限制次数");
					}
					else
					{
						String yzm = creatYZM();
						smsObj.setYzm(yzm);
						smsObj.setTime(System.currentTimeMillis());
						smsObj.setNum(smsObj.getNum()+1); //累加
						service.updateObject(smsObj);
						//send
						LanzSMS.sendsms(phone, yzm+content);
						System.out.println(phone+"=="+yzm);
						info.setResult(AJAX_SUCCESS);
						info.setMessage("发送成功");
					}
				}
				else
				{
					String yzm = creatYZM();
					smsObj.setYzm(yzm);
					smsObj.setTime(System.currentTimeMillis());
					smsObj.setSdate(todayStr);
					smsObj.setNum(1); //第一次
					service.updateObject(smsObj);
					//send
					LanzSMS.sendsms(phone, yzm+content);
					System.out.println(phone +"=="+yzm);
					info.setResult(AJAX_SUCCESS);
					info.setMessage("发送成功");
				}
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
	
	
	
	private String creatYZM()
	{
		Random random = new Random();
		int x = random.nextInt(899999);
		x = x+100000;
		return x+"";
	}
}
