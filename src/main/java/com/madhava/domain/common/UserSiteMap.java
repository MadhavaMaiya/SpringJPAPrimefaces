/*
* Created on Aug 23, 2014
* @author Madhava
*/
package com.madhava.domain.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.madhava.domain.security.EnterpriseUser;

/**
 * Class UserSiteMap
 * @author Madhava
 * @since Aug 23, 2014 - 10:39:58 PM
 * @version UserManagement 1.0
 */
@Entity
@Table(name = "USERSITEMAP")
@Audited
public class UserSiteMap {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long userSiteMapId;
	@ManyToOne
	@JoinColumn(name = "USERID")
	private EnterpriseUser user=new EnterpriseUser();
	@ManyToOne
	@JoinColumn(name = "SITEID")
	private Site site=new Site();
	/**
	 * @return the userSiteMapId
	 */
	public Long getUserSiteMapId() {
		return userSiteMapId;
	}
	/**
	 * @param userSiteMapId the userSiteMapId to set
	 */
	public void setUserSiteMapId(Long userSiteMapId) {
		this.userSiteMapId = userSiteMapId;
	}
	/**
	 * @return the user
	 */
	public EnterpriseUser getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(EnterpriseUser user) {
		this.user = user;
	}
	/**
	 * @return the site
	 */
	public Site getSite() {
		return site;
	}
	/**
	 * @param site the site to set
	 */
	public void setSite(Site site) {
		this.site = site;
	}
	
	
}
