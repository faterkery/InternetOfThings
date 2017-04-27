package com.tyloo.po;

public class SmsValidate extends com.tyloo.fw.orm.IdPersistent implements
		java.io.Serializable {
	/**
	 * 短信验证
	 */
	private static final long serialVersionUID = 8525009671146462780L;
	private String phone; //电话
	private String yzm;   //验证码
	private int num;   //次数
	private long time;    //发送时的毫秒数
	private int isused;   //是否被使用  0可用 1被用
	private String sdate; //yyyyMMdd
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getYzm() {
		return yzm;
	}
	public void setYzm(String yzm) {
		this.yzm = yzm;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public int getIsused() {
		return isused;
	}
	public void setIsused(int isused) {
		this.isused = isused;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

}
