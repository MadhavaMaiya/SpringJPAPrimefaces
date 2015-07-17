/*
 * Created on Jul 27, 2014
 * @author Madhava
 */
package com.madhava.domain.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;

import com.madhava.domain.common.BaseDomain;

/**
 * Class Branch
 * 
 * @author Madhava
 * @since Jul 27, 2014 - 4:49:12 PM
 * @version UserManagement 1.0
 */
@Entity
@Indexed
@Audited
@Table(name="ORGSTRUCTURE")
@Where(clause="ORGSTRUCTTYPE = 2")
public class Branch extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5342305974994011837L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	@Column(name = "CODE", nullable = false, unique = true, length = 10)
	private String code;
	@Column(name = "NAME", length = 100)
	private String name;
	@Column(name = "PARENTORGID", length = 10)
	private Long parentCode;
	@Column(name = "TINNO", length = 50)
	private String tinNo;
	@Column(name = "CSTNO", length = 50)
	private String cstNo;
	@Column(name = "ISACTIVE", nullable = false)
	private Boolean active = Boolean.TRUE;

	/**
	 * Constructor Branch
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 10:09:40 AM
	 * @version UserManagement 1.0
	 */
	public Branch() {
		super();
	}

	/**
	 * Constructor Branch
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 10:09:33 AM
	 * @version UserManagement 1.0
	 * @param id
	 * @param code
	 * @param name
	 */
	public Branch(Long id, String code, String name) {
		this.id = id;
		this.code = code;
		this.name = name;
	}

	/**
	 * Constructor Branch
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 10:09:26 AM
	 * @version UserManagement 1.0
	 * @param branchId
	 * @param branch
	 */
	public Branch(Long branchId, String branch) {
		this.id = branchId;
		this.name = branch;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
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
	 * @param code
	 *            the code to set
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
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the parentCode
	 */
	public Long getParentCode() {
		return parentCode;
	}

	/**
	 * @param parentCode
	 *            the parentCode to set
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
	 * @param tinNo
	 *            the tinNo to set
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
	 * @param cstNo
	 *            the cstNo to set
	 */
	public void setCstNo(String cstNo) {
		this.cstNo = cstNo;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * Method equals
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 10:08:54 AM
	 * @version UserManagement 1.5
	 * @param other
	 * @return
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		if (other instanceof Branch) {
			Branch branchToCompare = (Branch) other;
			return (branchToCompare.code != null && this.code != null)
					&& branchToCompare.getCode().equals(this.code);
		} else {
			return false;
		}

	}

}
