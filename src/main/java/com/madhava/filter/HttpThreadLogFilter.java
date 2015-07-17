/*
* Created on Jul 31, 2014
* @author Madhava
*/
package com.madhava.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import com.madhava.domain.common.Preferences;
import com.madhava.service.security.IUser;
import com.madhava.util.common.CommonUtils;

/**
 * Class HttpThreadLogFilter
 * @author Madhava
 * @since Jul 31, 2014 - 10:18:27 PM
 * @version UserManagement 1.0
 */
public class HttpThreadLogFilter implements Filter {

	private static final Logger LOGGER = Logger.getLogger(HttpThreadLogFilter.class);
	/**
	 * Method init
	 * @author Madhava
	 * @since Jul 31, 2014 - 10:18:27 PM
	 * @version UserManagement 1.5
	 * @param paramFilterConfig
	 * @throws ServletException
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig paramFilterConfig) throws ServletException {
	}

	/**
	 * Method doFilter
	 * @author Madhava
	 * @since Jul 31, 2014 - 10:18:27 PM
	 * @version UserManagement 1.5
	 * @param paramServletRequest
	 * @param paramServletResponse
	 * @param paramFilterChain
	 * @throws IOException
	 * @throws ServletException
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request,
			ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long time = System.currentTimeMillis();
		try {
			MDC.put("ipAddress", request.getRemoteAddr());
			MDC.put("user", getUsername(request));
			if (!"NOUSER".equals(MDC.get("user"))) {
				MDC.put("siteCode", getUserSiteCode());	
			}
			LOGGER.info("S URL->" + ( (HttpServletRequest) request).getRequestURI() );
			chain.doFilter(request, response);
		} finally {
			long differenceTime = System.currentTimeMillis()-time; 
			if ( differenceTime > 2000) {
				LOGGER.fatal("E URL->" + ( (HttpServletRequest) request).getRequestURI() + " finished in " + differenceTime + "ms");	
			} else {
				LOGGER.info("E URL->" + ( (HttpServletRequest) request).getRequestURI());	
			}
			MDC.remove("ipAddress");
			MDC.remove("user");
			MDC.remove("additionalInfo");
		}

	}

	/**
	 * Method getUserSiteCode
	 * @author Madhava
	 * @since Jul 31, 2014 - 10:21:34 PM
	 * @version UserManagemenr 1.0
	 * @return
	 */
	private Object getUserSiteCode() {
		Preferences preferences = CommonUtils.getLoggedInUserPreferences();
		if (preferences != null && preferences.getBranch() != null) {
			return preferences.getBranch().getCode();
		}
		return "NOBRANCH";
	}

	/**
	 * Method getUsername
	 * @author Madhava
	 * @since Jul 31, 2014 - 10:21:42 PM
	 * @version UserManagemenr 1.0
	 * @param request
	 * @return
	 */
	private Object getUsername(ServletRequest request) {
		HttpSession session = ((HttpServletRequest) request).getSession(Boolean.FALSE); 
		if (session!=null && session.getAttribute("username") != null) {
			return (String) session.getAttribute("username");
		}
		IUser user = CommonUtils.getLoggedInUser();
		if (user != null) {
			session.setAttribute("username", user.getUsername()); 
			return user.getUsername();
		}
		return "NOUSER";
	}

	/**
	 * Method destroy
	 * @author Madhava
	 * @since Jul 31, 2014 - 10:18:27 PM
	 * @version UserManagement 1.5
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		
	}

}
