package com.tyloo.modules.service;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.mail.internet.MimeUtility;

import com.tyloo.modules.CommonService;
import com.tyloo.po.MailTemplte;
import com.tyloo.web.mail.MailInfo;

public class MailService extends CommonService {

	
	/**
	 *根据编号找到邮件模板
	 * @param code
	 * @return
	 */
	public MailTemplte getMailTemplteByCode(String code)
	{
		String hql = "from MailTemplte where numbers=? and isDeleted=0";
		MailTemplte mt = (MailTemplte)dao.findSingle(hql, new Object[] {code});
		return mt;
	}
	/**
	 * 根据编号发送邮件
	 * 
	 * @param code
	 */
	public void sendMail(String email, String title, String info, String nick) {
		try {
			MailInfo.mailinfo(email,MimeUtility.encodeText(title, "utf-8", "B"), info, nick);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
