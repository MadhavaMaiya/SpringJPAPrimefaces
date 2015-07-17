/*
* Created on Aug 24, 2014
* @author Madhava
*/
package com.madhava.domain.common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;

import com.madhava.domain.common.view.DepartmentView;


/**
 * Class EnterpriseUserDepartment
 * @author Madhava
 * @since Aug 24, 2014 - 11:16:37 AM
 * @version UserManagement 1.0
 */
@Entity
@Indexed
@Audited
@Table(name="USERDEPARTMENTMAP")
public class EnterpriseUserDepartment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2287811343856030169L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USERDEPARTMENTMAPID")
	private Long id;
	@Column(name="ENTERPRISEUSER")
	private Long user;
	@ManyToOne
	@JoinColumn(name="DEPARTMENT")
	private DepartmentView department;

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
	 * @return the department
	 */
	public DepartmentView getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(DepartmentView department) {
		this.department = department;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}
	
	
}
