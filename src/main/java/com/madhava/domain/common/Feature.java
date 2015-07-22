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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
/**
 * Class Feature
 * @author Madhava
 * @since Jul 31, 2014 - 2:19:34 PM
 * @version UserManagement 1.0
 */
@Entity
@Table(name="FEATURE")
public class Feature extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8004062604610564758L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="featureId")
	private Long featureId;
	@Column(name="FEATUREDESC")
	private String featureDesc;
	@Column(name="ACTION")
	private String action;
	@Column(name="PARENTFEATUREID")
	private Long parentFeatureId;
	@Column(name="SORTINGORDER")
	private Long sortingOrder;
	@Column(name="ISEXPOSED", nullable=false)
	private Boolean isExposed;
	@ManyToOne @JoinColumn(name="FEATURECATEGORY")
	private LookupEntity featureCategory=new LookupEntity();
	@ManyToOne @JoinColumn(name="FEATURETYPE")
	private LookupEntity featureType=new LookupEntity();
	@Column(name="PAGEURL")
	private String pageUrl;
	@Transient
	private Boolean isSelected;
	/**
	 * @return the featureId
	 */
	public Long getFeatureId() {
		return featureId;
	}
	/**
	 * @param featureId the featureId to set
	 */
	public void setFeatureId(Long featureId) {
		this.featureId = featureId;
	}
	/**
	 * @return the featureDesc
	 */
	public String getFeatureDesc() {
		return featureDesc;
	}
	/**
	 * @param featureDesc the featureDesc to set
	 */
	public void setFeatureDesc(String featureDesc) {
		this.featureDesc = featureDesc;
	}
	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}
	/**
	 * @return the parentFeatureId
	 */
	public Long getParentFeatureId() {
		return parentFeatureId;
	}
	/**
	 * @param parentFeatureId the parentFeatureId to set
	 */
	public void setParentFeatureId(Long parentFeatureId) {
		this.parentFeatureId = parentFeatureId;
	}
	/**
	 * @return the sortingOrder
	 */
	public Long getSortingOrder() {
		return sortingOrder;
	}
	/**
	 * @param sortingOrder the sortingOrder to set
	 */
	public void setSortingOrder(Long sortingOrder) {
		this.sortingOrder = sortingOrder;
	}
	/**
	 * @return the isExposed
	 */
	public Boolean getIsExposed() {
		return isExposed;
	}
	/**
	 * @param isExposed the isExposed to set
	 */
	public void setIsExposed(Boolean isExposed) {
		this.isExposed = isExposed;
	}
	/**
	 * @return the featureCategory
	 */
	public LookupEntity getFeatureCategory() {
		return featureCategory;
	}
	/**
	 * @param featureCategory the featureCategory to set
	 */
	public void setFeatureCategory(LookupEntity featureCategory) {
		this.featureCategory = featureCategory;
	}
	/**
	 * @return the featureType
	 */
	public LookupEntity getFeatureType() {
		return featureType;
	}
	/**
	 * @param featureType the featureType to set
	 */
	public void setFeatureType(LookupEntity featureType) {
		this.featureType = featureType;
	}
	/**
	 * @return the pageUrl
	 */
	public String getPageUrl() {
		return pageUrl;
	}
	/**
	 * @param pageUrl the pageUrl to set
	 */
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	/**
	 * @return the isSelected
	 */
	public Boolean getIsSelected() {
		return isSelected;
	}
	/**
	 * @param isSelected the isSelected to set
	 */
	public void setIsSelected(Boolean isSelected) {
		this.isSelected = isSelected;
	} 
	
	
}
