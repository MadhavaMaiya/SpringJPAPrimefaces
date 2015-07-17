/**
 * 
 */
package com.madhava.repo.security;

import com.madhava.domain.common.Preferences;
import com.madhava.domain.security.EnterpriseUser;
import com.madhava.repo.core.IBaseRepository;
import com.madhava.service.exception.ServiceExpectedException;
import com.madhava.service.exception.ServiceFatalException;

/**
 * Class IUserRepository
 * @author Madhava
 * @since Aug 1, 2014 - 5:34:44 PM
 * @version UserManagement 1.0
 */
public interface IUserRepository  extends IBaseRepository{
	/**
	 * Method findUser
	 * @author Madhava
	 * @since Aug 1, 2014 - 5:34:32 PM
	 * @version UserManagemenr 1.0
	 * @param userName
	 * @return
	 * @throws ServiceFatalException
	 * @throws ServiceExpectedException
	 */
	public EnterpriseUser findUser(String userName) throws ServiceFatalException, ServiceExpectedException;
	
	/**
	 * Method getPreferences
	 * @author Madhava
	 * @since Aug 1, 2014 - 5:34:37 PM
	 * @version UserManagemenr 1.0
	 * @param usercode
	 * @return
	 * @throws ServiceFatalException
	 * @throws ServiceExpectedException
	 */
	public Preferences getPreferences(String usercode) throws ServiceFatalException, ServiceExpectedException;
}
