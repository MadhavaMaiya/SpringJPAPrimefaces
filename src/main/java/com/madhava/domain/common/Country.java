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
import javax.persistence.Table;


import org.hibernate.search.annotations.Indexed;

/**
 * Class Country
 * @author Madhava
 * @since Jul 31, 2014 - 8:48:54 PM
 * @version UserManagement 1.0
 */

@Entity
@Table(name = "COUNTRY")
@Indexed
public class Country extends BaseDomain{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2400157834114497676L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	@Column(name = "CODE", length = 20, unique = true, nullable = false)
	private String code;
	@Column(name = "DESCRIPTION", length = 100)
	private String description;
	@Column(name = "ISGROUP", nullable = false)
	private Boolean isGroup = new Boolean(false);
	@Column(name = "ISACTIVE", nullable = false)
	private Boolean isActive = new Boolean(true);
	@Column(name = "TYPENUM")
	private Long typeNum;
	@Column(name = "PHONECODE")
	private String countryPhoneCode;
	@Column(name = "NATIONALITY")
	private String nationality;

	/**
	 * Constructor Country
	 * @author Madhava
	 * @since Jul 31, 2014 - 8:58:15 PM
	 * @version UserManagement 1.0
	 */
	public Country() {
		super();
	}

	/**
	 * Constructor Country
	 * @author Madhava
	 * @since Jul 31, 2014 - 8:58:23 PM
	 * @version UserManagement 1.0
	 * @param countryName
	 */
	public Country(String countryName) {
		super();
		this.description = countryName;
	}

	/**
	 * Constructor Country
	 * @author Madhava
	 * @since Jul 31, 2014 - 8:58:29 PM
	 * @version UserManagement 1.0
	 * @param countryId
	 * @param countryName
	 */
	public Country(Long countryId, String countryName) {
		super();
		this.id = countryId;
		this.description = countryName;
	}

	/**
	 * Constructor Country
	 * @author Madhava
	 * @since Jul 31, 2014 - 8:58:36 PM
	 * @version UserManagement 1.0
	 * @param countryId
	 */
	public Country(Long countryId) {
		super();
		this.id = countryId;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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
	 * @return the isGroup
	 */
	public Boolean getIsGroup() {
		return isGroup;
	}

	/**
	 * @param isGroup the isGroup to set
	 */
	public void setIsGroup(Boolean isGroup) {
		this.isGroup = isGroup;
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
	 * @return the typeNum
	 */
	public Long getTypeNum() {
		return typeNum;
	}

	/**
	 * @param typeNum the typeNum to set
	 */
	public void setTypeNum(Long typeNum) {
		this.typeNum = typeNum;
	}

	/**
	 * @return the countryPhoneCode
	 */
	public String getCountryPhoneCode() {
		return countryPhoneCode;
	}

	/**
	 * @param countryPhoneCode the countryPhoneCode to set
	 */
	public void setCountryPhoneCode(String countryPhoneCode) {
		this.countryPhoneCode = countryPhoneCode;
	}

	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	
}
