package com.tyloo.web.mail;

import com.tyloo.fw.Config;

public class MailInfo {
	public static void mailinfo(String mail, String Subject, String Content, String nick) {
		// 这个类主要是设置邮件
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost(Config.getString("MailServerHost"));
		mailInfo.setMailServerPort(Config.getString("MailServerPort"));
		mailInfo.setValidate(true);
		mailInfo.setUserName(Config.getString("UserName"));
		mailInfo.setPassword(Config.getString("Password"));// 您的邮箱密码
		mailInfo.setFromAddress(Config.getString("UserName"));
		mailInfo.setToAddress(mail);
		mailInfo.setSubject(Subject);
		mailInfo.setContent(Content);
		mailInfo.setNick(nick);
		// 这个类主要来发送邮件
		SimpleMailSender sms = new SimpleMailSender();
		sms.sendTextMail(mailInfo);// 发送文体格式
		// sms.sendHtmlMail(mailInfo); //发送html格式
	}
}
