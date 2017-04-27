package com.tyloo.po;

public class TbProvCityAreaStreet extends com.tyloo.fw.orm.IdPersistent implements java.io.Serializable {
	/**
	 * 省份
	 */
	private static final long serialVersionUID = 5470005984120867456L;
	private String code;
	private String parentId;
	private String name;
	private int level;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
