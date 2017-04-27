package com.tyloo.web.form;

import java.util.Date;

import com.tyloo.fw.waf.BasePOForm;

public class ProductsForm extends BasePOForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1655286553962715478L;
	private String name;// 名称
	private String img;// 图片
	private String goodsname;
	private String basetype;
	private String household;
	private String phone;
	private String address;
	private Integer isPublished;
	private String plantingtime;
	private String expectedmatur;
	private String position;
	private String number;
	
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public String getBasetype() {
		return basetype;
	}
	public void setBasetype(String basetype) {
		this.basetype = basetype;
	}
	public String getHousehold() {
		return household;
	}
	public void setHousehold(String household) {
		this.household = household;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getIsPublished() {
		return isPublished;
	}
	public void setIsPublished(Integer isPublished) {
		this.isPublished = isPublished;
	}
	public String getPlantingtime() {
		return plantingtime;
	}
	public void setPlantingtime(String plantingtime) {
		this.plantingtime = plantingtime;
	}
	public String getExpectedmatur() {
		return expectedmatur;
	}
	public void setExpectedmatur(String expectedmatur) {
		this.expectedmatur = expectedmatur;
	}
	
		
}
