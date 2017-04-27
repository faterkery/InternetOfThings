package com.tyloo.web.po;

public class ResultInfo {
	private String result; //成功 success，失败 fail
	private String code;   //返回信息编码
	private String message;
	private int totalPageNum;
	private int currentPage;
	private Object obj;
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getTotalPageNum() {
		return totalPageNum;
	}
	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
}
