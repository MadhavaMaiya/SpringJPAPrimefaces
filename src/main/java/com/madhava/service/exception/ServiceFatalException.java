/*
* Created on Jul 31, 2014
* @author Madhava
*/
package com.madhava.service.exception;

import com.madhava.exception.FatalException;

/**
 * Class ServiceFatalException
 * @author Madhava
 * @since Jul 31, 2014 - 3:58:22 PM
 * @version UserManagement 1.0
 */
public class ServiceFatalException extends FatalException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7029891424242515078L;

	/**
	 * Constructor ServiceFatalException
	 * @author Madhava
	 * @since Jul 31, 2014 - 4:09:09 PM
	 * @version UserManagement 1.0
	 * @param message
	 * @param throwable
	 */
	public ServiceFatalException(String message, Throwable throwable) {
		super(message, throwable);
	}

	/**
	 * Constructor ServiceFatalException
	 * @author Madhava
	 * @since Jul 31, 2014 - 4:09:17 PM
	 * @version UserManagement 1.0
	 * @param message
	 */
	public ServiceFatalException(String message) {
		super(message);
	}
}
