package com.renhenet.fw.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StatementUtils {
	public static int TYPE_UNKNOWN = Integer.MIN_VALUE;

	@SuppressWarnings("unused")
	private static final Log log = LogFactory.getLog(StatementUtils.class);

	public static void setParameterValue(PreparedStatement ps,
			final int[] types, final Object[] params) throws SQLException {

		for (int i = 0; i < params.length; i++) {
			setParameterValue(ps, i + 1, types[i], params[i]);
		}

	}
	public static void setParameterValue(PreparedStatement ps,
			final Object[] params) throws SQLException {

		for (int i = 0; i < params.length; i++) {
			setParameterValue(ps, i + 1, TYPE_UNKNOWN, params[i]);
		}

	}
	public static void setParameterValue(PreparedStatement ps,
			final Object param) throws SQLException {
		ps.setObject(1, param);

	}

	public static void setParameterValue(PreparedStatement ps, int type,
			final Object param) throws SQLException {
		ps.setObject(1, param, type);

	}

	public static void setParameterValue(PreparedStatement ps, int paramIndex,
			int sqlType, Object inValue) throws SQLException {

		if (inValue == null) {
			if (sqlType == TYPE_UNKNOWN) {
				ps.setObject(paramIndex, inValue);
			} else {
				ps.setNull(paramIndex, sqlType);
			}
		}

		else {
			if (sqlType == TYPE_UNKNOWN) {
				ps.setObject(paramIndex, inValue);
			} else if (sqlType == Types.VARCHAR) {
				ps.setString(paramIndex, inValue.toString());
			} else if (sqlType == Types.DATE) {
				if ((inValue instanceof java.util.Date)
						&& !(inValue instanceof java.sql.Date)) {
					inValue = new java.sql.Date(((java.util.Date) inValue)
							.getTime());
				}
				ps.setObject(paramIndex, inValue, Types.DATE);
			} else if (sqlType == Types.TIME) {
				if ((inValue instanceof java.util.Date)
						&& !(inValue instanceof java.sql.Time)) {
					inValue = new java.sql.Time(((java.util.Date) inValue)
							.getTime());
				}
				ps.setObject(paramIndex, inValue, Types.TIME);
			} else if (sqlType == Types.TIMESTAMP) {
				if ((inValue instanceof java.util.Date)
						&& !(inValue instanceof java.sql.Timestamp)) {
					inValue = new java.sql.Timestamp(((java.util.Date) inValue)
							.getTime());
				}
				ps.setObject(paramIndex, inValue, Types.TIMESTAMP);
			} else {
				ps.setObject(paramIndex, inValue, sqlType);
			}
		}
	}
}