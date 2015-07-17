/*
* Created on Jul 27, 2014
* @author Madhava
*/
package com.madhava.domain.common.view;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;

import com.madhava.domain.common.BaseDomain;

/**
 * Class DepartmentView
 * @author Madhava
 * @since Jul 27, 2014 - 4:49:27 PM
 * @version UserManagement 1.0
 */
@Entity
@Audited
@Indexed
@Table(name="DEPARTMENT")
public class DepartmentView  extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6777750531855708438L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DEPARTMENT_ID")
	private Long id;
	
	@Column(name="DEPARTMENT_CODE", length=20, unique=true) 
	@NotNull
	private String code;
	
	@NotNull
	@Column(name="DEPARTMENT_NAME", length=100) 
	private String name;
	
	@Column(name="ACTIVE", nullable=false)
	private Boolean active = true;
	
	@Column(name="SITEID")
	private Long siteId;

	/**
	 * Constructor DepartmentView
	 * @author Madhava
	 * @since Jul 31, 2014 - 10:21:31 AM
	 * @version UserManagement 1.0
	 */
	public DepartmentView() {
		super();
	}

	/**
	 * Constructor DepartmentView
	 * @author Madhava
	 * @since Jul 31, 2014 - 10:21:26 AM
	 * @version UserManagement 1.0
	 * @param departmentId
	 */
	public DepartmentView(Long departmentId) {
		this.id=departmentId;
	}
	
	/**
	 * Constructor DepartmentView
	 * @author Madhava
	 * @since Jul 31, 2014 - 10:20:59 AM
	 * @version UserManagement 1.0
	 * @param id
	 * @param name
	 */
	public DepartmentView(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
