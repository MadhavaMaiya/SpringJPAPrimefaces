/*
 * Created on Jul 31, 2014
 * @author Madhava
 */
package com.madhava.domain.common.view;

import com.madhava.domain.common.BaseDomain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class OrganisationView
 * 
 * @author Madhava
 * @since Jul 31, 2014 - 2:41:30 PM
 * @version UserManagement 1.0
 */
@Entity
@Table(name = "ORGSTRUCTURE")
public class OrganisationView extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4311052855909808395L;

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

	/**
	 * Constructor OrganisationView
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 2:45:02 PM
	 * @version UserManagement 1.0
	 */
	public OrganisationView() {
		super();
	}

	/**
	 * Constructor OrganisationView
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 2:45:08 PM
	 * @version UserManagement 1.0
	 * @param id
	 */
	public OrganisationView(Long id) {
		super();
		this.id = id;
	}

	/**
	 * Constructor OrganisationView
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 2:45:16 PM
	 * @version UserManagement 1.0
	 * @param id
	 * @param code
	 * @param name
	 */
	public OrganisationView(Long id, String code, String name) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
	}

	/**
	 * Constructor OrganisationView
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 2:45:23 PM
	 * @version UserManagement 1.0
	 * @param id
	 * @param code
	 * @param name
	 * @param alias
	 */
	public OrganisationView(Long id, String code, String name, String alias) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.alias = alias;
	}

	/**
	 * Constructor OrganisationView
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 2:45:30 PM
	 * @version UserManagement 1.0
	 * @param id
	 * @param code
	 * @param name
	 * @param orgStructType
	 * @param active
	 */
	public OrganisationView(Long id, String code, String name,
			Long orgStructType, boolean active) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.orgStructType = orgStructType;
		this.active = active;
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
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @param alias
	 *            the alias to set
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

}
