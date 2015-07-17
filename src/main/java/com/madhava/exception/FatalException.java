/*
* Created on Jul 31, 2014
* @author Madhava
*/
package com.madhava.exception;

/**
 * Class FatalException
 * @author Madhava
 * @since Jul 31, 2014 - 4:06:40 PM
 * @version UserManagement 1.0
 */
public class FatalException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6719722783113569380L;
	
	/**
	 * Constructor FatalException
	 * @author Madhava
	 * @since Jul 31, 2014 - 4:08:02 PM
	 * @version UserManagement 1.0
	 * @param message
	 * @param throwable
	 */
	public FatalException(String message, Throwable throwable) {
		super(message, throwable);
	}

	/**
	 * Constructor FatalException
	 * @author Madhava
	 * @since Jul 31, 2014 - 4:08:09 PM
	 * @version UserManagement 1.0
	 * @param message
	 */
	public FatalException(String message) {
		super(message);
	}
}
