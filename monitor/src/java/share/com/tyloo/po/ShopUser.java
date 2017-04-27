package com.tyloo.po;

import java.io.Serializable;

import com.tyloo.fw.orm.IdPersistent;

public class ShopUser extends IdPersistent implements Serializable {

	/**
	 * 前台用户
	 */
	private static final long serialVersionUID = 6081656344120979389L;
	private String mtel;
	private String trueName;
	private String pwd;
	private int sex; //0女  1男  -1保密
	private String companyName;
	private String img;
	private String email;
	private int emailCheck; //0 未验证 1验证完成
	private String qq;
	
	
	public String getMtel() {
		return mtel;
	}
	public String getTrueName() {
		return trueName;
	}
	public String getPwd() {
		return pwd;
	}
	public int getSex() {
		return sex;
	}
	public String getCompanyName() {
		return companyName;
	}
	public String getImg() {
		return img;
	}
	public String getEmail() {
		return email;
	}
	public int getEmailCheck() {
		return emailCheck;
	}
	public void setMtel(String mtel) {
		this.mtel = mtel;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setEmailCheck(int emailCheck) {
		this.emailCheck = emailCheck;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	
	
}
