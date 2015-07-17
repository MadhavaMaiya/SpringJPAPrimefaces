/*
* Created on Jul 31, 2014
* @author Madhava
*/
package com.madhava.util.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.madhava.domain.common.Preferences;
import com.madhava.domain.common.view.EnterpriseUserView;
import com.madhava.domain.security.EnterpriseUser;
import com.madhava.domain.security.helper.SpringSecurityUser;
import com.madhava.service.security.IUser;

/**
 * Class CommonUtils
 * @author Madhava
 * @since Jul 31, 2014 - 8:11:49 PM
 * @version UserManagement 1.0
 */
public class CommonUtils {
	public static String dateFormat = CommonConstant.DISPLAY_DATE_PATTERN;

	/**
	 * Method getLoggedInUser
	 * @author Madhava
	 * @since Jul 31, 2014 - 8:13:32 PM
	 * @version UserManagemenr 1.0
	 * @return
	 */
	public static IUser getLoggedInUser() {
		IUser user = null;
		try {
			SpringSecurityUser tempUser = (SpringSecurityUser) SecurityContextHolder
					.getContext().getAuthentication().getPrincipal();
			if (EnterpriseUser.ENTERPRISE_USER_TYPE == tempUser.getUserType()) {
				user = new EnterpriseUser(tempUser.getId(), tempUser
						.getUsername(), tempUser.getUserFullName(), tempUser
						.isAccountNonExpired());
				((EnterpriseUser) user).setEmployee(tempUser.getEmployeeId());
			} 
		} catch (Exception ex) {
			return null;
		}
		return user;
	}

	/**
	 * Method getLoggedInUserPreferences
	 * @author Madhava
	 * @since Jul 31, 2014 - 8:14:06 PM
	 * @version UserManagemenr 1.0
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Preferences getLoggedInUserPreferences() {
		Preferences preferences = null;
		Map<String, Object> sessionMap = (Map<String, Object>) RequestContextHolder
				.getRequestAttributes().getAttribute("scopedTarget.sessionMap",
						RequestAttributes.SCOPE_SESSION);
		if (sessionMap.containsKey("preferences")) {
			preferences = (Preferences) sessionMap.get("preferences");
		}
		return preferences;
	}

	/**
	 * Method getLoggedInEnterpriseUserView
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:28:57 PM
	 * @version UserManagemenr 1.0
	 * @return
	 */
	public static IUser getLoggedInEnterpriseUserView() {
		IUser user = null;
		try {
			SpringSecurityUser tempUser = (SpringSecurityUser) SecurityContextHolder
					.getContext().getAuthentication().getPrincipal();
			if (EnterpriseUser.ENTERPRISE_USER_TYPE == tempUser.getUserType()) {
				user = new EnterpriseUserView(tempUser.getId(), tempUser
						.getUserFullName(), tempUser.isAccountNonExpired());
			}
		} catch (Exception ex) {
			return null;
		}
		return user;
	}

	/**
	 * Method getDateFormat
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:29:05 PM
	 * @version UserManagemenr 1.0
	 * @return
	 */
	public static String getDateFormat() {
		return dateFormat;
	}

	/**
	 * Method encryptPassword
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:29:15 PM
	 * @version UserManagemenr 1.0
	 * @param password
	 * @return
	 */
	public final static String encryptPassword(String password) {
		byte[] defaultBytes = password.getBytes();
		try {
			MessageDigest algorithm = MessageDigest.getInstance("md5");
			algorithm.reset();
			algorithm.update(defaultBytes);
			byte messageDigest[] = algorithm.digest();

			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < messageDigest.length; i++) {
				String hex = Integer.toHexString(0xff & messageDigest[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}

			return hexString + "";
		} catch (NoSuchAlgorithmException nsae) {
			nsae.printStackTrace();
		}

		return null;
	}

	/**
	 * Method getNow
	 * @author Madhava
	 * @since Aug 23, 2014 - 2:25:21 PM
	 * @version UserManagemenr 1.0
	 * @return
	 */
	public static Calendar getNow(){
		return Calendar.getInstance(TimeZone.getTimeZone(CommonConstant.WORKING_DATE_DATE_TIME_ZONE),new Locale(CommonConstant.WORKING_DATE_DATE_LANGUAGE,CommonConstant.WORKING_DATE_COUNTRY));
	}
}
