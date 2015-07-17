/*
 * Created on Jul 31, 2014
 * @author Madhava
 */
package com.madhava.repo.security.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;


import com.madhava.domain.common.Preferences;
import com.madhava.domain.security.EnterpriseUser;
import com.madhava.repo.core.impl.BaseRepository;
import com.madhava.repo.security.IUserRepository;
import com.madhava.service.exception.ServiceExpectedException;
import com.madhava.service.exception.ServiceFatalException;
import com.madhava.util.common.FormatManager;

/**
 * Class UserRepository
 * 
 * @author Madhava
 * @since Jul 31, 2014 - 7:23:35 PM
 * @version UserManagement 1.0
 */
@Repository
public class UserRepository extends BaseRepository implements IUserRepository {

	private static Logger logger = Logger.getLogger(UserRepository.class
			.getName());
	/**
	 * Method findUser
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 7:23:35 PM
	 * @version UserManagement 1.5
	 * @param userName
	 * @return
	 * @throws ServiceExpectedException 
	 * @throws ServiceFatalException 
	 * @see com.madhava.repo.security.IUserRepository#findUser(java.lang.String)
	 */
	@Override
	public EnterpriseUser findUser(String userName) throws ServiceFatalException, ServiceExpectedException {
		try {
			EnterpriseUser user = null;
			String jpaQuery = " select user FROM com.madhava.domain.security.EnterpriseUser as user "
					+ "where user.username = ? ";
			ArrayList<Object> valueList = new ArrayList<Object>();
			valueList.add(userName);
			Collection<EnterpriseUser> usersList = getListDirectJPA(jpaQuery,
					valueList, 0, 1);
			if (FormatManager.isFilled(usersList)) {
				user = (EnterpriseUser) usersList.iterator().next();
				System.out.println("User: "+user); 
			}
			return user;
		} catch (Throwable e) {
			e.printStackTrace();
			throw new ServiceFatalException(
					"Exception thrown at getListDirectJPA method of Base Repository: ",
					e);
		} finally {

		}
	}

	/**
	 * Method getPreferences
	 * @author Madhava
	 * @since Aug 1, 2014 - 5:29:21 PM
	 * @version UserManagement 1.0
	 * @param usercode
	 * @return
	 * @throws ServiceFatalException
	 * @throws ServiceExpectedException
	 * @see com.madhava.repo.security.IUserRepository#getDefaultValue(java.lang.String)
	 */
	@Override
	public Preferences getPreferences(String usercode)  throws ServiceFatalException, ServiceExpectedException {
		Preferences preference = new Preferences();
		preference.setUserCode(usercode);

		Map<String, Object> criteria = new HashMap<String, Object>();	
		criteria.put("userCode", usercode);
		List<Preferences> preferenceList = find(Preferences.class, criteria);
		if (FormatManager.isFilled(preferenceList)) {
			preference = (Preferences) preferenceList.get(0);
			return preference;
		}
		else{
			return null;
		}
	}
}
