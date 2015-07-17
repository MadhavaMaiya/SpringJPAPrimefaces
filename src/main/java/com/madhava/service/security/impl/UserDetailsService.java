/**
 * 
 */
package com.madhava.service.security.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.madhava.repo.security.IUserRepository;
import com.madhava.service.exception.ServiceExpectedException;
import com.madhava.service.exception.ServiceFatalException;
import com.madhava.service.security.IUser;
import com.madhava.util.common.FormatManager;

/**
 * @author Madhava
 * 
 */
@Service
public class UserDetailsService implements
		org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private IUserRepository userRepository;

	@Resource(name = "sessionMap")
	private Map<String, Object> sessionMap;

	private static Logger logger = Logger.getLogger(UserDetailsService.class
			.getName());

	/**
	 * Method loadUserByUsername
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 6:23:53 PM
	 * @version UserManagement 1.5
	 * @param username
	 * @return
	 * @throws UsernameNotFoundException
	 * @throws DataAccessException
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		IUser user = null;
		logger.info("In UserDetailsService userName is..." + username);
		logger.info("userRepository is..." + userRepository);
		// if (sessionMap.get("j_loginType") == null) {
		try {
			if (FormatManager.isFilled(username)) {
				user = (IUser) userRepository.findUser(username);
				sessionMap.put("preferences",
						userRepository.getPreferences(username.toLowerCase()));
			}

		} catch (ServiceFatalException e) {
		} catch (ServiceExpectedException e) {
		}
		// }
		if (user == null) {
			logger.error("User not found");
			throw new UsernameNotFoundException("User \"" + username
					+ "\" does not exist");
		}
		User acegiUser = user.toAcegiUser();
		logger.error("################" + acegiUser);
		return acegiUser;
	}
}
