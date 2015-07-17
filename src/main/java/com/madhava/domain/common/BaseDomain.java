/*
 * Created on Jul 31, 2014
 * @author Madhava
 */
package com.madhava.domain.common;

import java.io.Serializable;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.OrderBy;
import javax.persistence.Version;

/**
 * Class BaseDomain
 * 
 * @author Madhava
 * @since Jul 31, 2014 - 9:38:19 AM
 * @version UserManagement 1.0
 */
@MappedSuperclass
public class BaseDomain implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CREATEDBY", length = 20, nullable = false)
	private Long createdBy;

	@Column(name = "CREATEDDATETIME", nullable = false)
	@OrderBy(value = "desc")
	private Date createdDatetime;

	@Column(name = "UPDATEDBY", length = 20)
	private Long updatedBy;

	@Column(name = "UPDATEDDATETIME")
	private Date updatedDatetime;

	@Column(name = "HIBVERSION")
	@Version
	private int versionNo;

	/**
	 * Constructor BaseDomain
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:44:08 AM
	 * @version UserManagement 1.0
	 */
	public BaseDomain() {
		super();
	}

	/**
	 * Constructor BaseDomain
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:41:47 AM
	 * @version UserManagement 1.0
	 * @param createdBy
	 * @param createdDatetime
	 */
	public BaseDomain(Long createdBy, Date createdDatetime) {
		this.createdBy = createdBy;
		this.createdDatetime = createdDatetime == null ? null : new Timestamp(
				createdDatetime.getTime());
	}

	/**
	 * Constructor BaseDomain
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:41:54 AM
	 * @version UserManagement 1.0
	 * @param createdBy
	 * @param createdDatetime
	 * @param versionNo
	 */
	public BaseDomain(Long createdBy, Date createdDatetime, int versionNo) {
		this.createdBy = createdBy;
		this.createdDatetime = createdDatetime == null ? null : new Timestamp(
				createdDatetime.getTime());
		this.versionNo = versionNo;
	}

	/**
	 * Constructor BaseDomain
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:42:05 AM
	 * @version UserManagement 1.0
	 * @param createdBy
	 * @param createdDatetime
	 * @param updatedBy
	 * @param updatedDatetime
	 */
	public BaseDomain(Long createdBy, Date createdDatetime, Long updatedBy,
			Date updatedDatetime) {
		this.createdBy = createdBy;
		this.createdDatetime = createdDatetime == null ? null : new Timestamp(
				createdDatetime.getTime());
		this.updatedBy = updatedBy;
		this.updatedDatetime = updatedDatetime == null ? null : new Timestamp(
				updatedDatetime.getTime());
	}

	/**
	 * @return the createdBy
	 */
	public Long getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDatetime
	 */
	public Date getCreatedDatetime() {
		return createdDatetime;
	}

	/**
	 * @param createdDatetime the createdDatetime to set
	 */
	public void setCreatedDatetime(Date createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	/**
	 * @return the updatedBy
	 */
	public Long getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the updatedDatetime
	 */
	public Date getUpdatedDatetime() {
		return updatedDatetime;
	}

	/**
	 * @param updatedDatetime the updatedDatetime to set
	 */
	public void setUpdatedDatetime(Date updatedDatetime) {
		this.updatedDatetime = updatedDatetime;
	}

	/**
	 * @return the versionNo
	 */
	public int getVersionNo() {
		return versionNo;
	}

	/**
	 * @param versionNo the versionNo to set
	 */
	public void setVersionNo(int versionNo) {
		this.versionNo = versionNo;
	}
	

	
}