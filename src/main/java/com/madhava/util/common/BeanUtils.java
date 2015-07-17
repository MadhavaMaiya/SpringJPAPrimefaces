/*
* Created on Jul 31, 2014
* @author Madhava
*/
package com.madhava.util.common;

import java.util.Collection;

/**
 * Class BeanUtils
 * @author Madhava
 * @since Jul 31, 2014 - 9:46:28 AM
 * @version UserManagement 1.0
 */
public class BeanUtils {
	/**
	 * Method isNullOrZero
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:47:35 AM
	 * @version UserManagemenr 1.0
	 * @param id
	 * @return
	 */
	public static boolean isNullOrZero(Long id) {
		if (id == null || id.longValue() == 0)
			return Boolean.TRUE;
		return Boolean.FALSE;
	}

	/**
	 * Method isNull
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:47:40 AM
	 * @version UserManagemenr 1.0
	 * @param object
	 * @return
	 */
	public static boolean isNull(Object object) {
		return object == null;
	}

	/**
	 * Method isNullOrEmpty
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:47:48 AM
	 * @version UserManagemenr 1.0
	 * @param string
	 * @return
	 */
	public static boolean isNullOrEmpty(String theFieldPotentialyFilledByUser) {
		return theFieldPotentialyFilledByUser == null || theFieldPotentialyFilledByUser.trim().length() == 0;
	}

	/**
	 * Method isNullOrZero
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:47:55 AM
	 * @version UserManagemenr 1.0
	 * @param id
	 * @return
	 */
	public static boolean isNullOrZero(Integer id) {
		if (id == null || id.longValue() == 0)
			return Boolean.TRUE;
		return Boolean.FALSE;
	}

	/**
	 * Method isNullOrZero
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:48:00 AM
	 * @version UserManagemenr 1.0
	 * @param id
	 * @return
	 */
	public static boolean isNullOrZero(Float id) {
		if (id == null || id.floatValue() == 0.0F)
			return Boolean.TRUE;
		return Boolean.FALSE;
	}

	/**
	 * Method isNullOrZero
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:48:07 AM
	 * @version UserManagemenr 1.0
	 * @param id
	 * @return
	 */
	public static boolean isNullOrZero(Double id) {
		if (id == null || id.doubleValue() == 0.0d)
			return Boolean.TRUE;
		return Boolean.FALSE;
	}

	/**
	 * Method isNullOrEmpty
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:48:16 AM
	 * @version UserManagemenr 1.0
	 * @param id
	 * @return
	 */
	public static boolean isNullOrEmpty(Number id) {
		if (id == null || id.floatValue() == 0.0F || id.longValue() == 0)
			return Boolean.TRUE;
		return Boolean.FALSE;
	}

	/**
	 * Method isNullOrEmpty
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:48:25 AM
	 * @version UserManagemenr 1.0
	 * @param list
	 * @return
	 */
	public static boolean isNullOrEmpty(Collection<?> list) {
		if (list == null || list.isEmpty()) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
}
