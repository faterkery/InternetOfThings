package com.tyloo.web.form;

import com.tyloo.fw.waf.BaseForm;

public class ChangePwdForm extends BaseForm {
	private int id;
	private String oldPassword;
	private String newPassword;
	private String repeatPassword;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

}
