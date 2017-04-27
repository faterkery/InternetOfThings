package com.renhenet.modules.member;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.renhenet.modules.CommonService;
import com.renhenet.po.Resources;

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

		String hql = " from Resources where type =?";

		return dao.find(hql, new Object[] { type });
	}

}
