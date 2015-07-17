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


/**
 * Class District
 * @author Madhava
 * @since Jul 31, 2014 - 8:49:24 PM
 * @version UserManagement 1.0
 */
@Entity
@Table(name="DISTRICT")
public class District extends BaseDomain{

	/**
	 * 
	 */
	private static final long serialVersionUID = -57760610286323984L;


	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DISTRICT_ID")
	private Long districtId;
	@Column(name="DISTRICT_CODE", nullable=false, length=20)
	private String districtCode;
	@Column(name="DISTRICT_NAME", nullable=false, length=100)
	private String districtName;
	@Column(name="DISTRICT_DESC")
	private String districtDesc;
	@Column(name="ACTIVE", nullable=false)
	private Boolean active;
	@ManyToOne @JoinColumn(name="STATE_ID")
	private State state = new State();
	@Column(name="ISDEFAULT", nullable=false)
	private Boolean isDefault = Boolean.FALSE;

	/**
	 * Constructor District
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:06:26 PM
	 * @version UserManagement 1.0
	 */
	public District() {
		super();
	}
	
	/**
	 * Constructor District
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:06:31 PM
	 * @version UserManagement 1.0
	 * @param districtName
	 */
	public District(String districtName) {
		super();
		this.districtName = districtName;
	}
	
	/**
	 * Constructor District
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:07:00 PM
	 * @version UserManagement 1.0
	 * @param districtId
	 * @param districtName
	 */
	public District(Long districtId, String districtName) {
		super();
		this.districtId = districtId;
		this.districtName = districtName;
	}
	
	
	
	/**
	 * @return the districtId
	 */
	public Long getDistrictId() {
		return districtId;
	}

	/**
	 * @param districtId the districtId to set
	 */
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	/**
	 * @return the districtCode
	 */
	public String getDistrictCode() {
		return districtCode;
	}

	/**
	 * @param districtCode the districtCode to set
	 */
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	/**
	 * @return the districtName
	 */
	public String getDistrictName() {
		return districtName;
	}

	/**
	 * @param districtName the districtName to set
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	/**
	 * @return the districtDesc
	 */
	public String getDistrictDesc() {
		return districtDesc;
	}

	/**
	 * @param districtDesc the districtDesc to set
	 */
	public void setDistrictDesc(String districtDesc) {
		this.districtDesc = districtDesc;
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
	 * @return the state
	 */
	public State getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 * @return the isDefault
	 */
	public Boolean getIsDefault() {
		return isDefault;
	}

	/**
	 * @param isDefault the isDefault to set
	 */
	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	/**
	 * Method doBeforePresentation
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:07:20 PM
	 * @version UserManagemenr 1.0
	 */
	public void doBeforePresentation(){
		if(getState()==null){
			setState(new State());
		}
		if(getState().getCountry()==null){
			getState().setCountry(new Country());
		}
	}
}
