/*
* Created on Jul 27, 2014
* @author Madhava
*/
package com.madhava.domain.security.helper;

/**
 * Class LogedInUser
 * @author Madhava
 * @since Jul 27, 2014 - 4:19:52 PM
 * @version UserManagement 1.0
 */
import java.io.Serializable;

public class LogedInUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7154742130757766916L;
	
	private Long userId;
	private String userName;
	private Long siteId;
	private String siteName;
	private Long userTypeId;	
	private Long serviceCenterId;
	private String serviceCenterName;
	private Long employeeId;
	private Long departmentId;
	private String departmentName;
	private Long storeId;
	private String storeName;
	private Long serviceCenterTypeId;
	private String serviceCenterTypeName;	
	
	public Long getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(Long userTypeId) {
		this.userTypeId = userTypeId;
	}
	
	public Long getServiceCenterTypeId() {
		return serviceCenterTypeId;
	}
	public void setServiceCenterTypeId(Long serviceCenterTypeId) {
		this.serviceCenterTypeId = serviceCenterTypeId;
	}
	public String getServiceCenterTypeName() {
		return serviceCenterTypeName;
	}
	public void setServiceCenterTypeName(String serviceCenterTypeName) {
		this.serviceCenterTypeName = serviceCenterTypeName;
	}
	public Long getStoreId() {
		return storeId;
	}
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
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
	 * @return the employeeId
	 */
	public Long getEmployeeId() {
		return employeeId;
	}
	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getSiteId() {
		return siteId;
	}
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public Long getServiceCenterId() {
		return serviceCenterId;
	}
	public void setServiceCenterId(Long serviceCenterId) {
		this.serviceCenterId = serviceCenterId;
	}
	public String getServiceCenterName() {
		return serviceCenterName;
	}
	public void setServiceCenterName(String serviceCenterName) {
		this.serviceCenterName = serviceCenterName;
	}
}