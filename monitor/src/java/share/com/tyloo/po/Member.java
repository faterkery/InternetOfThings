package com.tyloo.po;

import java.util.Date;

public class Member extends com.tyloo.fw.orm.IdPersistent implements
		java.io.Serializable {

	private static final long serialVersionUID = 4557104755589524548L;

	private Integer id;

	private String loginName;


	private String password;
	
	private String tel;

	private String isAdmin;

	private Integer groupId;
	private Integer roleId;
	private Integer state;

	private Date timeCreate;

	private Date timeModified;
	
	private Integer userType;
    private Integer	shopId;
	


	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public Date getTimeCreate() {
		return timeCreate;
	}

	@Override
	public void setTimeCreate(Date timeCreate) {
		this.timeCreate = timeCreate;
	}

	@Override
	public Date getTimeModified() {
		return timeModified;
	}

	@Override
	public void setTimeModified(Date timeModified) {
		this.timeModified = timeModified;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}