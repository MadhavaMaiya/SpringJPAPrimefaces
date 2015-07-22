/*
* Created on Jul 22, 2015
* @author Madhava
*/
package com.madhava.util.common;

import java.util.Map;

import com.madhava.service.exception.ServiceExpectedException;
import com.madhava.service.exception.ServiceFatalException;

/**
 * Class EnumUtil
 * @author Madhava
 * @since Jul 22, 2015 - 10:44:39 AM
 * @version UserManagement 1.0
 */
public class EnumUtil {

	/**
	 * Method resolveValue
	 * @author Madhava
	 * @since Jul 22, 2015 - 10:46:01 AM
	 * @version UserManagement 1.0
	 * @param index
	 * @param valueIndexed
	 * @return
	 * @throws ServiceFatalException
	 * @throws ServiceExpectedException
	 */
	public static <T,V> V resolveValue(T index,Map<T,V> valueIndexed) throws ServiceFatalException,ServiceExpectedException{
		if (FormatManager.isFilled(valueIndexed)){
			if (index!=null){
				if (valueIndexed.containsKey(index)){
					return valueIndexed.get(index);
				}
				else {
					throw new ServiceFatalException("resolveValue - index '"+index+"' is not in valueIndexed '"+valueIndexed+"'. Here was index '"+index+"' and valueIndexed '"+valueIndexed+"'");	
				}
			}
			else {
				return null;	
			}
		}
		else {
			throw new ServiceFatalException("resolveValue - valueIndexed '"+valueIndexed+"' is NULL or EMPTY. Here was index '"+index+"' and valueIndexed '"+valueIndexed+"'");
		}
	}
}
