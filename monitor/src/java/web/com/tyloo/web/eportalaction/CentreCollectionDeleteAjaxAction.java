package com.tyloo.web.eportalaction;

import java.io.IOException;

import javax.servlet.ServletException;

import com.tyloo.fw.ServiceLocator;
import com.tyloo.fw.waf.WebContext;
import com.tyloo.modules.service.ShopUserService;
import com.tyloo.po.WishList;
import com.tyloo.web.VMUtils;
import com.tyloo.web.WebAction;
import com.tyloo.web.po.ResultInfo;

public class CentreCollectionDeleteAjaxAction extends WebAction {
	private static ShopUserService shopUserService = (ShopUserService) ServiceLocator.getService("shopUserService");
	@Override
	public String webProcess(WebContext context, Object member)
			throws ServletException {
		
		ResultInfo resultinfo = new ResultInfo();
		if(member == null)
		{
			resultinfo.setResult(AJAX_FAIL);
			resultinfo.setCode("-1");
			resultinfo.setMessage("未登录");
		}
		
		int id = context.getSIntParameter("sid");
		shopUserService.delObject(WishList.class, id);
		resultinfo.setResult(AJAX_SUCCESS);
		
		try {
			context.getResponse().getOutputStream().write(VMUtils.toJsonStr(resultinfo).getBytes("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
