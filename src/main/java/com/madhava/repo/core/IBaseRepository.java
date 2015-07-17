/**
 * 
 */
package com.madhava.repo.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.madhava.service.exception.ServiceExpectedException;
import com.madhava.service.exception.ServiceFatalException;

/**
 * @author Madhava
 *
 */
public interface IBaseRepository {

	
	/**
	 * Method find
	 * @author Madhava
	 * @since Jul 31, 2014 - 3:12:47 PM
	 * @version UserManagemenr 1.0
	 * @param clazz
	 * @param key
	 * @return
	 */
	public Object find(Class<?> clazz, Serializable key);

	/**
	 * Method find
	 * @author Madhava
	 * @since Jul 31, 2014 - 3:13:47 PM
	 * @version UserManagemenr 1.0
	 * @param clazz
	 * @return
	 */
	public List<?> find(Class<?> clazz);


	/**
	 * Method find
	 * @author Madhava
	 * @since Jul 31, 2014 - 3:15:32 PM
	 * @version UserManagemenr 1.0
	 * @param clazz
	 * @param criteriaMap
	 * @return
	 */
	public <T> List<T> find(Class<T> clazz, Map<String, Object> criteriaMap);

	/**
	 * Method getListDirectJPA
	 * @author Madhava
	 * @since Jul 31, 2014 - 7:56:59 PM
	 * @version UserManagemenr 1.0
	 * @param jpaStringQuery
	 * @param valueList
	 * @param rangeStart
	 * @param rangeEnd
	 * @return
	 * @throws ServiceFatalException
	 * @throws ServiceExpectedException
	 */
	public <T> Collection<T> getListDirectJPA(String jpaStringQuery,
			ArrayList<Object> valueList, Integer rangeStart, Integer rangeEnd)
			throws ServiceFatalException, ServiceExpectedException;

}
