/*
 * Created on Jul 31, 2014
 * @author Madhava
 */
package com.madhava.filter.security;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Class CustomAuthenticationProcessingFilter
 * 
 * @author Madhava
 * @since Jul 31, 2014 - 12:13:55 PM
 * @version UserManagement 1.0
 */
public class CustomAuthenticationProcessingFilter extends
		UsernamePasswordAuthenticationFilter {

	@Resource(name = "sessionMap")
	Map<String, Object> sessionMap;

	/**
	 * Method attemptAuthentication
	 * @author Madhava
	 * @since Jul 31, 2014 - 12:14:50 PM
	 * @version UserManagement 1.5
	 * @param request
	 * @param response
	 * @return
	 * @throws AuthenticationException
	 * @see org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter#attemptAuthentication(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {
		sessionMap.put("j_loginType", request.getParameter("j_loginType"));
		return super.attemptAuthentication(request, response);
	}

}
