/**
 * 
 */
package com.madhava.service.security;

import org.springframework.security.core.userdetails.User;

/**
 * @author Madhava
 * 
 */
public interface IUser {
	/**
	 * Method toAcegiUser
	 * @author Madhava
	 * @since Jul 17, 2015 - 10:38:19 AM
	 * @version UserManagement 1.0
	 * @return
	 */
	public User toAcegiUser();

	/**
	 * Method getUsername
	 * @author Madhava
	 * @since Jul 17, 2015 - 10:38:25 AM
	 * @version UserManagement 1.0
	 * @return
	 */
	public String getUsername();

	/**
	 * Method getId
	 * @author Madhava
	 * @since Jul 17, 2015 - 10:38:30 AM
	 * @version UserManagement 1.0
	 * @return
	 */
	public Long getId();

	/**
	 * Method getUserFullName
	 * @author Madhava
	 * @since Jul 17, 2015 - 10:38:36 AM
	 * @version UserManagement 1.0
	 * @return
	 */
	public String getUserFullName();

}
