package com.renhenet.fw.orm;

import java.io.Serializable;

@SuppressWarnings("serial")
public class IdPersistent extends Persistent {
	
	private Integer id;
	
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
}
