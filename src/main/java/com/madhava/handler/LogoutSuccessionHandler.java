/*
* Created on Jul 31, 2014
* @author Madhava
*/
package com.madhava.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * Class LogoutSuccessionHandler
 * @author Madhava
 * @since Jul 31, 2014 - 10:29:56 PM
 * @version UserManagement 1.0
 */
@Component
public class LogoutSuccessionHandler extends
		AbstractAuthenticationTargetUrlRequestHandler implements
		LogoutSuccessHandler {

	/**
	 * Constructor LogoutSuccessionHandler
	 * @author Madhava
	 * @since Jul 31, 2014 - 10:30:20 PM
	 * @version UserManagement 1.0
	 */
	public LogoutSuccessionHandler() {
		setAlwaysUseDefaultTargetUrl(Boolean.TRUE);
	}
	/**
	 * Method onLogoutSuccess
	 * @author Madhava
	 * @since Jul 31, 2014 - 10:29:56 PM
	 * @version UserManagement 1.5
	 * @param request
	 * @param response
	 * @param authentication
	 * @throws IOException
	 * @throws ServletException
	 * @see org.springframework.security.web.authentication.logout.LogoutSuccessHandler#onLogoutSuccess(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.Authentication)
	 */
	@Override
	public void onLogoutSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {
		 super.handle(request, response, authentication);

	}

	/**
	 * Method determineTargetUrl
	 * @author Madhava
	 * @since Jul 31, 2014 - 10:31:30 PM
	 * @version UserManagement 1.5
	 * @param request
	 * @param response
	 * @return
	 * @see org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler#determineTargetUrl(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected String determineTargetUrl(HttpServletRequest request,
			HttpServletResponse response) {
		return super.determineTargetUrl(request, response);
	}
}
