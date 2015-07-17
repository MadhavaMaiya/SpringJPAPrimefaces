/*
 * Created on Jul 31, 2014
 * @author Madhava
 */
package com.madhava.util.common;

import java.util.Collection;
import java.util.Map;

import com.madhava.exception.specific.MandatoryParameterMissingFatalException;
import com.madhava.service.exception.ServiceExpectedException;
import com.madhava.service.exception.ServiceFatalException;

/**
 * Class FormatManager
 * 
 * @author Madhava
 * @since Jul 31, 2014 - 5:15:38 PM
 * @version UserManagement 1.0
 */
public class FormatManager {

	/**
	 * Method checkExist
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 5:25:55 PM
	 * @version UserManagemenr 1.0
	 * @param input
	 * @param methodName
	 * @param parameterName
	 * @return
	 * @throws MandatoryParameterMissingFatalException
	 * @throws ServiceFatalException
	 * @throws ServiceExpectedException
	 */
	public static <T> T checkExist(T input, String methodName,
			String parameterName)
			throws MandatoryParameterMissingFatalException,
			ServiceFatalException, ServiceExpectedException {
		checkExistCheck(input, methodName, parameterName);
		if (input != null) {
			return input;
		} else {
			throw checkExistNULLException(input, methodName, parameterName);
		}
	}

	/**
	 * Method checkExistCheck
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 5:25:45 PM
	 * @version UserManagemenr 1.0
	 * @param input
	 * @param methodName
	 * @param parameterName
	 * @throws ServiceFatalException
	 * @throws ServiceExpectedException
	 */
	private static void checkExistCheck(Object input, String methodName,
			String parameterName) throws ServiceFatalException,
			ServiceExpectedException {
		if (FormatManager.isFilled(methodName)) {
			if (FormatManager.isFilled(parameterName)) {
				// ok
			} else {
				throw new ServiceFatalException("checkExist - parameterName '"
						+ parameterName
						+ "' is NULL or EMPTY. Here was input '" + input
						+ "', methodName '" + methodName
						+ "' and parameterName '" + parameterName + "'");
			}
		} else {
			throw new ServiceFatalException("checkExist - methodName '"
					+ methodName + "' is NULL or EMPTY. Here was input '"
					+ input + "', methodName '" + methodName
					+ "' and parameterName '" + parameterName + "'");
		}
	}

	/**
	 * Method checkExistCheck
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 5:25:35 PM
	 * @version UserManagemenr 1.0
	 * @param input
	 * @param methodName
	 * @param parameterName
	 * @param beanInputName
	 * @param beanInput
	 * @param beanInputName2
	 * @param beanInput2
	 * @throws ServiceFatalException
	 * @throws ServiceExpectedException
	 */
	private static void checkExistCheck(Object input, String methodName,
			String parameterName, String beanInputName, Object beanInput,
			String beanInputName2, Object beanInput2)
			throws ServiceFatalException, ServiceExpectedException {
		if (FormatManager.isFilled(methodName)) {
			if (FormatManager.isFilled(parameterName)) {
				if (FormatManager.isFilled(beanInputName)) {
					if (beanInput != null) {
						if (FormatManager.isFilled(beanInputName2)) {
							if (beanInput2 != null) {
								// ok
							} else {
								throw new ServiceFatalException(
										"checkExist - beanInputName2 is NULL. Here was input '"
												+ input + "', methodName '"
												+ methodName
												+ "', parameterName '"
												+ parameterName
												+ "', beanInputName '"
												+ beanInputName
												+ "', beanInput '" + beanInput
												+ "', beanInputName2 '"
												+ beanInputName
												+ "' and beanInput2 '"
												+ beanInput2 + "'");
							}
						} else {
							throw new ServiceFatalException(
									"checkExist - beanInputName2 '"
											+ beanInputName2
											+ "' is NULL or EMPTY. Here was input '"
											+ input + "', methodName '"
											+ methodName + "', parameterName '"
											+ parameterName
											+ "', beanInputName '"
											+ beanInputName + "', beanInput '"
											+ beanInput + "', beanInputName2 '"
											+ beanInputName
											+ "' and beanInput2 '" + beanInput2
											+ "'");
						}
					} else {
						throw new ServiceFatalException(
								"checkExist - beanInputName is NULL. Here was input '"
										+ input + "', methodName '"
										+ methodName + "', parameterName '"
										+ parameterName + "', beanInputName '"
										+ beanInputName + "', beanInput '"
										+ beanInput + "', beanInputName2 '"
										+ beanInputName + "' and beanInput2 '"
										+ beanInput2 + "'");
					}
				} else {
					throw new ServiceFatalException(
							"checkExist - beanInputName '" + beanInputName
									+ "' is NULL or EMPTY. Here was input '"
									+ input + "', methodName '" + methodName
									+ "', parameterName '" + parameterName
									+ "', beanInputName '" + beanInputName
									+ "', beanInput '" + beanInput
									+ "', beanInputName2 '" + beanInputName
									+ "' and beanInput2 '" + beanInput2 + "'");
				}
			} else {
				throw new ServiceFatalException("checkExist - parameterName '"
						+ parameterName
						+ "' is NULL or EMPTY. Here was input '" + input
						+ "', methodName '" + methodName + "', parameterName '"
						+ parameterName + "', beanInputName '" + beanInputName
						+ "', beanInput '" + beanInput + "', beanInputName2 '"
						+ beanInputName + "' and beanInput2 '" + beanInput2
						+ "'");
			}
		} else {
			throw new ServiceFatalException("checkExist - methodName '"
					+ methodName + "' is NULL or EMPTY. Here was input '"
					+ input + "', methodName '" + methodName
					+ "', parameterName '" + parameterName
					+ "', beanInputName '" + beanInputName + "', beanInput '"
					+ beanInput + "', beanInputName2 '" + beanInputName
					+ "' and beanInput2 '" + beanInput2 + "'");
		}
	}

