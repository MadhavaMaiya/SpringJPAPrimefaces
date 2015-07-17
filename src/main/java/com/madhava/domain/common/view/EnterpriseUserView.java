/*
* Created on Jul 31, 2014
* @author Madhava
*/
package com.madhava.domain.common.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;
import org.springframework.security.core.userdetails.User;

import com.madhava.service.security.IUser;

/**
 * Class EnterpriseUserView
 * @author Madhava
 * @since Jul 31, 2014 - 8:16:41 PM
 * @version UserManagement 1.0
 */

@Entity
@Indexed
@Audited
@Table(name="HISUSER")
public class EnterpriseUserView implements IUser {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	
	@Column(name="USERNAME", length=100, nullable=false)
	private String userFullName;
	
	@Column(name="ISACTIVE", nullable=false)
	private Boolean isActive = Boolean.TRUE;
	
	/**
	 * Constructor EnterpriseUserView
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:11:35 PM
	 * @version UserManagement 1.0
	 */
	public EnterpriseUserView() {
		super();
	}
	
	/**
	 * Constructor EnterpriseUserView
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:11:42 PM
	 * @version UserManagement 1.0
	 * @param id
	 * @param userFullName
	 * @param isActive
	 */
	public EnterpriseUserView(Long id, String userFullName, Boolean isActive) {
		this.id = id;
		this.userFullName = userFullName;
		this.isActive = isActive;
	}

	/**
	 * Method toAcegiUser
	 * @author Madhava
	 * @since Jul 31, 2014 - 8:16:41 PM
	 * @version UserManagement 1.5
	 * @return
	 * @see com.madhava.service.security.IUser#toAcegiUser()
	 */
	@Override
	public User toAcegiUser() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Method getUsername
	 * @author Madhava
	 * @since Jul 31, 2014 - 8:16:41 PM
	 * @version UserManagement 1.5
	 * @return
	 * @see com.madhava.service.security.IUser#getUsername()
	 */
	@Override
	public String getUsername() {
		return userFullName;
	}

	/**
	 * Method getId
	 * @author Madhava
	 * @since Jul 31, 2014 - 8:16:41 PM
	 * @version UserManagement 1.5
	 * @return
	 * @see com.madhava.service.security.IUser#getId()
	 */
	@Override
	public Long getId() {
		return id;
	}

	/**
	 * Method getUserFullName
	 * @author Madhava
	 * @since Jul 31, 2014 - 8:16:41 PM
	 * @version UserManagement 1.5
	 * @return
	 * @see com.madhava.service.security.IUser#getUserFullName()
	 */
	@Override
	public String getUserFullName() {
		return userFullName;
	}

	/**
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param userFullName the userFullName to set
	 */
	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

}
