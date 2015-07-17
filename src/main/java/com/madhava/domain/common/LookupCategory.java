/*
* Created on Jul 31, 2014
* @author Madhava
*/
package com.madhava.domain.common;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class LookupCategory
 * @author Madhava
 * @since Jul 31, 2014 - 9:35:47 AM
 * @version UserManagement 1.0
 */
@Entity
@Table(name="LOOKUPCATEGORY")
public class LookupCategory extends BaseDomain{
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CATEGORYID")
	private Long categoryId;
	@Column(name="CATEGORYNAME")
	private String categoryName;
	@Column(name="MODIFIABLE")
	private Boolean modifiable;	
	@Column(name="ACTIVE", nullable=false)
	private Boolean active;
	/**
	 * @return the categoryId
	 */
	public Long getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * @return the modifiable
	 */
	public Boolean getModifiable() {
		return modifiable;
	}
	/**
	 * @param modifiable the modifiable to set
	 */
	public void setModifiable(Boolean modifiable) {
		this.modifiable = modifiable;
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
	
	
}
