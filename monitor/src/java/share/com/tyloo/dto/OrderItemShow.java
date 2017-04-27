package com.tyloo.dto;


public class OrderItemShow {
	private Object cart;
	private Object goods;
	private double xiaoji;
	private int type;
	private String yb;
	private int xid;
	
	
	public int getXid() {
		return xid;
	}
	public void setXid(int xid) {
		this.xid = xid;
	}
	public String getYb() {
		return yb;
	}
	public void setYb(String yb) {
		this.yb = yb;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Object getGoods() {
		return goods;
	}
	public double getXiaoji() {
		return xiaoji;
	}
	public void setGoods(Object goods) {
		this.goods = goods;
	}
	public void setXiaoji(double xiaoji) {
		this.xiaoji = xiaoji;
	}
	public Object getCart() {
		return cart;
	}
	public void setCart(Object cart) {
		this.cart = cart;
	}
	
	
	

}
