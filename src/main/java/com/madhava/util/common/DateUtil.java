/*
* Created on Aug 23, 2014
* @author Madhava
*/
package com.madhava.util.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Class DateUtil
 * @author Madhava
 * @since Aug 23, 2014 - 3:09:24 PM
 * @version UserManagement 1.0
 */
public class DateUtil {
	
	/**
	 * Method getDate
	 * @author Madhava
	 * @since Aug 23, 2014 - 3:10:20 PM
	 * @version UserManagemenr 1.0
	 * @param date
	 * @param format
	 * @return
	 */
	public static Date getDate(Date date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		try {
			return dateFormat.parse(dateFormat.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Method getDateAfterSpecifiedDays
	 * @author Madhava
	 * @since Aug 23, 2014 - 3:13:07 PM
	 * @version UserManagemenr 1.0
	 * @param passedDate
	 * @param value
	 * @return
	 */
	public static Date getDateAfterSpecifiedDays(Date passedDate, int value) {
		Calendar calendar = getCalendar(passedDate);
		calendar.add(Calendar.DATE, value);
		return calendar.getTime();
	}
	
	/**
	 * Method getCalendar
	 * @author Madhava
	 * @since Aug 23, 2014 - 3:13:01 PM
	 * @version UserManagemenr 1.0
	 * @param currentDate
	 * @return
	 */
	public static Calendar getCalendar(Date currentDate){
		Calendar calendar =  Calendar.getInstance(TimeZone.getTimeZone(CommonConstant.WORKING_DATE_DATE_TIME_ZONE),new Locale(CommonConstant.WORKING_DATE_DATE_LANGUAGE,CommonConstant.WORKING_DATE_COUNTRY));
		calendar.setTime(currentDate);
		return calendar;
	}
}
