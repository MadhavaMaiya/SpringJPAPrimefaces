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
 * Class City
 * 
 * @author Madhava
 * @since Jul 31, 2014 - 8:48:29 PM
 * @version UserManagement 1.0
 */
@Entity
@Table(name = "CITY")
public class City extends BaseDomain {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CITY_ID")
	private Long cityId;
	@Column(name = "CITY_CODE", nullable = false, length = 20)
	private String cityCode;
	@Column(name = "CITY_NAME", nullable = false, length = 100)
	private String cityName;
	@Column(name = "ISDEFAULT", nullable = false)
	private Boolean isDefault = Boolean.FALSE;
	@Column(name = "ISACTIVE", nullable = false)
	private Boolean isActive = Boolean.TRUE;
	@Column(name = "DESCRIPTION")
	private String description;
	@ManyToOne
	@JoinColumn(name = "DISTRICT_ID")
	private District district = new District();

	/**
	 * Constructor City
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 8:53:27 PM
	 * @version UserManagement 1.0
	 */
	public City() {
		super();
	}

	/**
	 * Constructor City
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 8:53:34 PM
	 * @version UserManagement 1.0
	 * @param cityName
	 */
	public City(String cityName) {
		super();
		this.cityName = cityName;
	}

	/**
	 * Constructor City
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 8:53:59 PM
	 * @version UserManagement 1.0
	 * @param cityId
	 * @param cityName
	 */
	public City(Long cityId, String cityName) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
	}

	/**
	 * @return the cityId
	 */
	public Long getCityId() {
		return cityId;
	}

	/**
	 * @param cityId
	 *            the cityId to set
	 */
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	/**
	 * @return the cityCode
	 */
	public String getCityCode() {
		return cityCode;
	}

	/**
	 * @param cityCode
	 *            the cityCode to set
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName
	 *            the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * @return the isDefault
	 */
	public Boolean getIsDefault() {
		return isDefault;
	}

	/**
	 * @param isDefault
	 *            the isDefault to set
	 */
	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	/**
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive
	 *            the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the district
	 */
	public District getDistrict() {
		return district;
	}

	/**
	 * @param district
	 *            the district to set
	 */
	public void setDistrict(District district) {
		this.district = district;
	}

	/**
	 * Method doBeforePresentation
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 8:54:08 PM
	 * @version UserManagemenr 1.0
	 */
	public void doBeforePresentation() {
		if (getDistrict() == null) {
			setDistrict(new District());
		}
	}

}