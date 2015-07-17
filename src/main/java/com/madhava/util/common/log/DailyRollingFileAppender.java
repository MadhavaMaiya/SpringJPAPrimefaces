/*
* Created on Aug 23, 2014
* @author Madhava
*/
package com.madhava.util.common.log;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.spi.LoggingEvent;

import com.madhava.util.common.CommonConstant;
import com.madhava.util.common.DateUtil;

/**
 * Class DailyRollingFileAppender
 * @author Madhava
 * @since Aug 23, 2014 - 1:19:19 PM
 * @version UserManagement 1.0
 */
public class DailyRollingFileAppender extends RollingFileAppender {
	private Date today = DateUtil.getDate(new Date(), CommonConstant.DISPLAY_DATE_PATTERN);
	private long nextCheckTime;
	private String datePattern;
	private SimpleDateFormat sdf;
	private String specifiedFileName;
	
	/**
	 * Method rolloverforDate
	 * @author Madhava
	 * @since Aug 23, 2014 - 5:56:20 PM
	 * @version UserManagemenr 1.0
	 */
	protected void rolloverforDate() {
		if (datePattern == null) {
		    errorHandler.error("Missing DatePattern option in rollOver().");
		    return;
		}

		String datedFilename = specifiedFileName+sdf.format(today)+".log";
		// It is too early to roll over because we are still within the
		// bounds of the current interval. Rollover will occur once the
		// next interval is reached.
		    if (fileName.equals(datedFilename)) {
		      return;
		    }

		    // close current file, and rename it to datedFilename
		    this.closeFile();

		    File target  = new File(datedFilename);
		    if (target.exists()) {
		      target.delete();
		    }

		    try {
		      // This will also close the file. This is OK since multiple
		      // close operations are safe.
		      this.setFile(datedFilename, false, this.bufferedIO, this.bufferSize);
		    } catch(IOException e) {
		      errorHandler.error("setFile("+fileName+", false) call failed.");
		    }
	}

	/**
	 * Method subAppend
	 * @author Madhava
	 * @since Aug 23, 2014 - 3:13:18 PM
	 * @version UserManagement 1.5
	 * @param event
	 * @see org.apache.log4j.RollingFileAppender#subAppend(org.apache.log4j.spi.LoggingEvent)
	 */
	@Override
	protected void subAppend(LoggingEvent event) {
		long currentTime = System.currentTimeMillis();
		if (currentTime > nextCheckTime) {
			
			nextCheckTime = DateUtil.getDateAfterSpecifiedDays(today, 1).getTime();
			today.setTime(currentTime);
			rolloverforDate();
		}
		super.subAppend(event);
	}
	
	
	/**
	 * Method getDatePattern
	 * @author Madhava
	 * @since Aug 23, 2014 - 5:56:49 PM
	 * @version UserManagemenr 1.0
	 * @return
	 */
	public String getDatePattern() {
		return datePattern;
	}

	/**
	 * Method setDatePattern
	 * @author Madhava
	 * @since Aug 23, 2014 - 5:56:40 PM
	 * @version UserManagemenr 1.0
	 * @param datePattern
	 */
	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
		 sdf = new SimpleDateFormat(datePattern);
		 nextCheckTime = DateUtil.getDateAfterSpecifiedDays(today, 1).getTime();
	}
	
	/**
	 * Method setFile
	 * @author Madhava
	 * @since Aug 23, 2014 - 3:13:29 PM
	 * @version UserManagement 1.5
	 * @param file
	 * @see org.apache.log4j.FileAppender#setFile(java.lang.String)
	 */
	@Override
	public void setFile(String file) {
		specifiedFileName = file;
		super.setFile(file+sdf.format(today)+".log");
	}

}
