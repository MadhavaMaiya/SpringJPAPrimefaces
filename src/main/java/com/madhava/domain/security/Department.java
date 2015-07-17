/*
* Created on Jul 31, 2014
* @author Madhava
*/
package com.madhava.domain.security;

import com.madhava.domain.common.BaseDomain;
import com.madhava.domain.common.LookupEntity;
import com.madhava.domain.common.Site;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
/**
 * Class Department
 * @author Madhava
 * @since Jul 31, 2014 - 10:25:37 AM
 * @version UserManagement 1.0
 */
@Entity
@Audited
@Table(name="DEPARTMENT")
public class Department extends BaseDomain {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2295914513003491786L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DEPARTMENT_ID")
	private Long departmentId;
	@Column(name="DEPARTMENT_CODE", nullable=false)
	private String departmentCode;
	@Column(name="DEPARTMENT_NAME", nullable=false)
	private String departmentName;
	@Column(name="DESCRIPTION")
	private String description;
	@Column(name="STARTED_ON")
	@Temporal(value=TemporalType.DATE)
	private Date startedOn = new Date();
	@ManyToOne @JoinColumn(name="DEPARTMENT_TYPE")
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	private LookupEntity departmentType = new LookupEntity();
	@Column(name="DEPARTMENT_TYPE_ID", insertable=false, updatable=false)
	private Long departmentTypeId;
	@ManyToOne @JoinColumn(name="SITEID")
	private Site site = new Site();
	@Column(name="DEPARTMENT_RUN_BY")
	private String hod;
	@Column(name="ACTIVE", nullable=false)
	private Boolean active = true;

	private String imageName;

	/**
	 * Constructor Department
	 * @author Madhava
	 * @since Jul 31, 2014 - 10:44:55 AM
	 * @version UserManagement 1.0
	 */
	public Department() {
		super();
	}

	/**
	 * Constructor Department
	 * @author Madhava
	 * @since Jul 31, 2014 - 10:45:01 AM
	 * @version UserManagement 1.0
	 * @param departmentId
	 */
	public Department(Long departmentId) {
		super();
		this.departmentId = departmentId;
	}

	/**
	 * Constructor Department
	 * @author Madhava
	 * @since Jul 31, 2014 - 10:45:06 AM
	 * @version UserManagement 1.0
	 * @param departmentId
	 * @param departmentName
	 */
	public Department(Long departmentId, String departmentName) {
		this(departmentId);
		this.departmentName = departmentName;
	}
	
	/**
	 * Constructor Department
	 * @author Madhava
	 * @since Jul 31, 2014 - 10:45:12 AM
	 * @version UserManagement 1.0
	 * @param departmentName
	 */
	public Department(String departmentName) {
		super();
		this.departmentName = departmentName;
	}

	/**
	 * Constructor Department
	 * @author Madhava
	 * @since Jul 31, 2014 - 10:45:20 AM
	 * @version UserManagement 1.0
	 * @param departmentId
	 * @param departmentCode
	 * @param departmentName
	 * @param description
	 * @param startedOn
	 * @param departmentTypeId
	 * @param departmentTypeName
	 * @param siteId
	 * @param siteName
	 * @param hod
	 * @param active
	 * @param profitCenterAccode
	 * @param costCenterAccode
	 * @param createdBy
	 * @param createdDatetime
	 * @param versionNo
	 * @param imageName
	 */
	public Department(Long departmentId, String departmentCode,
			String departmentName, String description, Date startedOn,
			Long departmentTypeId,String departmentTypeName,Long siteId,String siteName, String hod, Boolean active,
			String profitCenterAccode, String costCenterAccode,Long createdBy,Date createdDatetime,int versionNo, String imageName) {
		super(createdBy,createdDatetime,versionNo);
		this.departmentId = departmentId;
		this.departmentCode = departmentCode;
		this.departmentName = departmentName;
		this.description = description;
		this.startedOn = startedOn;
		this.departmentType = new LookupEntity(departmentTypeId,departmentTypeName);
		this.site = new Site(siteId,siteName);
		this.hod = hod;
		this.active = active;
		this.imageName = imageName;
	}

	/**
	 * Constructor Department
	 * @author Madhava
	 * @since Jul 31, 2014 - 10:45:35 AM
	 * @version UserManagement 1.0
	 * @param departmentId
	 * @param departmentCode
	 * @param departmentName
	 * @param description
	 * @param startedOn
	 * @param departmentTypeId
	 * @param departmentTypeName
	 * @param siteId
	 * @param siteName
	 * @param hod
	 * @param active
	 * @param profitCenterAccode
	 * @param costCenterAccode
	 * @param createdBy
	 * @param createdDatetime
	 * @param versionNo
	 */
	public Department(Long departmentId, String departmentCode,
			String departmentName, String description, Date startedOn,
			Long departmentTypeId,String departmentTypeName,Long siteId,String siteName, String hod, Boolean active,
			String profitCenterAccode, String costCenterAccode,Long createdBy,Date createdDatetime,int versionNo) {
		super(createdBy,createdDatetime,versionNo);
		this.departmentId = departmentId;
		this.departmentCode = departmentCode;
		this.departmentName = departmentName;
		this.description = description;
		this.startedOn = startedOn;
		this.departmentType = new LookupEntity(departmentTypeId,departmentTypeName);
		this.site = new Site(siteId,siteName);
		this.hod = hod;
		this.active = active;
	}

	/**
	 * @return the departmentId
	 */
	public Long getDepartmentId() {
		return departmentId;
	}

	/**
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * @return the departmentCode
	 */
	public String getDepartmentCode() {
		return departmentCode;
	}

	/**
	 * @param departmentCode the departmentCode to set
	 */
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
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
	 * @return the startedOn
	 */
	public Date getStartedOn() {
		return startedOn;
	}

	/**
	 * @param startedOn the startedOn to set
	 */
	public void setStartedOn(Date startedOn) {
		this.startedOn = startedOn;
	}

	/**
	 * @return the departmentType
	 */
	public LookupEntity getDepartmentType() {
		return departmentType;
	}

	/**
	 * @param departmentType the departmentType to set
	 */
	public void setDepartmentType(LookupEntity departmentType) {
		this.departmentType = departmentType;
	}

	/**
	 * @return the departmentTypeId
	 */
	public Long getDepartmentTypeId() {
		return departmentTypeId;
	}

	/**
	 * @param departmentTypeId the departmentTypeId to set
	 */
	public void setDepartmentTypeId(Long departmentTypeId) {
		this.departmentTypeId = departmentTypeId;
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

	/**
	 * @return the hod
	 */
	public String getHod() {
		return hod;
	}

	/**
	 * @param hod the hod to set
	 */
	public void setHod(String hod) {
		this.hod = hod;
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
	 * @return the imageName
	 */
	public String getImageName() {
		return imageName;
	}

	/**
	 * @param imageName the imageName to set
	 */
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	

}
