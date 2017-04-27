package com.tyloo.fw.dao;

import java.util.List;

import com.tyloo.fw.orm.Persistent;

@SuppressWarnings("unchecked")
public interface BaseDao {

	public Persistent load(final Class objClass, final int id)
			throws DAOException;
	
	public Persistent load(final Class objClass, final String id)
		throws DAOException;
	public List find(final String hql, final Object[] args) throws DAOException;

	public Persistent findSingle(final String hql, final Object[] args)
			throws DAOException;

	public List find(final String hql, final Object[] args, int startRows,
			int rows) throws DAOException;

	public int getCount(final String hql, final Object[] args)
			throws DAOException;

	public Persistent update(final Persistent obj) throws DAOException;

		
	public void delete(final Persistent obj) throws DAOException;

	public Object insert(final Persistent obj) throws DAOException;
	
	

	public int executeBySQL(final String naturePSQL, final Object[] params)
			throws DAOException;

	public int executeBySQL(final String naturePSQL, final int[] types,
			final Object[] params) throws DAOException;
	
	
	
	public List executeQueryBySQL(final String naturePSQL, final int[] types,
			final Object[] params) throws DAOException;
}