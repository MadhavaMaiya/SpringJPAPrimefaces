/*
* Created on Jul 31, 2014
* @author Madhava
*/
package com.madhava.service.security.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.RequestMatcher;

/**
 * Class ResquestMatcherImpl
 * @author Madhava
 * @since Jul 31, 2014 - 11:52:09 AM
 * @version UserManagement 1.0
 */
public class ResquestMatcherImpl implements RequestMatcher {

	private String startingWith = "/";
	/**
	 * Method matches
	 * @author Madhava
	 * @since Jul 31, 2014 - 11:52:09 AM
	 * @version UserManagement 1.0
	 * @param request
	 * @return
	 * @see org.springframework.security.web.util.RequestMatcher#matches(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public boolean matches(HttpServletRequest request) {
		return request.getRequestURI().startsWith(request.getContextPath()+startingWith);
	}

	/**
	 * Method setStartingWith
	 * @author Madhava
	 * @since Jul 31, 2014 - 11:53:25 AM
	 * @version UserManagemenr 1.0
	 * @param startingWith
	 */
	public void setStartingWith(String startingWith) {
		this.startingWith = startingWith;
	}
}
