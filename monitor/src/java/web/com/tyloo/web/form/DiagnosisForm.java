package com.tyloo.web.form;

import java.util.Date;

import com.tyloo.fw.waf.BasePOForm;

public class DiagnosisForm extends BasePOForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1655286553962715478L;
	private String name;
	private String resolvent;
	private String advice;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getResolvent() {
		return resolvent;
	}
	public void setResolvent(String resolvent) {
		this.resolvent = resolvent;
	}
	public String getAdvice() {
		return advice;
	}
	public void setAdvice(String advice) {
		this.advice = advice;
	}
	
}
