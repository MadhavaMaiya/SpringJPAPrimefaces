/*
* Created on Jul 31, 2014
* @author Madhava
*/
package com.madhava.repo.core.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.madhava.exception.specific.MandatoryParameterMissingFatalException;
import com.madhava.repo.core.IBaseRepository;

import com.madhava.service.exception.ServiceExpectedException;
import com.madhava.service.exception.ServiceFatalException;
import com.madhava.util.common.FormatManager;

/**
 * Class BaseRepository
 * @author Madhava
 * @since Jul 31, 2014 - 3:20:34 PM
 * @version UserManagement 1.0
 */
@Repository
@Transactional(rollbackFor = { ServiceExpectedException.class,
		ServiceExpectedException.class, MandatoryParameterMissingFatalException.class })
public class BaseRepository implements IBaseRepository {

	@PersistenceContext(name="madhavaPersistanceUnit")
	protected EntityManager entityManager;

	private static final int PARAM_NUMBER_START = 1;
	
	protected Session getSession() {
		return (Session) entityManager.getDelegate();
	}
	
	private static Logger logger = Logger.getLogger(BaseRepository.class);

	/**
	 * Method find
	 * @author Madhava
	 * @since Jul 31, 2014 - 3:20:34 PM
	 * @version UserManagement 1.0
	 * @param clazz
	 * @param key
	 * @return
	 * @see com.madhava.repo.core.IBaseRepository#find(java.lang.Class, java.io.Serializable)
	 */
	@Override
	public Object find(Class<?> clazz, Serializable key) {
		return entityManager.find(clazz, key);
	}

	/**
	 * Method find
	 * @author Madhava
	 * @since Jul 31, 2014 - 3:20:34 PM
	 * @version UserManagement 1.0
	 * @param clazz
	 * @return
	 * @see com.madhava.repo.core.IBaseRepository#find(java.lang.Class)
	 */
	@Override
	public List<?> find(Class<?> clazz) {
		if (clazz == null) {
			throw new IllegalArgumentException("Class to list must not be null");
		}
		List<?> list = entityManager.createQuery(
				"from " + clazz.getName() + " entity").getResultList();

		// timer.done();
		return list;
	}


	/**
	 * Method find
	 * @author Madhava
	 * @since Jul 31, 2014 - 3:20:34 PM
	 * @version UserManagement 1.0
	 * @param clazz
	 * @param criteriaMap
	 * @return
	 * @see com.madhava.repo.core.IBaseRepository#find(java.lang.Class, java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> find(Class<T> clazz, Map<String, Object> criteriaMap) {
		Criteria criteria = getSession().createCriteria(clazz);
		Iterator<String> keys = criteriaMap.keySet().iterator();
		String key = null;
		while (keys.hasNext()) {
			key = keys.next();
			Object value = criteriaMap.get(key);
			if (value == null) {
				criteria.add(Restrictions.isNull(key));
			} else {
				if (value instanceof String) {
					criteria.add(Restrictions.like(key, criteriaMap.get(key))
							.ignoreCase());
				} else {
					criteria.add(Restrictions.eq(key, value));
				}
			}
		}
		List<T> list = criteria.list();
		return list;
	}

	/**
	 * Method getListDirectJPA
	 * @author Madhava
	 * @since Jul 31, 2014 - 7:59:42 PM
	 * @version UserManagement 1.0
	 * @param jpaStringQuery
	 * @param valueList
	 * @param rangeStart
	 * @param rangeEnd
	 * @return
	 * @throws ServiceFatalException
	 * @throws ServiceExpectedException
	 * @see com.madhava.repo.core.IBaseRepository#getListDirectJPA(java.lang.String, java.util.ArrayList, java.lang.Integer, java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T>java.util.Collection<T> getListDirectJPA(String jpaStringQuery,ArrayList<Object> valueList,Integer rangeStart,Integer rangeEnd) throws ServiceFatalException,ServiceExpectedException{
		try {
			//1 - Create Query
			Query query = entityManager.createQuery(jpaStringQuery);
			//2 - Value
			if (FormatManager.isFilled(valueList)){
				int parameterNumber = PARAM_NUMBER_START;
				for (Object value : valueList){
					query.setParameter(parameterNumber++,value);
				}
			}
			else {
				//No Parameter / Value
			}
			
			//3 - Range
			query.setFirstResult(rangeStart);
			query.setMaxResults(rangeEnd);
			
			java.util.Collection<T> result = query.getResultList();
			return result;
		}
		catch (Throwable e){
			throw new ServiceFatalException("Exception thrown at getListDirectJPA method of Base Repository: ",e);
		}
		finally {
			
		}
	}
	
	/**
	 * Method find
	 * @author Madhava
	 * @since Jul 17, 2015 - 10:15:54 AM
	 * @version UserManagement 1.0
	 * @param queryKey
	 * @param object
	 * @return
	 */
	public List<?> find(String queryKey, Object[] object) {
		// TestTimer timer = new TestTimer("---------- find of "+ queryKey + "
		// object --> " + object );
		logger.info("Executing Query name is------" + queryKey);
		if (queryKey == null) {
			throw new IllegalArgumentException("queryKey should not be null");
		}
		List<?> list = null;
		/*
		 * HibernateTemplate template = getHibernateTemplate(); template
		 * .setCacheQueries(true);
		 * logger.info(" DONE.. setCacheQueries DONE..");
		 */

		Query query = entityManager.createNamedQuery(queryKey);
		if (object != null && object.length > 0) {
			for (int i = 0; i < object.length; i++) {
				query.setParameter(i + 1, object[i]);
			}
		}
		list = query.getResultList();
		logger.info(" Result Size. " + list != null ? list.size()
				: " empty List");


		// timer.done();
		return list;
	}
}
