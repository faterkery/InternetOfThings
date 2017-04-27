package com.tyloo.modules.member;

import java.util.List;

import com.tyloo.modules.CommonService;
import com.tyloo.po.Role;
import com.tyloo.po.RoleModule;

public class RoleService extends CommonService {
	public void delObject(int id) {
		String sql = "delete from role_module where isDeleted=0 and role_id = ?";
		dao.executeBySQL(sql, new Object[] { id });
		super.delObject(RoleModule.class, id);
	}
	
	/**
	 * �õ���ɫ�����Ϣ
	 * @return
	 */
	public List<Role> getRole(){
		String hql="from Role where isDeleted=0 ";	
		return dao.find(hql, null);
	}

	public Role getCrmRoleByName(String name) {
		Object[] a = new Object[] { name };
		return (Role) dao.findSingle("from Role where isDeleted=0 and name = ?", a);
	}
}
