package com.tyloo.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	/**
	 * @param interval
	 *            ֵ����
	 * @param number
	 *            ֵ������Ϊ����
	 * @param date
	 *            ԭʼֵ
	 * @return ���ֵ
	 */
	public static int dateAdd(String interval, int number, Date date) {
		long d = DateUtil.date2MysqlDate(date);
		long myTime = 0;
		if (interval.equals("d")) { // ��
			myTime = d + (60 * 60 * 24 * number);
		} else if (interval.equals("w")) { // ����
			myTime = d + (60 * 60 * 24 * (number * 7));
		} else if (interval.equals("m")) { // ��
			myTime = d + (60 * 60 * 24 * (number * 30));
		} else if (interval.equals("y")) { // ��
			myTime = d + (60 * 60 * 24 * (number * 365));
		} else if (interval.equals("h")) { // Сʱ
			myTime = d + (60 * 60 * number);
		} else if (interval.equals("n")) { // ����
			myTime = d + (60 * number);
		} else if (interval.equals("s")) { // ��
			myTime = d + number;
		}
		return (int) myTime;
	}

	/**
	 * @param interval
	 *            ֵ����
	 * @param number
	 *            ֵ������Ϊ����
	 * @param date
	 *            ԭʼֵ
	 * @return ���ֵ
	 */
	public static int dateAdd(String interval, int number, int datenum) {
		Long l = Long.valueOf("10000000000");
		if (datenum >= l.longValue())
			datenum = datenum / 1000;
		long d = datenum;
		long myTime = 0;
		if (interval.equals("d")) { // ��
			myTime = d + (60 * 60 * 24 * number);
		} else if (interval.equals("w")) { // ����
			myTime = d + (60 * 60 * 24 * (number * 7));
		} else if (interval.equals("m")) { // ��
			myTime = d + (60 * 60 * 24 * (number * 30));
		} else if (interval.equals("y")) { // ��
			myTime = d + (60 * 60 * 24 * (number * 365));
		} else if (interval.equals("h")) { // Сʱ
			myTime = d + (60 * 60 * number);
		} else if (interval.equals("n")) { // ����
			myTime = d + (60 * number);
		} else if (interval.equals("s")) { // ��
			myTime = d + number;
		}
		return (int) myTime;
	}

	public static int dateDiff(String interval, long date1, long date2) {
		Long l = Long.valueOf("10000000000");
		if (date1 >= l.longValue())
			date1 = date1 / 1000;
		if (date2 >= l.longValue())
			date2 = date2 / 1000;

		long d = 0;
		if (interval.equals("d")) { // ��
			d = (date1 - date2) / (24 * 60 * 60);
		} else if (interval.equals("w")) { // ����
			d = (date1 - date2) / (24 * 60 * 60 * 7);
		} else if (interval.equals("m")) { // ��
			d = (date1 - date2) / (24 * 60 * 60 * 30);
		} else if (interval.equals("y")) { // ��
			d = (date1 - date2) / (24 * 60 * 60 * 365);
		} else if (interval.equals("h")) { // Сʱ
			d = (date1 - date2) / (60 * 60);
		} else if (interval.equals("n")) { // ����
			d = (date1 - date2) / (60);
		} else if (interval.equals("s")) { // ��
			d = date1 - date2;
		}
		return (int) Math.abs(d);
	}

	/**
	 * ���ַ�ת���������͡�
	 * 
	 * @param String
	 *            �ַ�
	 * @param DateFormat
	 *            ���ڸ�ʽ
	 * @return Date ת���������
	 */
	public static Date getDate(String name, String df, Date defaultValue) {
		if (name == null) {
			return defaultValue;
		}

		SimpleDateFormat formatter = new SimpleDateFormat(df);

		try {
			return formatter.parse(name);
		} catch (ParseException e) {
		}

		return defaultValue;
	}

	public static Date getDateDf(String name, String df) {
		return getDate(name, df, null);
	}

	/**
	 * ���ַ�ת���������͡� ȱʡΪ��ǰϵͳʱ�䡣
	 * 
	 * @param String
	 *            �ַ�
	 */
	public static Date getDate(String name) {
		return getDate(name, null);
	}

	/**
	 * ���ַ�ת���������͡� ȱʡΪ��ǰϵͳʱ�䡣
	 * 
	 * @param String
	 *            �ַ�
	 */
	public static Date getDateTime(String name) {
		return getDateTime(name, null);
	}

	/**
	 * ���ַ�ת���������͡�
	 * 
	 * @param String
	 *            �ַ�
	 * @param DateFormat
	 *            ���ڸ�ʽ
	 * @return Date ת���������
	 */
	public static Date getDate(String name, Date defaultValue) {
		return getDate(name, "yyyy-MM-dd", defaultValue);
	}

	/**
	 * ���ַ�ת���������͡�
	 * 
	 * @param String
	 *            �ַ�
	 * @param DateFormat
	 *            ���ڸ�ʽ
	 * @return Date ת���������
	 */
	public static Date getDateTime(String name, Date defaultValue) {
		return getDate(name, "yyyy-MM-dd HH:mm:ss", defaultValue);
	}

	/**
	 * @param str
	 *            Ҫ�����ı�׼ʱ���ʽ
	 * @return UNIXʱ��
	 */
	public static int parseStr(String str) {
		if (str == "") {
			return 0;
		}
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ParsePosition pos = new ParsePosition(0);
		Date d1 = sd.parse(str, pos);
		return (int) (d1.getTime() / 1000);
	}

	/**
	 * @return �õ�����
	 */
	public static int getDatebyUnix(long l) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return DateUtil.parseStr(formatter.format(l) + " 00:00:00");
	}

	public static Date mysqlDate2Date(int seconds) {
		long l = (long) seconds * 1000;
		Date date = new Date(l);
		return date;
	}

	public static long date2MysqlDate(Date date) {
		return date.getTime() / 1000;
	}

	public static int date2MysqlDateInt(Date date) {
		long l = date2MysqlDate(date);
		return Integer.parseInt(l + "");
	}

	/**
	 * ����}�����ڵ�ʱ�����ص�ʱ����ʽ������: Calendar.YEAR, Calendar.MONTH, Calendar.DATE
	 * ע�⣺�ù��ܲ��õݹ�ķ�����Ч�ʻ��д������}��ʱ��֮��ϴ󣬶�Ҫ�󷵻ص�ʱ���ʽ�ֺ�С����ʱЧ�ʾͺܲ�
	 * ���˷�����Ҫ�󾫶Ƚϸߵ�����±Ƚ���Ч�������·ݲ��ʱ��ͱȽ�׼ȷ�����ǵ��˸�����������£�����
	 * 
	 * @param earlyDate
	 * @param lateDate
	 * @param returnTimeFormat
	 * @return time
	 */
	public static int getBetweenTime(Calendar earlyDate, Calendar lateDate,
			int returnTimeFormat) {
		earlyDate = (Calendar) earlyDate.clone();
		lateDate = (Calendar) lateDate.clone();
		int time = 0;
		while (earlyDate.before(lateDate)) {
			earlyDate.add(returnTimeFormat, 1);
			time++;
		}
		return time;
	}

	/**
	 * ����}�����ڵ�ʱ�����ص�ʱ����ʽ������: Calendar.YEAR, Calendar.MONTH, Calendar.DATE
	 * ע�⣺�ù��ܲ��õݹ�ķ�����Ч�ʻ��д������}��ʱ��֮��ϴ󣬶�Ҫ�󷵻ص�ʱ���ʽ�ֺ�С����ʱЧ�ʾͺܲ�
	 * ���˷�����Ҫ�󾫶Ƚϸߵ�����±Ƚ���Ч�������·ݲ��ʱ��ͱȽ�׼ȷ�����ǵ��˸�����������£�����
	 * 
	 * @param earlyDate
	 * @param lateDate
	 * @param returnTimeFormat
	 * @return time
	 */
	public static int getBetweenTime(Date earlyDate, Date lateDate,
			int returnTimeFormat) {
		Calendar cnow = Calendar.getInstance();
		cnow.setTime(earlyDate);
		Calendar clast = Calendar.getInstance();
		clast.setTime(lateDate);

		return getBetweenTime(cnow, clast, returnTimeFormat);
	}

	/**
	 * �õ����ʱ��������ڵ�����
	 * 
	 * @param last
	 * @return
	 */
	public static int getBetweenDays(Date begin, Date last) {
		return getBetweenTime(begin, last, Calendar.DATE);
	}

	/**
	 * �õ����ʱ��������ڵ�����
	 * 
	 * @param last
	 * @return
	 */
	public static int getBetweenHours(Date begin, Date last) {
		return getBetweenTime(begin, last, Calendar.HOUR_OF_DAY);
	}

	/**
	 * �õ����ʱ��������ڵķ�����
	 * 
	 * @param last
	 * @return
	 */
	public static int getBetweenMins(Date begin, Date last) {
		return getBetweenTime(begin, last, Calendar.MINUTE);
	}

	/**
	 * �õ����ʱ��������ڵ�����
	 * 
	 * @param last
	 * @return
	 */
	public static int getBetweenMonths(Date begin, Date last) {
		return getBetweenTime(begin, last, Calendar.MONTH);
	}

	/**
	 * �õ����ʱ��������ڵ�����
	 * 
	 * @param last
	 * @return
	 */
	public static int getBetweenYears(Date begin, Date last) {
		return getBetweenTime(begin, last, Calendar.YEAR);
	}

	/**
	 * �õ����ʱ��������ڵ�����
	 * 
	 * @param last
	 * @return
	 */
	public static int getBetweenDays(int last) {
		Calendar cnow = Calendar.getInstance();
		Calendar clast = Calendar.getInstance();
		clast.setTime(DateUtil.mysqlDate2Date(last));
		int between = getBetweenTime(clast, cnow, Calendar.DATE);
		return between;
	}

	public static String dateFormate(Date date, String formate) {
		if (date != null) {
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
					formate);
			return sdf.format(date);
		} else {
			return null;
		}
	}

	public static String dateFormateHuman(int seconds) {
		Date date = DateUtil.mysqlDate2Date(seconds);

		return dateFormateHuman(date);
	}

	public static String dateFormateHuman(Date date) {
		Calendar cnow = Calendar.getInstance();
		Calendar clast = Calendar.getInstance();
		cnow.setTime(new Date());
		clast.setTime(date);

		String format = "";
		if (cnow.get(Calendar.YEAR) == clast.get(Calendar.YEAR)
				&& cnow.get(Calendar.MONTH) == clast.get(Calendar.MONTH)
				&& cnow.get(Calendar.DATE) == clast.get(Calendar.DATE)) {
			format = "H:mm";
		} else if (cnow.get(Calendar.YEAR) == clast.get(Calendar.YEAR)) {
			format = "M��d��";
		} else {
			format = "yyyy��M��d��";
		}

		return dateFormate(date, format);
	}

	public static String getTimeBetweenHuman(int seconds) {
		return getTimeBetweenHuman(mysqlDate2Date(seconds));
	}

	public static String getTimeBetweenHuman(Date date) {
		Calendar cnow = Calendar.getInstance();
		Calendar clast = Calendar.getInstance();
		cnow.setTime(new Date());
		clast.setTime(date);
		String re = "";
		int b = 0;

		if (cnow.get(Calendar.YEAR) == clast.get(Calendar.YEAR)
				&& cnow.get(Calendar.MONTH) == clast.get(Calendar.MONTH)
				&& cnow.get(Calendar.DATE) == clast.get(Calendar.DATE)
				&& cnow.get(Calendar.HOUR_OF_DAY) == clast
						.get(Calendar.HOUR_OF_DAY)) {
			b = getBetweenMins(clast.getTime(), cnow.getTime());
			re = "����";
		} else if (cnow.get(Calendar.YEAR) == clast.get(Calendar.YEAR)
				&& cnow.get(Calendar.MONTH) == clast.get(Calendar.MONTH)
				&& cnow.get(Calendar.DATE) == clast.get(Calendar.DATE)) {
			b = getBetweenHours(clast.getTime(), cnow.getTime());
			re = "Сʱ";
		} else {
			b = getBetweenDays(clast.getTime(), cnow.getTime());
			re = "��";
		}

		return b + re;
	}

	public static String dateFormate(int seconds, String formate) {
		Date date = DateUtil.mysqlDate2Date(seconds);
		return dateFormate(date, formate);
	}

	/**
	 * ��������е�Сʱ�����ӣ���
	 * 
	 * @param date
	 * @return
	 */
	public static Date clearHMS(Date date) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.HOUR_OF_DAY, 0);
		now.set(Calendar.MINUTE, 0);
		now.set(Calendar.SECOND, 0);
		now.set(Calendar.MILLISECOND, 0);
		return now.getTime();
	}

	public static Date getNextDate(Date date) {
		if (date == null) {
			return null;
		}
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.DATE, now.get(Calendar.DATE) + 1);
		return now.getTime();
	}

	/**
	 * �õ���һ�µ�ʱ��
	 * 
	 * @param date
	 * @return
	 */
	public static Date getMonthGo(Date date) {
		if (date == null) {
			return null;
		}
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.MONTH, now.get(Calendar.MONTH) + 1);
		return now.getTime();
	}

	/**
	 * �õ���һ�µ�ʱ��
	 * 
	 * @param date
	 * @return
	 */
	public static Date getMonthUp(Date date) {
		if (date == null) {
			return null;
		}
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.MONTH, now.get(Calendar.MONTH) - 1);
		return now.getTime();
	}
	public static int getYear(Date date) {
		SimpleDateFormat yearFm = new SimpleDateFormat("yyyy");
		return Integer.parseInt(yearFm.format(date));
	}

	public static String getMonth(Date date) {
		SimpleDateFormat monthFm = new SimpleDateFormat("MM");
		return monthFm.format(date);
	}
}