package com.tyloo.fw.sms;

import java.util.List;
@SuppressWarnings("unchecked")
public interface SmsClient {
	public boolean registEx(String serialPassword);

	public boolean registDetailInfo(String eName, String linkMan,
			String phoneNum, String mobile, String email, String fax,
			String address, String postcode);

	public boolean sendSMS(String[] mobiles, String smsContent);

	public boolean sendSMS(String[] mobiles, String smsContent, String addExt);

	public List<SmsMO> getSmsMO();

	public List getSmsStatusReport();

	public int logoutService();
}
