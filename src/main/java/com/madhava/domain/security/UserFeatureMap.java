/*
* Created on Aug 1, 2014
* @author Madhava
*/
package com.madhava.domain.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.madhava.domain.common.BaseDomain;
import com.madhava.domain.common.Feature;

/**
 * Class UserFeatureMap
 * @author Madhava
 * @since Aug 1, 2014 - 9:52:05 PM
 * @version UserManagement 1.0
 */
@Entity
@Table(name="USERFEATUREMAP")
public class UserFeatureMap extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4720618674217288159L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Long userFeatureMapId;
	@ManyToOne
	@JoinColumn(name="USER")
	private EnterpriseUser user=new EnterpriseUser();
	@ManyToOne
	@JoinColumn(name="FEATURE")
	private Feature feature=new Feature();
	@Column(name="SITE_ID")
	private Long siteId;
	/**
	 * @return the userFeatureMapId
	 */
	public Long getUserFeatureMapId() {
		return userFeatureMapId;
	}
	/**
	 * @param userFeatureMapId the userFeatureMapId to set
	 */
	public void setUserFeatureMapId(Long userFeatureMapId) {
		this.userFeatureMapId = userFeatureMapId;
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
	 * @return the feature
	 */
	public Feature getFeature() {
		return feature;
	}
	/**
	 * @param feature the feature to set
	 */
	public void setFeature(Feature feature) {
		this.feature = feature;
	}
	/**
	 * @return the siteId
	 */
	public Long getSiteId() {
		return siteId;
	}
	/**
	 * @param siteId the siteId to set
	 */
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	
	
}
