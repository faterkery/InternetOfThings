package com.tyloo.modules.member;


import java.util.List;

import com.tyloo.modules.CommonService;
import com.tyloo.po.Groups;

public class GroupsService extends CommonService {

	public Groups getCrmSalesGroup(int id) {
		return (Groups) this.getObjectById(Groups.class, id);
	}
	
	/**
	 * ���companyId�õ����������Ϣ
	 * @return
	 */
	public List<Groups> getGroupByCompanyId(int companyId){
		String hql="from Groups where isDeleted=0 and companyId=?";	
		return (List<Groups>) dao.find(hql, new Object[]{new Integer(companyId)});
	}
	
}
