package com.tyloo.po;

import com.tyloo.fw.orm.IdPersistent;

public class WishList extends IdPersistent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8993823610742695661L;
	private int cid;//对应原料或者耗材表ID
	private int type;//1原料  2耗材
	private int userid;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getCid() {
		return cid;
	}
	public int getType() {
		return type;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
	

}
