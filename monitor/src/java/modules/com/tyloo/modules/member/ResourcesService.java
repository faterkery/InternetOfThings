package com.tyloo.modules.member;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.tyloo.modules.CommonService;
import com.tyloo.po.Resources;

public class ResourcesService extends CommonService {
	public String getResourceValue(int id) {
		if (id > 0) {
			String hql = " from Resources where id=?";
			Resources resources = (Resources) dao.findSingle(hql,
					new Object[] { id });
			if (resources != null) {
				return resources.getValue();
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public String getResourceValue(String id) {
		if (!StringUtils.isEmpty(id)) {
			return this.getResourceValue(new Integer(id));
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Resources> getResourceByType(String type) {
		if (StringUtils.isEmpty(type)) {
			return null;
		}

		String hql = " from Resources where type =? and isDeleted=0";

		return dao.find(hql, new Object[] { type });
	}
	
	/**
	 * 根据value获得id
	 * @param value
	 * @return
	 */
	public int getResourceId(String value) {
		if (!StringUtils.isEmpty(value)) {
			String hql = " from Resources where value=? and isDeleted=0";
			Resources r = (Resources)dao.findSingle(hql, new Object[]{value});
			if(r != null)
			{
				return r.getId();
			}
			else
			{
				return 0;
			}
			
		} else {
			return 0;
		}
	}

}
