package com.group.webFramework.uitl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.group.webFramework.exception.ApplicationException;

/**
 * 总体说明 日期转换工具类
 * 
 * <p>
 * 具体说明
 * </p>
 * 
 * @author Administrator
 * @version $Id: DateUtil.java,v 0.1 2015-5-27 下午1:11:54 Exp $
 */
public class DateUtil {
	public final static String DATE_FORMAT = "yyyy-MM-dd";
	public final static String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 将日期转换成yyyy-MM-dd格式的字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		return sdf.format(date);
	}

	/**
	 * 格式化日期，将日期按照指定格式转换成字符串
	 * 
	 * @param date
	 *            待格式化的日期
	 * @param formatStr
	 *            格式化所需的格式字符串
	 * @return
	 */
	public static String formatDate(Date date, String formatStr) {
		if (date == null || formatStr == null || formatStr.trim().equals("")) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		return sdf.format(date);
	}

	/**
	 * 将日期转换成年-月-日 时:分:秒格式的字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDateTime(Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT);
		return sdf.format(date);
	}

	/**
	 * 将格式为yyyy-MM-dd的字符串转换成日期
	 * 
	 * @param date
	 * @return
	 * @throws ApplicationException
	 */
	public static Date parseDate(String strDate) throws ApplicationException {
		if (strDate == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		try {
			return sdf.parse(strDate);
		} catch (ParseException e) {
			throw new ApplicationException("日期解析出错！", e);
		}
	}

	/**
	 * 将日期字符串按照格式化参数转换成日期
	 * 
	 * @param strDate
	 *            日期字符串
	 * @param formatStr
	 *            日期格式化字符串
	 * @return
	 * @throws ApplicationException
	 */
	public static Date parseDate(String strDate, String formatStr)
			throws ApplicationException {
		if (strDate == null || formatStr == null || formatStr.trim().equals("")) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		try {
			return sdf.parse(strDate);
		} catch (ParseException e) {
			throw new ApplicationException("日期解析出错！", e);
		}
	}

	/**
	 * 将格式为年-月-日 时:分:秒格式的字符串转换成日期
	 * 
	 * @param strDate
	 * @return
	 * @throws Exception
	 */
	public static Date parseDateTime(String strDate)
			throws ApplicationException {
		if (strDate == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT);
		try {
			return sdf.parse(strDate);
		} catch (ParseException e) {
			throw new ApplicationException("时间解析异常！", e);
		}
	}

	/**
	 * 将字符串日期转换成yyyyMM的形式，strDate格式必须"yyyy-MM-dd"。
	 * 
	 * @param strDate
	 * @return
	 * @throws Exception
	 */
	public static Integer getYM(String strDate) throws ApplicationException {
		if (strDate == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		Date date;
		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			throw new ApplicationException("时间解析异常！", e);
		}
		return getYM(date);
	}

	/**
	 * 将日期转换成yyyyMM的形式
	 * 
	 * @param date
	 * @return
	 */
	public static Integer getYM(Date date) {
		if (date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int yearno = cal.get(Calendar.YEAR);
		int monthno = cal.get(Calendar.MONTH) + 1;
		return new Integer(yearno * 100 + monthno);
	}

	/**
	 * @$comment 将ym向前或向后推add个月
	 * @param ym
	 *            格式为yyyymm的整型
	 * @param add
	 *            偏移量
	 * @return
	 */
	public static int addMonths(int ym, int add) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, (int) ym / 100);
		cal.set(Calendar.MONTH, ym % 100 - 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.MONTH, add);
		return getYM(cal.getTime()).intValue();
	}

	/**
	 * @$comment 将日期向前或向后推add个月
	 * @param oldDate
	 * @param add
	 * @return
	 */
	public static Date addMonths(Date oldDate, int add) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(oldDate);
		cal.add(Calendar.MONTH, add);
		return cal.getTime();
	}

	/**
	 * 将日期向前或向后推hours个小时
	 * 
	 * @param oldDate
	 * @param hour
	 * @return
	 */
	public static Date addHours(Date oldDate, int hour) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(oldDate);
		cal.add(Calendar.HOUR, hour);

		return cal.getTime();
	}

	/**
	 * @$comment 计算两个日期（yyyymm）之间的月数差，相同日期返回0
	 * @param sym
	 *            开始年月（小）
	 * @param eym
	 *            结束年月（大）
	 * @return
	 */
	public static int monthsBetween(int sym, int eym) {
		int between = ((int) (eym / 100)) * 12 + eym % 100
				- (((int) (sym / 100)) * 12 + sym % 100);
		return between;
	}

	/**
	 * @$comment 计算两个日期之间的月数差，忽略日，年月相同的日期返回0
	 * @param sdate
	 *            开始时间（小）
	 * @param edate
	 *            结束时间（大）
	 * @return
	 */
	public static int monthsBetween(Date sdate, Date edate) {
		return monthsBetween(getYM(sdate).intValue(), getYM(edate).intValue());
	}

	public static void main(String[] args) {
		try {
			// System.out
			// .println(formatDate(addMonths(parseDate("2006-01-06"), 12)));
		} catch (Exception e) {
			System.out.println(e);
		}

		String data = formatDateTime(new Date());
		Date date = new Date(data);

	}
}
