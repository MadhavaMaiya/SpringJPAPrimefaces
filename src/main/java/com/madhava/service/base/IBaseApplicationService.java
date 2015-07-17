/*
* Created on Jul 31, 2014
* @author Madhava
*/
package com.madhava.service.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Class IBaseApplicationService
 * @author Madhava
 * @since Jul 31, 2014 - 1:13:53 PM
 * @version UserManagement 1.0
 */
public interface IBaseApplicationService {
	
	/**
	 * Method load
	 * @author Madhava
	 * @since Jul 31, 2014 - 1:15:40 PM
	 * @version UserManagemenr 1.0
	 * @param clazz
	 * @param criteria
	 * @return
	 */
	public List<?> load(final Class<?> clazz, final Map<String, Object> criteria);
	
	/**
	 * Method find
	 * @author Madhava
	 * @since Jul 31, 2014 - 2:47:08 PM
	 * @version UserManagemenr 1.0
	 * @param clazz
	 * @param key
	 * @return
	 */
	public Object find(Class<?> clazz, Serializable key);
}
