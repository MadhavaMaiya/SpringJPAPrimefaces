/*
 * Created on Jul 27, 2014
 * @author Madhava
 */
package com.madhava.domain.common;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.madhava.util.common.BeanUtils;

/**
 * Used For storing all Master field entries . Common entries like
 * occupation,nationality , language , religion etc are fetched through this
 * Class
 * 
 * @author Madhava
 * @since Jul 27, 2014 - 4:50:09 PM
 * @version UserManagement 1.0
 */
@Entity
@Table(name = "LOOKUPENTITY")
public class LookupEntity extends BaseDomain {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LOOKUPID")
	private Long lookupId;
	@Column(name = "LOOKUPCODE")
	private String lookupCode;
	@Column(name = "LOOKUPVALUE")
	private String lookupValue;
	@ManyToOne
	@JoinColumn(name = "LOOKUPCATEGORY")
	private LookupCategory lookupCategory = new LookupCategory();
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "ACTIVE", nullable = false)
	private Boolean active;
	@Column(name = "SORTORDER")
	private Integer sortOrder;

	/**
	 * Constructor LookupEntity
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:50:48 AM
	 * @version UserManagement 1.0
	 */
	public LookupEntity() {
		super();
	}

	/**
	 * Constructor LookupEntity
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:50:53 AM
	 * @version UserManagement 1.0
	 * @param lookupId
	 */
	public LookupEntity(Long lookupId) {
		this.lookupId = lookupId;
	}

	/**
	 * Constructor LookupEntity
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:50:59 AM
	 * @version UserManagement 1.0
	 * @param lookupId
	 * @param lookupValue
	 */
	public LookupEntity(Long lookupId, String lookupValue) {
		this(lookupId);
		this.lookupValue = lookupValue;
	}

	/**
	 * Constructor LookupEntity
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:51:08 AM
	 * @version UserManagement 1.0
	 * @param lookupId
	 * @param lookupValue
	 * @param lookupCode
	 */
	public LookupEntity(Long lookupId, String lookupValue, String lookupCode) {
		this(lookupId);
		this.lookupValue = lookupValue;
		this.lookupCode = lookupCode;
	}

	/**
	 * Constructor LookupEntity
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:50:04 AM
	 * @version UserManagement 1.0
	 * @param lookupValue
	 */
	public LookupEntity(String lookupValue) {
		super();
		this.lookupValue = lookupValue;
	}

	/**
	 * @return the lookupId
	 */
	public Long getLookupId() {
		return lookupId;
	}

	/**
	 * @param lookupId
	 *            the lookupId to set
	 */
	public void setLookupId(Long lookupId) {
		this.lookupId = lookupId;
	}

	/**
	 * @return the lookupCode
	 */
	public String getLookupCode() {
		return lookupCode;
	}

	/**
	 * @param lookupCode
	 *            the lookupCode to set
	 */
	public void setLookupCode(String lookupCode) {
		this.lookupCode = lookupCode;
	}

	/**
	 * @return the lookupValue
	 */
	public String getLookupValue() {
		return lookupValue;
	}

	/**
	 * @param lookupValue
	 *            the lookupValue to set
	 */
	public void setLookupValue(String lookupValue) {
		this.lookupValue = lookupValue;
	}

	/**
	 * @return the lookupCategory
	 */
	public LookupCategory getLookupCategory() {
		return lookupCategory;
	}

	/**
	 * @param lookupCategory
	 *            the lookupCategory to set
	 */
	public void setLookupCategory(LookupCategory lookupCategory) {
		this.lookupCategory = lookupCategory;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @return the sortOrder
	 */
	public Integer getSortOrder() {
		return sortOrder;
	}

	/**
	 * @param sortOrder
	 *            the sortOrder to set
	 */
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	/**
	 * Method equals
	 * 
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:49:54 AM
	 * @version UserManagement 1.5
	 * @param object
	 * @return
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object object) {
		Long lookupId = 0L;
		if (!BeanUtils.isNull(object)) {
			lookupId = ((LookupEntity) object).getLookupId();
		}
		if (!BeanUtils.isNull(getLookupId())) {
			if (getLookupId().equals(lookupId))
				return true;
			return false;
		} else if (!BeanUtils.isNull(lookupId)) {
			if (lookupId.equals(getLookupId()))
				return true;
			return false;
		}
		return true;
	}

}
