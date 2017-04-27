package com.renhenet.modules;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;

import com.renhenet.fw.dao.CommonDao;
import com.renhenet.fw.dao.DAOException;
import com.renhenet.fw.orm.Persistent;
import com.renhenet.fw.waf.BasePOForm;
import com.renhenet.util.BeanUtils;
import com.renhenet.util.searchcontext.SearchCondition;
import com.renhenet.util.searchcontext.SearchContext;
import com.renhenet.util.searchcontext.SearchOption;

@SuppressWarnings("unchecked")
public abstract class CommonService {

	protected CommonDao dao;

	public CommonDao getDao() {
		return dao;
	}

	public void setDao(CommonDao dao) {
		this.dao = dao;
	}

	/**
	 * 删除数据
	 * 
	 * @param id
	 */
	public void delObjectBySql(String tableName, int id) {
		Object[] a = new Object[] { new Integer(id) };
		dao.executeBySQL("delete from " + tableName + " where id =?", a);
	}

	/**
	 * 删除数据
	 * 
	 * @param id
	 */
	public void delObject(Class p, int id) {
		Persistent pp = this.getObjectById(p, id);
		if (p != null) {
			dao.delete(pp);
		}
	}

	public Persistent getObjectById(Class p, final Serializable id) {
		return dao.load(p, id);
	}

	public Persistent getObjectByIdFull(Class p, final Serializable id) {
		Persistent persistent = getObjectById(p, id);
		if (this instanceof Lazyable && persistent != null) {
			Lazyable lService = (Lazyable) this;
			lService.getLazyPro(persistent);
		}
		return persistent;
	}

	public Persistent updateObject(Persistent p) {
		return dao.update(p);
	}

	/**
	 * 从poform做update
	 * 
	 * @param form
	 * @return
	 */
	public Persistent updateObject(BasePOForm form, Class poClass) {
		Persistent p = this.getObjectById(poClass, form.getPKValue());
		if (p != null) {
			BeanUtils.copyProperties(p, form);
			return dao.update(p);
		} else {
			return null;
		}
	}

