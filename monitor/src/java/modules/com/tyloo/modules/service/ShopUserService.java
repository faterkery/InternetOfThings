package com.tyloo.modules.service;

import java.util.List;
import java.util.Random;

import com.tyloo.modules.CommonService;
import com.tyloo.po.ShopUser;
import com.tyloo.po.SmsValidate;
import com.tyloo.po.WishList;

public class ShopUserService extends CommonService {

	public ShopUser getShopUserById(int id) {
		String hql = "from ShopUser where id=? and isDeleted=0";
		ShopUser user = (ShopUser) dao.findSingle(hql, new Object[] { id });
		return user;
	}
	
	public ShopUser getShopUserByUserName(String userName) {
		String hql = "from ShopUser where userName = ? and isDeleted=0";
		ShopUser user = (ShopUser) dao.findSingle(hql,
				new Object[] { userName });
		return user;
	}
	
	public ShopUser getShopUserByEmail(String email) {
		String hql = "from ShopUser where email = ? and isDeleted=0";
		ShopUser user = (ShopUser) dao.findSingle(hql, new Object[] { email });
		return user;
	}
	
	/**
	 * 根据mtel找到用户
	 * @param mtel
	 * @return
	 */
	public ShopUser getShopUserByMtel(String mtel)
	{
		String hql = "from ShopUser where mtel = ? and isDeleted=0";
		ShopUser user = (ShopUser) dao.findSingle(hql, new Object[] { mtel });
		return user;
	}
	
	/**
	 * 根据电话，密码获得user
	 * @param mtel
	 * @param pwd
	 * @return
	 */
	public ShopUser getShopUserByMtel(String mtel, String pwd)
	{
		String hql = "from ShopUser where mtel = ? and pwd = ? and isDeleted=0";
		ShopUser user = (ShopUser) dao.findSingle(hql, new Object[] { mtel, pwd });
		return user;
	}
	
	/**
	 * 发送记录
	 * @param phone
	 * @return
	 */
	public SmsValidate getSendRecord(String phone)
	{
		String hql = "from SmsValidate where phone=?";
		Object smsObj = dao.findSingle(hql, new Object[]{phone});
		if(smsObj==null)
		{
			return null;
		}
		else
		{
			return (SmsValidate)smsObj;
		}
		
	}
	
	public SmsValidate getSendRecord(String phone, String vsms)
	{
		String hql = "from SmsValidate where phone=? and yzm=? ";
		Object smsObj = dao.findSingle(hql, new Object[]{phone, vsms});
		if(smsObj==null)
		{
			return null;
		}
		else
		{
			return (SmsValidate)smsObj;
		}
		
	}
	
	
	/**
	 * 获得收藏信息
	 * @param userid
	 * @param type
	 * @param cid
	 * @return
	 */
	public WishList getIWish(int userid, int type, int cid)
	{
		String hql = "from WishList where userid =? and type =? and cid =? and isDeleted=0";
		return (WishList)dao.findSingle(hql, new Object[]{userid, type, cid});
	}
	
	public String getRandomString(int length) { // length表示生成字符串的长度
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}	
	/**
	 * 获得已经验证的邮箱
	 * @param code
	 * @return
	 */
	public ShopUser getUserByEmail(String email, int exceptid){
		String hql = "from ShopUser where email = ? and isDeleted=0 and emailCheckd=1 and id<>?";
		return (ShopUser)dao.findSingle(hql, new Object[]{email, exceptid});
	}
	
	
}