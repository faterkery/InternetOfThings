package com.tyloo.fw.waf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;

/**
 * 日期转换对象，使用该转换器，在BaseForm当中做一下注册，系统自动地帮助字符的日期表示转换为java.util.Date对象.
 * 
 * @author adrian 2015-7-14
 */

@SuppressWarnings("unchecked")
public class DateConverter implements Converter {
	
	/*static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	public DateConverter() {
	}

	public Object convert(Class type, Object value) {
		System.err.println("ok==========:" + value + " " + value.getClass());
		if (value instanceof String) {
			try {
				return df.parse((String) value);
			} catch (Exception ex) {
				throw new ConversionException("������������Ͳ��Ϻ�yyyy-MM-dd"
						+ value.getClass());
			}
		} else {
			throw new ConversionException("����Ĳ����ַ�����" + value.getClass());
		}
	}*/

	/**
	 * 日期格式化对象.
	 */
	private static SimpleDateFormat df = new SimpleDateFormat();

	/**
	 * 模式集合.
	 */
	private static Set<String> patterns = new HashSet<String>();
	// 注册一下日期的转换格式
	static {
		DateConverter.patterns.add("yyyy-MM-dd");
		DateConverter.patterns.add("yyyy-MM-dd HH:mm");
		DateConverter.patterns.add("yyyy-MM-dd HH:mm:ss");
		DateConverter.patterns.add("yyyy/MM/dd HH:mm:ss");
	}

	/**
	 * 日期转换器.
	 * 
	 * @param type
	 *            Class
	 * @param value
	 *            Object return Date Object.
	 */
	public Object convert(Class type, Object value) {
		if (value == null) {
			throw new ConversionException("转换异常，value值不能为空，格式为yyyy-MM-dd"
					+ value.getClass());			
		} else if (value instanceof String) {
			Object dateObj = null;
			Iterator it = patterns.iterator();
			while (it.hasNext()) {
				try {
					String pattern = (String) it.next();
					df.applyPattern(pattern);
					dateObj = df.parse((String) value);
					break;
				} catch (ParseException ex) {
					// do iterator continue
				}
			}
			return dateObj;
		} else {
			return null;
		}
	}
}