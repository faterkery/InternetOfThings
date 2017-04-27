package com.tyloo.modules.member;

import com.tyloo.modules.CommonService;
import com.tyloo.po.RoleModule;

public class RoleModuleService extends CommonService {

	public RoleModule getRoleModule(int roleId, int moduleId) {
		String hql = "from RoleModule as t where t.isDeleted=0 and t.roleId = ? and t.moduleId = ?";
		return (RoleModule) dao.findSingle(hql,
				new Object[] { roleId, moduleId });
	}

}
