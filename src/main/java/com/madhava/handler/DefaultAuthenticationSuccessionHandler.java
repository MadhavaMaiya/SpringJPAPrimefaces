/*
 * Created on Jul 31, 2014
 * @author Madhava
 */
package com.madhava.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.madhava.domain.common.Feature;
import com.madhava.domain.common.Preferences;
import com.madhava.service.base.IBaseApplicationService;
import com.madhava.util.common.FormatManager;

/**
 * Class DefaultAuthenticationSuccessionHandler
 * 
 * @author Madhava
 * @since Jul 31, 2014 - 12:19:32 PM
 * @version UserManagement 1.0
 */
public class DefaultAuthenticationSuccessionHandler extends
		AbstractAuthenticationTargetUrlRequestHandler implements
		AuthenticationSuccessHandler {

	@Resource(name = "baseApplicationService")
	private IBaseApplicationService service;

	/**
	 * Method onAuthenticationSuccess
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 12:19:32 PM
	 * @version UserManagement 1.0
	 * @param request
	 * @param response
	 * @param authentication
	 * @throws IOException
	 * @throws ServletException
	 * @see org.springframework.security.web.authentication.AuthenticationSuccessHandler#onAuthenticationSuccess(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse,
	 *      org.springframework.security.core.Authentication)
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		handle(request, response, authentication);
		clearAuthenticationAttributes(request);
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.setMaxInactiveInterval(2700);// setting the session inactive
													// time to 45 minute
			session.setAttribute("j_loginType",
					request.getParameter("j_loginType"));
		}
	}

	/**
	 * Method clearAuthenticationAttributes : Removes temporary
	 * authentication-related data which may have been stored in the session
	 * during the authentication process.
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 12:21:47 PM
	 * @version UserManagemenr 1.0
	 * @param request
	 */
	private void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);

		if (session == null) {
			return;
		}

		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);

	}

	/**
	 * Method determineTargetUrl
	 * @author Madhava
	 * @since Jul 31, 2014 - 5:52:23 PM
	 * @version UserManagement 1.5
	 * @param request
	 * @param response
	 * @return
	 * @see org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler#determineTargetUrl(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected String determineTargetUrl(HttpServletRequest request,
			HttpServletResponse response) {
		String targetUrl = super.determineTargetUrl(request, response);
		if (request.getParameter("j_loginType") == null) {// for his users.
			try {
				Map<String, Object> criteria = new HashMap<String, Object>();
				criteria.put("userCode", request.getParameter("j_username"));
				List<?> preferenceList = service.load(Preferences.class, criteria);
				if (!FormatManager.isFilled(preferenceList)) {
					return targetUrl;
				}
				Preferences preferences = (Preferences) preferenceList.get(0);
				if (preferences.getDefaultPageId() != null
						&& preferences.getDefaultPageId() > 0) {
					Feature f = (Feature) service.find(Feature.class,
							preferences.getDefaultPageId());
					targetUrl = f.getPageUrl();
				}
			} catch (Exception e) {
				
			}
		}
		return targetUrl;
	}
}
