/*
* Created on Jul 31, 2014
* @author Madhava
*/
package com.madhava.filter.security;

import java.io.IOException;
import java.util.Map;


import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * Class CustomLogoutFilter
 * @author Madhava
 * @since Jul 31, 2014 - 5:56:03 PM
 * @version UserManagement 1.0
 */
public class CustomLogoutFilter extends LogoutFilter {

	@Resource(name="sessionMap")
	private Map<String, Object> sessionMap;
	/**
	 * Constructor CustomLogoutFilter
	 * @author Madhava
	 * @since Jul 31, 2014 - 5:56:18 PM
	 * @version UserManagement 1.0
	 * @param logoutSuccessHandler
	 * @param handlers
	 */
	public CustomLogoutFilter(LogoutSuccessHandler logoutSuccessHandler,
			LogoutHandler[] handlers) {
		super(logoutSuccessHandler, handlers);
	}

	/**
	 * Method doFilter
	 * @author Madhava
	 * @since Jul 31, 2014 - 5:58:30 PM
	 * @version UserManagement 1.0
	 * @param request
	 * @param response
	 * @param chain
	 * @throws IOException
	 * @throws ServletException
	 * @see org.springframework.security.web.authentication.logout.LogoutFilter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (sessionMap != null) {
			( (HttpServletRequest) request).setAttribute("loginUserType", sessionMap.get("j_loginType"));	
		}
		super.doFilter(request, response, chain);
	}
}
