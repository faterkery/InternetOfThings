package com.renhenet.fw.waf;

import org.apache.commons.beanutils.*;
import java.text.SimpleDateFormat;
@SuppressWarnings("unchecked")
public class DateConvert implements Converter {
	static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	public DateConvert() {
	}

	public Object convert(Class type, Object value) {
		System.err.println("ok==========:" + value + " " + value.getClass());
		if (value instanceof String) {
			try {
				return df.parse((String) value);
			} catch (Exception ex) {
				throw new ConversionException("输入的日期类型不合乎yyyy-MM-dd"
						+ value.getClass());
			}
		} else {
			throw new ConversionException("输入的不是字符类型" + value.getClass());
		}
	}
}