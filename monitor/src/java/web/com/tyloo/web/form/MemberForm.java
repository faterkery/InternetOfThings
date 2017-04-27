package com.tyloo.web.form;

import com.tyloo.fw.waf.BasePOForm;

public class MemberForm extends BasePOForm {
	private static final long serialVersionUID = -5426753310947380570L;

	private String loginName;


	private String password;
	private String isAdmin;
	private String tel;
	private Integer groupId;	
	private Integer roleId;	
	private Integer state;
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


	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