	/**
	 * 从poform做insert
	 * 
	 * @param form
	 * @return
	 */
	public Object insertObject(BasePOForm form, Class poClass) {
		try {
			Persistent p = (Persistent) poClass.newInstance();
			BeanUtils.copyProperties(p, form);
			return insertObject(p);
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new DAOException(e);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	public Object insertObject(Persistent p) {
		return dao.insert(p);
	}

	public void andOrWhere(StringBuffer where,
			SearchCondition.Condition condition) {
		if (!StringUtils.isEmpty(where.toString())
				&& where.toString().toLowerCase().indexOf("where") >= 0) {
			where.append(getAndOrBySearchConditon(condition));
		} else {
			where.append(" where ");
		}
	}

	public void andOrWhere(StringBuffer where) {
		this.andOrWhere(where, SearchCondition.Condition.and);
	}

	public List<Persistent> getBizObjList(SearchContext searchContext,
			String orderBy) {
		return this.getBizObjList(searchContext, orderBy, 0, 0);

	}

	@SuppressWarnings("unchecked")
	public List<Persistent> getBizObjList(SearchContext searchContext,
			String orderBy, int startRows, int rows) {
		StringBuffer query = new StringBuffer();
		query.append("select t from ").append(
				searchContext.getSearchClass().getName()).append(" as t ");
		List args = new ArrayList();
		StringBuffer where = new StringBuffer();
		getWhereHql(searchContext, args, where);
		query.append(where);

		if (StringUtils.isEmpty(orderBy)) {
			orderBy = searchContext.getOrderBy();
		}

		if (StringUtils.isEmpty(orderBy)) {
			orderBy = "desc";
		}

		String orderByField = "id";
		if (!StringUtils.isEmpty(searchContext.getOrderByField())) {
			orderByField = searchContext.getOrderByField();
		}
		query.append(" order by t.");
		query.append(orderByField);
		query.append(" ");
		query.append(orderBy);
		System.err.println("query:>>> " + query.toString());
		List<Persistent> fList = dao.find(query.toString(), args.toArray(),
				startRows, rows);
		return fList;

	}

	/**
	 * 得到list，包括lazy的属性
	 * 
	 * @param searchContext
	 * @param orderBy
	 * @param startRows
	 * @param rows
	 * @return
	 */
	public List<Persistent> getBizObjListFull(SearchContext searchContext,
			String orderBy, int startRows, int rows) {
		List<Persistent> fList = this.getBizObjList(searchContext, orderBy,
				startRows, rows);
		if (this instanceof Lazyable) {
			if (fList != null && fList.size() > 0) {
				for (Persistent persistent : fList) {
					Lazyable lService = (Lazyable) this;
					lService.getLazyPro(persistent);
				}
			}
		}

		return fList;
	}

	public List<Persistent> getBizObjListFull(SearchContext searchContext,
			String orderBy) {
		return this.getBizObjListFull(searchContext, orderBy, 0, 0);
	}

	public int getBizObjCount(SearchContext searchContext) {
		StringBuffer query = new StringBuffer();
		query.append("select count(*) from ").append(
				searchContext.getSearchClass().getName()).append(" as t ");
		List args = new ArrayList();
		StringBuffer where = new StringBuffer();
		getWhereHql(searchContext, args, where);
		query.append(where);
		System.err.println("count query:>>> " + query.toString());
		return dao.getCount(query.toString(), args.toArray());
	}

	/**
	 * 有SearchContext build search的hql
	 * 
	 * @param searchContext
	 * @param args
	 * @return
	 */
	private void getWhereHql(SearchContext searchContext, List args,
			StringBuffer where) {

		int ll = searchContext.getSearchContextSize();
		int l = searchContext.getSearchOptionSize();
		if ((l > 0 || ll > 0)) {
			if (where.length() <= 0) {
				where.append(" where");
			} else {
				if (!where.toString().endsWith("where")) {
					where.append(getAndOrBySearchConditon(searchContext
							.getCondition()));
				}
			}
		}

		if (l > 0) {

			// 处理不在searchcontext里的searchoption
			if (where.toString().trim().endsWith(")")) {
				where.append(" and ");
			}
			where.append("(");
			StringBuffer where1 = new StringBuffer();

			for (int i = 0; i < l; i++) {
				SearchOption searchOption = searchContext.getSearchOption(i);
				getHqlBySearchOption(args, where1, searchOption);
			}
			where.append(where1);
			where.append(")");
		}

		if (ll > 0) {
			for (int i = 0; i < ll; i++) {
				SearchContext context = searchContext.getSearchContext(i);
				getWhereHql(context, args, where);
			}
		}
	}

	protected String getAndOrBySearchConditon(
			SearchCondition.Condition condition) {
		String str = "";
		switch (condition) {
		case and:
			str = " and ";
			break;
		case or:
			str = " or ";
			break;
		}
		return str;
	}

	/**
	 * 根据searchOption得到HQL
	 * 
	 * @param args
	 * @param where
	 * @param searchOption
	 */
	@SuppressWarnings("unchecked")
	private void getHqlBySearchOption(List args, StringBuffer where,
			SearchOption searchOption) {
		// andOrWhere(where, searchOption.getCondition());
		if (where.length() > 0) {
			where.append(getAndOrBySearchConditon(searchOption.getCondition()));
		}
		where.append(" t.").append(searchOption.getFieldName());

		if (StringUtils.isEmpty(searchOption.getFieldName2())) {
			switch (searchOption.getOption()) {
			case eqaul:
				where.append(" = ? ");
				break;
			case noteqaul:
				where.append(" != ? ");
				break;
			case in:
				where.append(" in(" + searchOption.getValue() + ") ");
				break;
			case like:
				where.append(" like ? ");
				break;
			case bigthan:
				where.append(" > ? ");
				break;
			case smallthan:
				where.append(" < ? ");
				break;
			case bigthanandequal:
				where.append(" >= ? ");
				break;
			case smallthanandeqaul:
				where.append(" <= ? ");
				break;
			case isnull:
				where.append(" is null ");
				break;
			case isnotnull:
				where.append(" is not null ");
				break;
			}

			if (searchOption.getOption() != SearchOption.Option.in
					&& searchOption.getOption() != SearchOption.Option.isnotnull
					&& searchOption.getOption() != SearchOption.Option.isnull) {
				args.add(searchOption.getValue());
			}
		} else {
			switch (searchOption.getOption()) {
			case eqaul:
				where.append(" = ");
				break;
			case noteqaul:
				where.append(" != ");
				break;
			case bigthan:
				where.append(" >  ");
				break;
			case smallthan:
				where.append(" < ");
				break;
			case bigthanandequal:
				where.append(" >= ");
				break;
			case smallthanandeqaul:
				where.append(" <= ");
				break;
			}
			where.append(" t.").append(searchOption.getFieldName2());
		}

	}

	protected void initialize(Object object) {
		Hibernate.initialize(object);
	}

}
