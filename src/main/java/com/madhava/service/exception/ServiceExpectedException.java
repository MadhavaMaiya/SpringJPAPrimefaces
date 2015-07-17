/*
* Created on Jul 31, 2014
* @author Madhava
*/
package com.madhava.service.exception;


import com.madhava.exception.ExpectedException;
/**
 * Class ServiceExpectedException
 * @author Madhava
 * @since Jul 31, 2014 - 3:59:24 PM
 * @version UserManagement 1.0
 */
public class ServiceExpectedException  extends ExpectedException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1089626541175677669L;

	/**
	 * Constructor ServiceExpectedException
	 * @author Madhava
	 * @since Jul 31, 2014 - 4:04:43 PM
	 * @version UserManagement 1.0
	 * @param message
	 * @param throwable
	 */
	protected ServiceExpectedException(String message, Throwable throwable) {
		super(message, throwable);
	}

	/**
	 * Constructor ServiceExpectedException
	 * @author Madhava
	 * @since Jul 31, 2014 - 4:04:49 PM
	 * @version UserManagement 1.0
	 * @param message
	 */
	protected ServiceExpectedException(String message) {
		super(message);
	}
}
