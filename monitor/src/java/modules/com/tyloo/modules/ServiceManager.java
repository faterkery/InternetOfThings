package com.tyloo.modules;

import com.tyloo.fw.ServiceLocator;
import com.tyloo.modules.member.MemberService;
import com.tyloo.modules.service.ShopUserService;

public class ServiceManager
{
    
    private static MemberService memberService = (MemberService) ServiceLocator.getService("memberService");
    private static ShopUserService shopUserService = (ShopUserService) ServiceLocator.getService("shopUserService");
    
    public static MemberService getMemberService()
    {
        return memberService;
    }
    
    public static void setMemberService(MemberService memberService)
    {
        ServiceManager.memberService = memberService;
    }

	public static ShopUserService getShopUserService() {
		return shopUserService;
	}

	public static void setShopUserService(ShopUserService shopUserService) {
		ServiceManager.shopUserService = shopUserService;
	}
    
}
