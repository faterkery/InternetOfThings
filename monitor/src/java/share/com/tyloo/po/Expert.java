package com.tyloo.po;

import java.util.Date;

public class Expert extends com.tyloo.fw.orm.IdPersistent implements
		java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1655286553962715478L;
	
	private String name;// 名称Threshold
	private  int sex;// 图片
	private String age;
	private String title;
	private String studiec;
	private String goodat;
	private Integer isPublished;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStudiec() {
		return studiec;
	}
	public void setStudiec(String studiec) {
		this.studiec = studiec;
	}
	public String getGoodat() {
		return goodat;
	}
	public void setGoodat(String goodat) {
		this.goodat = goodat;
	}
	public Integer getIsPublished() {
		return isPublished;
	}
	public void setIsPublished(Integer isPublished) {
		this.isPublished = isPublished;
	}
	
	
	
		
}
