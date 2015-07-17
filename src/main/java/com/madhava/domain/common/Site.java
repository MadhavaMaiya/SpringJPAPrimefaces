/*
 * Created on Jul 31, 2014
 * @author Madhava
 */
package com.madhava.domain.common;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Transient;

import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

import com.madhava.util.common.BeanUtils;

/**
 * Class Site
 * 
 * @author Madhava
 * @since Jul 31, 2014 - 10:27:18 AM
 * @version UserManagement 1.0
 */
@Entity
@Table(name = "ORGSTRUCTURE")
@Audited
@Where(clause = "ORGSTRUCTTYPE = 2 and ORGSTRUCTCLASS=1")
public class Site extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8271319099215709973L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long siteId;
	@Column(name = "CODE")
	private String siteCode;
	@Column(name = "NAME")
	private String siteName;
	@Column(name = "SHORTNAME")
	private String siteDescription;
	@Transient
	private Address address = new Address();
	@Transient
	private String contactPerson;
	@Transient
	private String designation;
	@Transient
	private String contactPhone;
	@Transient
	private String contactEmail;
	@Transient
	private String contactFax;
	@Transient
	private String siteLogo;
	@Transient
	private String licenseNo;
	@Column(name = "ORGSTRUCTTYPE")
	private Long orgStructType;
	@Column(name = "ISACTIVE", nullable = false)
	private Boolean active = true;
	@Transient
	private List<ContactMode> contactModes = new ArrayList<ContactMode>();

	/**
	 * Constructor Site
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 10:50:09 AM
	 * @version UserManagement 1.0
	 */
	public Site() {
		super();
	}

	/**
	 * Constructor Site
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 10:50:16 AM
	 * @version UserManagement 1.0
	 * @param siteId
	 * @param siteName
	 */
	public Site(Long siteId, String siteName) {
		super();
		this.siteId = siteId;
		this.siteName = siteName;
	}

	/**
	 * Constructor Site
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 10:50:24 AM
	 * @version UserManagement 1.0
	 * @param siteId
	 */
	public Site(Long siteId) {
		super();
		this.siteId = siteId;
	}

	/**
	 * @return the siteId
	 */
	public Long getSiteId() {
		return siteId;
	}

	/**
	 * @param siteId
	 *            the siteId to set
	 */
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	/**
	 * @return the siteCode
	 */
	public String getSiteCode() {
		return siteCode;
	}

	/**
	 * @param siteCode
	 *            the siteCode to set
	 */
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	/**
	 * @return the siteName
	 */
	public String getSiteName() {
		return siteName;
	}

	/**
	 * @param siteName
	 *            the siteName to set
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	/**
	 * @return the siteDescription
	 */
	public String getSiteDescription() {
		return siteDescription;
	}

	/**
	 * @param siteDescription
	 *            the siteDescription to set
	 */
	public void setSiteDescription(String siteDescription) {
		this.siteDescription = siteDescription;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the contactPerson
	 */
	public String getContactPerson() {
		return contactPerson;
	}

	/**
	 * @param contactPerson
	 *            the contactPerson to set
	 */
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation
	 *            the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @return the contactPhone
	 */
	public String getContactPhone() {
		return contactPhone;
	}

	/**
	 * @param contactPhone
	 *            the contactPhone to set
	 */
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	/**
	 * @return the contactEmail
	 */
	public String getContactEmail() {
		return contactEmail;
	}

	/**
	 * @param contactEmail
	 *            the contactEmail to set
	 */
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	/**
	 * @return the contactFax
	 */
	public String getContactFax() {
		return contactFax;
	}

	/**
	 * @param contactFax
	 *            the contactFax to set
	 */
	public void setContactFax(String contactFax) {
		this.contactFax = contactFax;
	}

	/**
	 * @return the siteLogo
	 */
	public String getSiteLogo() {
		return siteLogo;
	}

	/**
	 * @param siteLogo
	 *            the siteLogo to set
	 */
	public void setSiteLogo(String siteLogo) {
		this.siteLogo = siteLogo;
	}

	/**
	 * @return the licenseNo
	 */
	public String getLicenseNo() {
		return licenseNo;
	}

	/**
	 * @param licenseNo
	 *            the licenseNo to set
	 */
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	/**
	 * @return the orgStructType
	 */
	public Long getOrgStructType() {
		return orgStructType;
	}

	/**
	 * @param orgStructType
	 *            the orgStructType to set
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
	 * @param active
	 *            the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * @return the contactModes
	 */
	public List<ContactMode> getContactModes() {
		return contactModes;
	}

	/**
	 * @param contactModes
	 *            the contactModes to set
	 */
	public void setContactModes(List<ContactMode> contactModes) {
		this.contactModes = contactModes;
	}

	/**
	 * Method hashCode
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 10:52:44 AM
	 * @version UserManagement 1.5
	 * @return
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		if (BeanUtils.isNull(getSiteId())) {
			return 0;
		}
		return getSiteId().hashCode();
	}

	/**
	 * Method equals
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 10:52:50 AM
	 * @version UserManagement 1.5
	 * @param obj
	 * @return
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {

		if (obj instanceof Site && !BeanUtils.isNull(getSiteId())
				&& !BeanUtils.isNull(obj)
				&& getSiteId().equals(((Site) obj).getSiteId())) {
			return true;
		} else {
			return false;
		}
	}
}
