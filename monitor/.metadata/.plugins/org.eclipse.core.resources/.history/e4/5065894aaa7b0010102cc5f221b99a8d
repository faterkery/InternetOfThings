package com.renhenet.fw.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.renhenet.fw.Config;
import com.renhenet.fw.orm.Persistent;
import com.renhenet.util.DateUtil;
@SuppressWarnings("unchecked")
public abstract class BaseHibernateDao extends HibernateDaoSupport implements
		BaseDao {

	private static Log log = LogFactory.getLog(BaseHibernateDao.class);

	private static final int QUERY_INFO_MS = Config.getInt(
			"sys.query.info.sec", 3) * 1000;

	private static final int QUERY_WARN_MS = Config.getInt(
			"sys.query.warn.sec", 5) * 1000;

	public final Persistent load(final Class objClass, final Serializable id)
			throws DAOException {
		Persistent entity = null;
		try {
			entity = (Persistent) getHibernateTemplate().load(objClass, id);
		} catch (DataAccessException e) {
			log.debug("load entity error: " + e);
			return null;
		} catch (Exception e) {
			log.debug("load entity error: " + e);
			return null;
		}

		return entity;
	}

	public final Persistent load(final Class objClass, final int id)
			throws DAOException {
		return load(objClass, new Integer(id));
	}

	public final Persistent load(final Class objClass, final String id)
			throws DAOException {
		return load(objClass, (Serializable) id);
	}

	public final List find(final String hql, final Object[] args)
			throws DAOException {
		long t = System.currentTimeMillis();
		try {
			List list = null;
			if (args == null) {
				list = getHibernateTemplate().find(hql);
			} else {
				list = getHibernateTemplate().find(hql, args);
			}
			long time = System.currentTimeMillis() - t;
			logQueryTime(hql, time);
			return list;

		} catch (DataAccessException e) {

			log.error("Find objects from database error:" + e);
			throw new DAOException(e);
		} catch (Throwable e) {

			log.error("Find objects from database error:" + e);
			throw new DAOException(e);
		}
	}

	public final Persistent findSingle(final String hql, final Object[] args)
			throws DAOException {
		Persistent p = null;
		List list = this.find(hql, args);
		if (list != null && list.size() > 0) {
			p = (Persistent) list.get(0);
		}
		return p;

	}

	public final List find(final String hql, final Object[] args,
			final int startRow, final int rows) throws DAOException {
		try {
			long t = System.currentTimeMillis();
			List list = null;
			list = (List) getHibernateTemplate().execute(
					new HibernateCallback() {
						public Object doInHibernate(Session session)
								throws HibernateException {
							Query query = session.createQuery(hql);
							// prepareQuery(queryObject);
							if (args != null && args.length > 0) {
								int l = args.length;
								for (int i = 0; i < l; i++) {
									query.setParameter(i, args[i]);
								}
							}
							if (rows > 0) {
								query.setMaxResults(rows);
							}

							query.setFirstResult(startRow);
							return query.list();
						}
					}, true);
			long time = System.currentTimeMillis() - t;
			logQueryTime(hql, time);
			return list;
		} catch (DataAccessException e) {
			e.printStackTrace();
			log.error("Find objects from database error:" + e);
			throw new DAOException(e);
		} catch (Throwable e) {

			log.error("Find objects from database error:" + e);
			throw new DAOException(e);
		}
	}

	public int getCount(final String hql, final Object[] args)
			throws DAOException {
		try {
			long t = System.currentTimeMillis();
			List l = getHibernateTemplate().executeFind(
					new HibernateCallback() {
						public Object doInHibernate(Session session)
								throws HibernateException {
							Query queryObject = session.createQuery(hql);
							if (args != null && args.length > 0) {
								for (int i = 0; i < args.length; i++) {
									queryObject.setParameter(i, args[i]);
								}
							}
							return queryObject.list();
						}
					});
			long time = System.currentTimeMillis() - t;
			logQueryTime(hql, time);
			if (l != null && l.size() > 0) {
				return Integer.parseInt(l.get(0) + "");
			} else {
				return 0;
			}

			// return ((Integer) l.get(0)).intValue();
		} catch (DataAccessException e) {
			log.error("getCount error: " + e);
			throw new DAOException(e);
		}

	}

	public final Persistent update(Persistent obj) throws DAOException {

		try {
			Date now = new Date();
			obj.setTimeModified(now);
			obj.setLastUpdatedDate((int) DateUtil.date2MysqlDate(now));
			getHibernateTemplate().update(obj);
		} catch (DataAccessException e) {

			log.error("update entity error: " + e);
			throw new DAOException(e);
		} catch (Throwable e) {

			log.error("update entity error: " + e);
			throw new DAOException(e);
		}

		return obj;
	}

	public final void delete(final Persistent obj) throws DAOException {

		try {
			getHibernateTemplate().delete(obj);
		} catch (DataAccessException e) {

			log.error("remove entity error: " + e);
			throw new DAOException(e);
		} catch (Throwable e) {

			log.error("remove entity error: " + e);
			throw new DAOException(e);
		}
	}

	public final Object insert(Persistent obj) throws DAOException {

		try {
			Date now = new Date();
			if (obj.getTimeCreate() == null) {
				obj.setTimeCreate(now);
			}
			obj.setTimeModified(now);
			if (obj.getCreatedDate() != null) {
				if (obj.getCreatedDate() == 0) {
					obj.setCreatedDate((int) DateUtil.date2MysqlDate(now));
				} else {
					obj.setCreatedDate(obj.getCreatedDate());
				}
			}
			obj.setLastUpdatedDate((int) DateUtil.date2MysqlDate(now));
			return getHibernateTemplate().save(obj);
		} catch (DataAccessException e) {
			log.error("insert entity error: " + e);
			throw new DAOException(e);
		} catch (Throwable e) {
			e.printStackTrace();
			log.error("insert entity error: " + e);
			throw new DAOException(e);
		}
	}

	public final Object insertByMod(Persistent obj) throws DAOException {
		try {
			return getHibernateTemplate().save(obj);
		} catch (DataAccessException e) {
			log.error("insert entity error: " + e);
			throw new DAOException(e);
		} catch (Throwable e) {
			e.printStackTrace();
			log.error("insert entity error: " + e);
			throw new DAOException(e);
		}
	}

	public final int executeBySQL(final String naturePSQL, final Object[] params)
			throws DAOException {
		return executeBySQL(naturePSQL, null, params);
	}

	public final int executeBySQL(final String naturePSQL, final int[] types,
			final Object[] params) throws DAOException {
		try {
			Integer updateCount = (Integer) getHibernateTemplate().execute(
					new HibernateCallback() {

						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							long t = System.currentTimeMillis();
							Connection c = session.connection();
							PreparedStatement pst = null;
							int result = 0;
							try {
								pst = c.prepareStatement(naturePSQL);
								if (types != null && params != null) {
									StatementUtils.setParameterValue(pst,
											types, params);

								} else if (params != null) {
									StatementUtils.setParameterValue(pst,
											params);
								}
								result = pst.executeUpdate();
							} finally {
								try {
									pst.close();
									pst = null;
								} catch (Exception e) {
									log.warn("Could not close JDBC Statement",
											e);
								}
							}
							long time = System.currentTimeMillis() - t;
							logQueryTime(naturePSQL, time);
							return new Integer(result);
						}
					});
			return updateCount.intValue();
		} catch (DataAccessException e) {
			log.error("executeBySQL error: " + e);
			throw new DAOException(e);
		}
	}

	public int getCountQueryBySQL(final String naturePSQL, final int[] types,
			final Object[] params) throws DAOException {
		long t = System.currentTimeMillis();
		int count = -1;
		List re = this.executeQueryBySQL(naturePSQL, types, params);
		if (re != null && re.size() > 0) {
			count = Integer.parseInt(((Object[]) re.get(0))[0] + "");
		}
		long time = System.currentTimeMillis() - t;
		logQueryTime(naturePSQL, time);
		return count;
	}

	public List executeQueryBySQL(final String naturePSQL, final int[] types,
			final Object[] params) throws DAOException {

		try {

			List list = (List) getHibernateTemplate().execute(
					new HibernateCallback() {

						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							long t = System.currentTimeMillis();
							Connection c = session.connection();
							PreparedStatement pst = null;
							List<Object[]> result = new Vector<Object[]>();
							ResultSet rs = null;
							try {
								pst = c.prepareStatement(naturePSQL);
								if (types != null && params != null) {
									StatementUtils.setParameterValue(pst,
											types, params);

								} else if (params != null) {
									StatementUtils.setParameterValue(pst,
											params);
								}

								rs = pst.executeQuery();
								ResultSetMetaData rsmd = rs.getMetaData();
								int colum = rsmd.getColumnCount();
								int[] type = new int[colum + 1];
								for (int i = 1; i <= colum; i++) {
									type[i] = rsmd.getColumnType(i);
								}
								while (rs.next()) {
									Object[] values = new Object[colum];
									for (int i = 1; i <= colum; i++) {
										switch (type[i]) {
										case Types.NUMERIC:
											values[i - 1] = new Integer(rs
													.getInt(i));
											break;
										case Types.VARCHAR:
											values[i - 1] = rs.getString(i);
											break;
										case Types.DATE:
											values[i - 1] = rs.getDate(i);
											break;
										case Types.TIMESTAMP:
											values[i - 1] = rs.getTimestamp(i);
											break;
										default:
											values[i - 1] = rs.getObject(i);
											break;
										}
									}
									result.add(values);
								}

							} finally {
								try {
									pst.close();
									pst = null;
									rs.close();
								} catch (Exception e) {
									log.warn("Could not close JDBC Statement",
											e);
								}
							}
							long time = System.currentTimeMillis() - t;
							logQueryTime(naturePSQL, time);
							return result;
						}
					});
			return list;
		} catch (DataAccessException e) {
			log.error("executeBySQL error: " + e);
			throw new DAOException(e);
		}
	}

	private void logQueryTime(String query, long time) {
		String content = time + " " + query;
		if (time > QUERY_WARN_MS) {
			log.warn(content);
		} else if (time > QUERY_INFO_MS) {
			log.info(content);
		} else {
			log.debug(content);
		}
	}
}