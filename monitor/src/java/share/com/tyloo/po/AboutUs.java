package com.tyloo.po;

public class AboutUs extends com.tyloo.fw.orm.IdPersistent implements
		java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1655286553962715478L;
	private String title;// 关于我们标题
	private String content;// 内容
	private int sortNum;// 排列序号

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public int getSortNum() {
		return sortNum;
	}
	public void setSortNum(int sortNum) {
		this.sortNum = sortNum;
	}
}
