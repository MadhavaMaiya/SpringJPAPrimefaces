/*
* Created on Jul 31, 2014
* @author Madhava
*/
package com.madhava.exception;

/**
 * Class ExpectedException
 * @author Madhava
 * @since Jul 31, 2014 - 4:01:22 PM
 * @version UserManagement 1.0
 */
public class ExpectedException  extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5859848741150913737L;

	/**
	 * Constructor ExpectedException
	 * @author Madhava
	 * @since Jul 31, 2014 - 4:03:11 PM
	 * @version UserManagement 1.0
	 * @param message
	 * @param throwable
	 */
	protected ExpectedException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	/**
	 * Constructor ExpectedException
	 * @author Madhava
	 * @since Jul 31, 2014 - 4:03:06 PM
	 * @version UserManagement 1.0
	 * @param message
	 */
	protected ExpectedException(String message) {
		super(message);
	}
}