	/**
	 * Method checkExist
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 5:25:24 PM
	 * @version UserManagemenr 1.0
	 * @param input
	 * @param methodName
	 * @param parameterName
	 * @param beanInputName
	 * @param beanInput
	 * @param beanInputName2
	 * @param beanInput2
	 * @return
	 * @throws MandatoryParameterMissingFatalException
	 * @throws ServiceFatalException
	 * @throws ServiceExpectedException
	 */
	public static <T> T checkExist(T input, String methodName,
			String parameterName, String beanInputName, Object beanInput,
			String beanInputName2, Object beanInput2)
			throws MandatoryParameterMissingFatalException,
			ServiceFatalException, ServiceExpectedException {
		checkExistCheck(input, methodName, parameterName, beanInputName,
				beanInput, beanInputName2, beanInput2);
		if (input != null) {
			return input;
		} else {
			throw checkExistNULLException(input, methodName, parameterName,
					beanInputName, beanInput, beanInputName2, beanInput2);
		}
	}

	/**
	 * Method checkExist
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 5:25:10 PM
	 * @version UserManagemenr 1.0
	 * @param input
	 * @param methodName
	 * @param parameterName
	 * @param beanInputName
	 * @param beanInput
	 * @return
	 * @throws MandatoryParameterMissingFatalException
	 * @throws ServiceFatalException
	 * @throws ServiceExpectedException
	 */
	public static <T> T checkExist(T input, String methodName,
			String parameterName, String beanInputName, Object beanInput)
			throws MandatoryParameterMissingFatalException,
			ServiceFatalException, ServiceExpectedException {
		checkExistCheck(input, methodName, parameterName, beanInputName,
				beanInput);
		if (input != null) {
			return input;
		} else {
			throw checkExistNULLException(input, methodName, parameterName,
					beanInputName, beanInput);
		}
	}

	/**
	 * Method checkExistCheck
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 5:25:01 PM
	 * @version UserManagemenr 1.0
	 * @param input
	 * @param methodName
	 * @param parameterName
	 * @param beanInputName
	 * @param beanInput
	 * @throws ServiceFatalException
	 * @throws ServiceExpectedException
	 */
	private static void checkExistCheck(Object input, String methodName,
			String parameterName, String beanInputName, Object beanInput)
			throws ServiceFatalException, ServiceExpectedException {
		if (FormatManager.isFilled(methodName)) {
			if (FormatManager.isFilled(parameterName)) {
				if (FormatManager.isFilled(beanInputName)) {
					if (beanInput != null) {
						// ok
					} else {
						throw new ServiceFatalException(
								"checkExist - beanInputName is NULL. Here was input '"
										+ input + "', methodName '"
										+ methodName + "', parameterName '"
										+ parameterName + "', beanInputName '"
										+ beanInputName + "' and beanInput '"
										+ beanInput + "'");
					}
				} else {
					throw new ServiceFatalException(
							"checkExist - beanInputName '" + beanInputName
									+ "' is NULL or EMPTY. Here was input '"
									+ input + "', methodName '" + methodName
									+ "', parameterName '" + parameterName
									+ "', beanInputName '" + beanInputName
									+ "' and beanInput '" + beanInput + "'");
				}
			} else {
				throw new ServiceFatalException("checkExist - parameterName '"
						+ parameterName
						+ "' is NULL or EMPTY. Here was input '" + input
						+ "', methodName '" + methodName + "', parameterName '"
						+ parameterName + "', beanInputName '" + beanInputName
						+ "' and beanInput '" + beanInput + "'");
			}
		} else {
			throw new ServiceFatalException("checkExist - methodName '"
					+ methodName + "' is NULL or EMPTY. Here was input '"
					+ input + "', methodName '" + methodName
					+ "', parameterName '" + parameterName
					+ "', beanInputName '" + beanInputName
					+ "' and beanInput '" + beanInput + "'");
		}
	}

