package com.tyloo.web.form;

import java.util.Date;

import com.tyloo.fw.waf.BasePOForm;

public class ModuleForm extends BasePOForm {
	private String name;

	private String memo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
}
