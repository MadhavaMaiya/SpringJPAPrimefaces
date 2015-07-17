/*
* Created on Jul 31, 2014
* @author Madhava
*/
package com.madhava.service.base.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.madhava.exception.specific.MandatoryParameterMissingFatalException;
import com.madhava.repo.core.IBaseRepository;
import com.madhava.service.base.IBaseApplicationService;
import com.madhava.service.exception.ServiceExpectedException;
import com.madhava.util.common.FormatManager;

/**
 * Class BaseApplicationService
 * @author Madhava
 * @since Jul 31, 2014 - 5:30:59 PM
 * @version UserManagement 1.0
 */
@Service
@Transactional(rollbackFor = { ServiceExpectedException.class,
		ServiceExpectedException.class, MandatoryParameterMissingFatalException.class })
public class BaseApplicationService implements IBaseApplicationService {

	@Resource(name = "baseRepository")
	private IBaseRepository baseRepository;

	//DI 
	protected IBaseRepository getBaseRepository() {
		return baseRepository;
	}
	
	/**
	 * Method load
	 * @author Madhava
	 * @since Jul 31, 2014 - 5:30:59 PM
	 * @version UserManagement 1.5
	 * @param clazz
	 * @param criteria
	 * @return
	 * @see com.madhava.service.base.IBaseApplicationService#load(java.lang.Class, java.util.Map)
	 */
	@Override
	public List<?> load(Class<?> clazz, Map<String, Object> criteria) {
		if(clazz!=null){
			if(FormatManager.isMapFilled(criteria)){
				return baseRepository.find(clazz, criteria);
			}
			else{
				throw new MandatoryParameterMissingFatalException("BaseApplicationService.load - criteria is Null or Empty '"+criteria+"'");
			}
		}
		else{
			throw new MandatoryParameterMissingFatalException("BaseApplicationService.load - clazz is Null '"+clazz+"'");
		}
	}

	/**
	 * Method find
	 * @author Madhava
	 * @since Jul 31, 2014 - 5:30:59 PM
	 * @version UserManagement 1.5
	 * @param clazz
	 * @param key
	 * @return
	 * @see com.madhava.service.base.IBaseApplicationService#find(java.lang.Class, java.io.Serializable)
	 */
	@Override
	public Object find(Class<?> clazz, Serializable key) {
		if(clazz!=null){
			if(key !=null){
				return baseRepository.find(clazz, key);
			}
			else{
				throw new MandatoryParameterMissingFatalException("BaseApplicationService.find - key is Null '"+key+"'");
			}
		}
		else{
			throw new MandatoryParameterMissingFatalException("BaseApplicationService.find - clazz is Null '"+clazz+"'");
		}
	}

}