	/**
	 * Method checkExistNULLException
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 5:24:52 PM
	 * @version UserManagemenr 1.0
	 * @param input
	 * @param methodName
	 * @param parameterName
	 * @param beanInputName
	 * @param beanInput
	 * @param beanInputName2
	 * @param beanInput2
	 * @return
	 */
	private static MandatoryParameterMissingFatalException checkExistNULLException(
			Object input, String methodName, String parameterName,
			String beanInputName, Object beanInput, String beanInputName2,
			Object beanInput2) {
		return new MandatoryParameterMissingFatalException(methodName + " - "
				+ parameterName + " is NULL. Here was " + beanInputName + " '"
				+ beanInput + "' and " + beanInputName2 + " '" + beanInput2
				+ "'");
	}

	/**
	 * Method checkExistNULLException
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 5:24:44 PM
	 * @version UserManagemenr 1.0
	 * @param input
	 * @param methodName
	 * @param parameterName
	 * @param beanInputName
	 * @param beanInput
	 * @return
	 */
	private static MandatoryParameterMissingFatalException checkExistNULLException(
			Object input, String methodName, String parameterName,
			String beanInputName, Object beanInput) {
		return new MandatoryParameterMissingFatalException(methodName + " - "
				+ parameterName + " is NULL. Here was " + beanInputName + " '"
				+ beanInput + "'");
	}

	/**
	 * Method checkExistNULLException
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 5:24:35 PM
	 * @version UserManagemenr 1.0
	 * @param input
	 * @param methodName
	 * @param parameterName
	 * @return
	 */
	private static MandatoryParameterMissingFatalException checkExistNULLException(
			Object input, String methodName, String parameterName) {
		return new MandatoryParameterMissingFatalException(methodName + " - "
				+ parameterName + " is NULL.");
	}

	/**
	 * Method isFilled
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 5:24:29 PM
	 * @version UserManagemenr 1.0
	 * @param myString
	 * @return
	 */
	public static final boolean isFilled(String myString) {
		return isFilledByUser(myString);
	}

	/**
	 * Method isFilledByUser
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 5:21:48 PM
	 * @version UserManagemenr 1.0
	 * @param theFieldPotentialyFilledByUser
	 * @return
	 */
	public static boolean isFilledByUser(String theFieldPotentialyFilledByUser) {
		return ((theFieldPotentialyFilledByUser != null) && (!theFieldPotentialyFilledByUser
				.trim().equals("")));
	}

	/**
	 * Method isFilled
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 5:21:54 PM
	 * @version UserManagemenr 1.0
	 * @param myStringBuffer
	 * @return
	 */
	public static boolean isFilled(StringBuffer myStringBuffer) {
		return ((myStringBuffer != null) && (myStringBuffer.length() > 0));
	}

	/**
	 * Method isStringBufferFilled
	 * 
	 * @author jbu
	 * @since 12 mai 2010 - 13:35:40
	 * @version OSRD 0.2
	 * @param myStringBuffer
	 * @return
	 */
	public static boolean isStringBufferFilled(StringBuffer myStringBuffer) {
		return isFilled(myStringBuffer);
	}

	/**
	 * Method isMapFilled
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 5:39:41 PM
	 * @version UserManagemenr 1.0
	 * @param myMap
	 * @return
	 */
	public static boolean isMapFilled(
			Map<? extends Object, ? extends Object> myMap) {
		return ((myMap != null) && (!myMap.isEmpty()));
	}

	/**
	 * Method isFilled
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 7:33:15 PM
	 * @version UserManagemenr 1.0
	 * @param myCollection
	 * @return
	 */
	public static final boolean isFilled(
			Collection<? extends Object> myCollection) {
		return isCollectionFilled(myCollection);
	}

	/**
	 * Method isCollectionFilled
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 7:33:24 PM
	 * @version UserManagemenr 1.0
	 * @param myCollection
	 * @return
	 */
	private static boolean isCollectionFilled(
			Collection<? extends Object> myCollection) {
		return ((myCollection != null) && (!myCollection.isEmpty()));
	}
}
