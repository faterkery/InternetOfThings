package com.tyloo.fw.waf;

import java.io.Serializable;

public abstract class BasePOForm extends BaseForm {
	
	private int companyId;
	
	private int id;

	public Serializable getPKValue() {
		return getId();
	}
	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
