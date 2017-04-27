package com.tyloo.fw.orm;

import java.io.Serializable;

@SuppressWarnings("serial")
public class IdPersistent extends Persistent {
	
	private Integer id;
	private Integer companyId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
    public String getPKField(){
    	return "id";
    }
    
    public Serializable getPKValue(){
    	return getId();
    }
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
}
