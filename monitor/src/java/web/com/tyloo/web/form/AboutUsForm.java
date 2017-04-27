package com.tyloo.web.form;

import com.tyloo.fw.waf.BasePOForm;

public class AboutUsForm extends BasePOForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4623849648427913144L;
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