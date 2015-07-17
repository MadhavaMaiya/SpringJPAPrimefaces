/*
 * Created on Jul 31, 2014
 * @author Madhava
 */
package com.madhava.exception.specific;

import com.madhava.service.exception.ServiceFatalException;

/**
 * Class MandatoryParameterMissingFatalException
 * 
 * @author Madhava
 * @since Jul 31, 2014 - 4:14:02 PM
 * @version UserManagement 1.0
 */
public class MandatoryParameterMissingFatalException extends
		ServiceFatalException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6557081647304720459L;

	/**
	 * Constructor MandatoryParameterMissingFatalException
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 4:15:09 PM
	 * @version UserManagement 1.0
	 * @param message
	 */
	public MandatoryParameterMissingFatalException(String message) {
		super(message);
	}

	/**
	 * Constructor MandatoryParameterMissingFatalException
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 4:15:02 PM
	 * @version UserManagement 1.0
	 * @param message
	 * @param throwable
	 */
	public MandatoryParameterMissingFatalException(String message,
			Throwable throwable) {
		super(message, throwable);
	}

}
