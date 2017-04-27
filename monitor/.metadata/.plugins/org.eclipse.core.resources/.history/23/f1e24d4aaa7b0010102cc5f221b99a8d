package com.renhenet.util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;

public class NumberUtil {
	private static final NumberFormat nf = NumberFormat
			.getInstance(Locale.CHINA);

	/**
	 * Óë¼ÇËã²Ù×÷
	 * 
	 * @param value1
	 * @param value2
	 * @return
	 */
	public static boolean andOperate(int value1, int value2) {
		if ((value1 & value2) == value2) {
			return true;
		}
		return false;
	}

	public static int toInt(String str) {
		int re = 0;
		if (!StringUtils.isEmpty(str)) {
			try {
				re = nf.parse(str).intValue();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return re;
	}

	public static double toDouble(String str) {
		double re = 0;
		if (!StringUtils.isEmpty(str)) {
			try {
				re = nf.parse(str).doubleValue();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return re;
	}

	public static int getRandomInt(int min, int max) {
		return (int) Math.round(Math.random() * max + min);
	}

	public static int parseInt(String in) {
		int re = 0;
		if (!StringUtils.isEmpty(in)) {
			re = Integer.parseInt(in);
		}
		return re;
	}
}
