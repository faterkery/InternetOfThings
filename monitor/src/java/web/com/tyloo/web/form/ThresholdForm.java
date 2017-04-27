package com.tyloo.web.form;

import java.util.Date;

import com.tyloo.fw.waf.BasePOForm;

public class ThresholdForm extends BasePOForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1655286553962715478L;
	private String name;// 名称Threshold
	private Integer max;
	private Integer min;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getMax() {
		return max;
	}
	public void setMax(Integer max) {
		this.max = max;
	}
	public Integer getMin() {
		return min;
	}
	public void setMin(Integer min) {
		this.min = min;
	}
}
