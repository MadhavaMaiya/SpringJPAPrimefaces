/*
* Created on Jul 31, 2014
* @author Madhava
*/
package com.madhava.domain.common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.hibernate.search.annotations.Indexed;

import com.madhava.domain.OrganisationStructure;
import com.madhava.domain.common.view.DepartmentView;
import com.madhava.domain.common.view.OrganisationView;
import com.madhava.domain.security.Branch;
import com.madhava.domain.security.Location;
/**
 * Class Preferences
 * @author Madhava
 * @since Jul 31, 2014 - 1:16:59 PM
 * @version UserManagement 1.0
 */
@Entity
@Indexed
@Audited
@Table(name = "PREFERENCES")
public class Preferences implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8901369688987412494L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "USER_CODE", nullable = false, unique = true)
	private String userCode;

	@ManyToOne
	@JoinColumn(name = "ORGID")
	private OrganisationStructure branch = new OrganisationStructure();

	@ManyToOne
	@JoinColumn(name = "DEPTID")
	private DepartmentView department = new DepartmentView();

	@Transient
	private Location location;

	@Column(name="DEFAULTPAGE")
	private Long defaultPageId;

	@Enumerated(value=EnumType.STRING) 
	@Column(name="THEME",nullable=false, length=1)
	private Theme theme = Theme.ARISTO;
	
	@Column(name="LANGUAGE")
	private String language="en";
	
	@ManyToOne @JoinColumn(name="APPLICATION_PAGE", nullable=false)
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	private Feature applicationPage = new Feature();

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
	 * @return the userCode
	 */
	public String getUserCode() {
		return userCode;
	}

	/**
	 * @param userCode the userCode to set
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	/**
	 * @return the branch
	 */
	public OrganisationStructure getBranch() {
		return branch;
	}

	/**
	 * @param branch the branch to set
	 */
	public void setBranch(OrganisationStructure branch) {
		this.branch = branch;
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

	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * @return the defaultPageId
	 */
	public Long getDefaultPageId() {
		return defaultPageId;
	}

	/**
	 * @param defaultPageId the defaultPageId to set
	 */
	public void setDefaultPageId(Long defaultPageId) {
		this.defaultPageId = defaultPageId;
	}

	/**
	 * @return the theme
	 */
	public Theme getTheme() {
		return theme;
	}

	/**
	 * @param theme the theme to set
	 */
	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the applicationPage
	 */
	public Feature getApplicationPage() {
		return applicationPage;
	}

	/**
	 * @param applicationPage the applicationPage to set
	 */
	public void setApplicationPage(Feature applicationPage) {
		this.applicationPage = applicationPage;
	}
	
	/**
	 * Method getOrganisationView
	 * @author Madhava
	 * @since Jul 31, 2014 - 3:32:22 PM
	 * @version UserManagemenr 1.0
	 * @return
	 */
	public OrganisationView getOrganisationView() {
		if (branch != null) {
			return new OrganisationView(branch.getId(), branch.getCode(),
					branch.getName(), branch.getAlias());
		}
		return null;
	}

	/**
	 * Method getBranchObject
	 * @author Madhava
	 * @since Jul 31, 2014 - 3:32:17 PM
	 * @version UserManagemenr 1.0
	 * @return
	 */
	public Branch getBranchObject() {
		if (branch != null) {
			return new Branch(branch.getId(), branch.getCode(), branch
					.getName());
		}
		return null;
	}

	/**
	 * Method clone
	 * @author Madhava
	 * @since Jul 31, 2014 - 3:32:05 PM
	 * @version UserManagement 1.0
	 * @return
	 * @throws CloneNotSupportedException
	 * @see java.lang.Object#clone()
	 */
	public Object clone()throws CloneNotSupportedException {
		Preferences preferences = new Preferences();
		preferences.branch = branch;
		preferences.department = department;
		preferences.id = id;
		preferences.location = location;
		preferences.userCode = userCode;
		preferences.defaultPageId = defaultPageId;
		preferences.theme = theme;
		return preferences;
	}
}
