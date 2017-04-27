package com.tyloo.po;

import java.io.Serializable;
import java.util.Date;

public class Module extends com.tyloo.fw.orm.IdPersistent implements
		Serializable {
	private static final long serialVersionUID = -273709655433700470L;

	private String name;

	private String memo;

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
