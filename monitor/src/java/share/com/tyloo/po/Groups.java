package com.tyloo.po;

import com.tyloo.fw.orm.IdPersistent;

public class Groups extends IdPersistent {
	private static final long serialVersionUID = -6667906075422589769L;

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
