/*
 * Created on Jul 31, 2014
 * @author Madhava
 */
package com.madhava.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;

/**
 * Class OrganisationStructure
 * 
 * @author Madhava
 * @since Jul 31, 2014 - 11:07:32 AM
 * @version UserManagement 1.0
 */
@Entity
@Indexed
@Audited
@Table(name="ORGSTRUCTURE")
public class OrganisationStructure {

	public static final int BUSINESS_GROUP = 0;
	public static final int COMPANY = 1;
	public static final int BRANCH = 2;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	@Column(name = "CODE", nullable = false, unique = true, length = 20)
	private String code;
	@Column(name = "NAME", length = 100)
	private String name;
	@Column(name = "SHORTNAME", length = 20, unique = true)
	private String alias;
	@Column(name = "ORGSTRUCTTYPE")
	private Long orgStructType;
	@Column(name = "ISACTIVE", nullable = false)
	private Boolean active = Boolean.TRUE;
	@Column(name = "PARENTORGID", length = 20)
	private Long parentCode;
	@Column(name = "TINNO", length = 50)
	private String tinNo;
	@Column(name = "CSTNO", length = 50)
	private String cstNo;
	@Column(name = "ISHEADOFFICE", nullable = false)
	private Boolean headOffice = Boolean.FALSE;
	@Column(name = "CURRENCYID")
	private Long currencyId;

	/**
	 * Constructor OrganisationStructure
	 * @author Madhava
	 * @since Jul 31, 2014 - 11:11:31 AM
	 * @version UserManagement 1.0
	 */
	public OrganisationStructure() {
		super();
	}
	
	/**
	 * Constructor OrganisationStructure
	 * @author Madhava
	 * @since Jul 31, 2014 - 11:11:45 AM
	 * @version UserManagement 1.0
	 * @param id
	 * @param code
	 * @param name
	 * @param orgStructType
	 * @param active
	 */
	public OrganisationStructure(Long id, String code, String name,
			Long orgStructType, Boolean active) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.orgStructType = orgStructType;
		this.active = active;
	}

	/**
	 * Constructor OrganisationStructure
	 * @author Madhava
	 * @since Jul 31, 2014 - 11:11:54 AM
	 * @version UserManagement 1.0
	 * @param id
	 * @param code
	 */
	public OrganisationStructure(Long id, String code) {
		this.id = id;
		this.code = code;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * @return the orgStructType
	 */
	public Long getOrgStructType() {
		return orgStructType;
	}

	/**
	 * @param orgStructType the orgStructType to set
	 */
	public void setOrgStructType(Long orgStructType) {
		this.orgStructType = orgStructType;
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
	 * @return the parentCode
	 */
	public Long getParentCode() {
		return parentCode;
	}

	/**
	 * @param parentCode the parentCode to set
	 */
	public void setParentCode(Long parentCode) {
		this.parentCode = parentCode;
	}

	/**
	 * @return the tinNo
	 */
	public String getTinNo() {
		return tinNo;
	}

	/**
	 * @param tinNo the tinNo to set
	 */
	public void setTinNo(String tinNo) {
		this.tinNo = tinNo;
	}

	/**
	 * @return the cstNo
	 */
	public String getCstNo() {
		return cstNo;
	}

	/**
	 * @param cstNo the cstNo to set
	 */
	public void setCstNo(String cstNo) {
		this.cstNo = cstNo;
	}


	/**
	 * @return the headOffice
	 */
	public Boolean getHeadOffice() {
		return headOffice;
	}

	/**
	 * @param headOffice the headOffice to set
	 */
	public void setHeadOffice(Boolean headOffice) {
		this.headOffice = headOffice;
	}

	/**
	 * @return the currencyId
	 */
	public Long getCurrencyId() {
		return currencyId;
	}

	/**
	 * @param currencyId the currencyId to set
	 */
	public void setCurrencyId(Long currencyId) {
		this.currencyId = currencyId;
	}
	
	/**
	 * Method equals
	 * @author Madhava
	 * @since Jul 31, 2014 - 11:13:25 AM
	 * @version UserManagement 1.0
	 * @param object
	 * @return
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object object){
		if(object != null && object instanceof OrganisationStructure){
			OrganisationStructure other = (OrganisationStructure) object;
			if(code != null && other.getCode() != null && other.getCode().equals(code)){
				return true;
			}
		}
		return false;
	}
}
