/*
* Created on Jul 31, 2014
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

import org.hibernate.search.annotations.Indexed;

/**
 * Class State
 * @author Madhava
 * @since Jul 31, 2014 - 8:49:11 PM
 * @version UserManagement 1.0
 */

@Entity
@Indexed
@Table(name="STATE")
public class State extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4225610224272273218L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="STATE_ID")
	private Long stateId;
	@Column(name="STATE_CODE")
	private String stateCode;
	@Column(name="STATE_NAME")
	private String stateName;
	@Column(name="DEFAULTYESNO", nullable=false)
	private Boolean defaultYesno = Boolean.FALSE;
	@Column(name="ACTIVE", nullable=false)
	private Boolean active;
	@Column(name="DESCRIPTION")
	private String description;
	
	// this field is added to incorporated country in state master
	@ManyToOne @JoinColumn(name="COUNTRY_ID")
	private Country country = new Country();
	

	/**
	 * Constructor State
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:03:00 PM
	 * @version UserManagement 1.0
	 */
	public State() {
		super();
	}
	
	/**
	 * Constructor State
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:03:06 PM
	 * @version UserManagement 1.0
	 * @param stateId
	 */
	public State(Long stateId) {  
		super();
		this.stateId = stateId;
	}
	
	/**
	 * Constructor State
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:03:12 PM
	 * @version UserManagement 1.0
	 * @param stateName
	 */
	public State(String stateName) {
		super();
		this.stateName = stateName;
	}
	
	/**
	 * Constructor State
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:03:21 PM
	 * @version UserManagement 1.0
	 * @param stateId
	 * @param stateName
	 */
	public State(Long stateId, String stateName) {
		super();
		this.stateId = stateId;
		this.stateName = stateName;
	}

	/**
	 * @return the stateId
	 */
	public Long getStateId() {
		return stateId;
	}

	/**
	 * @param stateId the stateId to set
	 */
	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	/**
	 * @return the stateCode
	 */
	public String getStateCode() {
		return stateCode;
	}

	/**
	 * @param stateCode the stateCode to set
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	/**
	 * @return the stateName
	 */
	public String getStateName() {
		return stateName;
	}

	/**
	 * @param stateName the stateName to set
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	/**
	 * @return the defaultYesno
	 */
	public Boolean getDefaultYesno() {
		return defaultYesno;
	}

	/**
	 * @param defaultYesno the defaultYesno to set
	 */
	public void setDefaultYesno(Boolean defaultYesno) {
		this.defaultYesno = defaultYesno;
	}

	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
	}
	
	
}
