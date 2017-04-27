package com.tyloo.modules.member;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.tyloo.modules.CommonService;
import com.tyloo.po.Role;
import com.tyloo.po.RoleModule;

public class ModuleService extends CommonService {

	/**
	 * @return
	 */
	public List getModuleList() {
		String hql = "from Module where  isDeleted=0  ";
		return dao.find(hql, null);
	}
	
	public void updateRoleModules(int roleId, int[] modules, String[] pris) {
		if (roleId <= 0) {
			throw new IllegalArgumentException();
		}
		String sql = "delete from role_module where role_id = " + roleId;
		dao.executeBySQL(sql, null);
		if (modules != null && pris != null) {
			int x = modules.length;
			for (int i = 0; i < x; i++) {
				if (modules[i] > 0 && !StringUtils.isEmpty(pris[i])) {
					this.insertRoleModule(roleId, modules[i], pris[i]);
				}
			}
		}
	}
	
	public void insertRoleModule(int roleId, int moduleId, String pri) {
		RoleModule roleModule = new RoleModule();
		roleModule.setRoleId(roleId);
		roleModule.setModuleId(moduleId);
		roleModule.setPri(pri);
		dao.insert(roleModule);
	}
	
	
	/**
	 * 
	 * @param roleId
	 * @param moduleId
	 * @return
	 */
	public String getRoleModuleAccessPri(int roleId, int moduleId) {
		String can = Constants.PRI_NOT;
		if (roleId > 0 && moduleId > 0) {
			Role role = (Role) this.getObjectById(Role.class, roleId);
			return getRoleModuleAccessPri(role, moduleId);
		}
		return can;
	}
	
	/**
	 * 
	 * @param roleId
	 * @param moduleId
	 * @return
	 */
	public String getRoleModuleAccessPri(Role role, int moduleId) {
		String can = Constants.PRI_NOT;

		if (role != null && moduleId > 0) {

			String hql = "from RoleModule as t where t.isDeleted=0 and t.roleId = ? and t.moduleId = ?";
			RoleModule m = (RoleModule) dao.findSingle(hql, new Object[] {
					role.getId(), moduleId });
			if (m != null) {
				can = m.getPri();
			}

		}

		return can;
	}
}
