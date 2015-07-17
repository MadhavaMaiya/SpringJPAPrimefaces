/**
 * 
 */
package com.madhava.domain.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.madhava.domain.common.LookupEntity;
import com.madhava.domain.common.view.DepartmentView;
import com.madhava.domain.security.helper.SpringSecurityUser;
import com.madhava.service.security.IUser;
/**
 * @author Madhava
 *
 */
@Entity
@Indexed
@Audited
@Table(name="ENTERPRISEUSER")
public class EnterpriseUser implements IUser {
	
	public static Long ENTERPRISE_USER_TYPE = 1l;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	@Transient
	private String userCode;
	@Column(name="LOGIN", length=50, nullable=false, unique=true)
	private String username;
	@Column(name="USERNAME", length=100, nullable=false)
	private String userFullName;
	@Column(name="PASSWORD", length=50, nullable=false)
	private String password;
	@Column(name="ISACTIVE", nullable=false)
	private Boolean isActive = Boolean.TRUE;
	@Transient
	private Branch branch = new Branch();
	@Transient
	private DepartmentView department = new DepartmentView();
	@Transient
	private Location location = new Location();
	@Column(name="GLOBALBRANCH", nullable=false)
	private Boolean globalBranch=Boolean.FALSE;
	@Column(name="GLOBALDEPARTMENT", nullable=false)
	private Boolean globalDepartment=Boolean.FALSE;
	@Transient
	private String timeZone = "IST";
	@Transient
	private List<String> priveleges = new ArrayList<String>();
	@Column(name="EMAILID", length=100)
	private String emailId;
	@Column(name="EMPLOYEE_ID")
	private Long employee;
	@ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="USERTYPE")
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	private LookupEntity userType = new LookupEntity();
	@Column(name="PASSWORDMODIFIEDDATE")
	private Date pswModifiedDate;
	@Column(name="MAXFAILEDLOGINATTEMPT")
	private Integer maxFailedLoginAttempt;
	@Column(name="ISPASSWORDEXPIRES")
	private Boolean isPswExpires=Boolean.FALSE;
	@Column(name="PASSWORDEXPIRYDAYS")
	private Integer pswExpiryDays;
	@Column(name="PASSWORDCHANGEREQD")
	private Boolean pswChangeReqd=Boolean.FALSE;
	@Column(name="IMAGENAME")
	private String imageName;
	@Column(name="DESCRIPTION")
	private String remarks;
	
	/**
	 * Constructor EnterpriseUser
	 * @author Madhava
	 * @since Jul 27, 2014 - 4:47:15 PM
	 * @version UserManagement 1.0
	 */
	public EnterpriseUser(){
		super();
	}

	/**
	 * Constructor EnterpriseUser
	 * @author Madhava
	 * @since Jul 27, 2014 - 4:47:22 PM
	 * @version UserManagement 1.0
	 * @param id
	 * @param username
	 * @param userFullName
	 * @param isActive
	 */
	public EnterpriseUser(Long id, String username, String userFullName, Boolean isActive) {
		this.id = id;
		this.username = username;
		this.userFullName = userFullName;
		this.isActive = isActive;
	}

	/**
	 * Constructor EnterpriseUser
	 * @author Madhava
	 * @since Jul 27, 2014 - 4:47:29 PM
	 * @version UserManagement 1.0
	 * @param id
	 * @param username
	 * @param password
	 * @param isActive
	 * @param privelege
	 */
	public EnterpriseUser(Long id, String username, String password, Boolean isActive, List<String> privelege) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.isActive = isActive;
		this.priveleges = privelege;
	}

	
	/**
	 * @return the eNTERPRISE_USER_TYPE
	 */
	public static Long getENTERPRISE_USER_TYPE() {
		return ENTERPRISE_USER_TYPE;
	}

	/**
	 * @param eNTERPRISE_USER_TYPE the eNTERPRISE_USER_TYPE to set
	 */
	public static void setENTERPRISE_USER_TYPE(Long eNTERPRISE_USER_TYPE) {
		ENTERPRISE_USER_TYPE = eNTERPRISE_USER_TYPE;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the branch
	 */
	public Branch getBranch() {
		return branch;
	}

	/**
	 * @param branch the branch to set
	 */
	public void setBranch(Branch branch) {
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
	 * @return the globalBranch
	 */
	public Boolean getGlobalBranch() {
		return globalBranch;
	}

	/**
	 * @param globalBranch the globalBranch to set
	 */
	public void setGlobalBranch(Boolean globalBranch) {
		this.globalBranch = globalBranch;
	}

	/**
	 * @return the globalDepartment
	 */
	public Boolean getGlobalDepartment() {
		return globalDepartment;
	}

	/**
	 * @param globalDepartment the globalDepartment to set
	 */
	public void setGlobalDepartment(Boolean globalDepartment) {
		this.globalDepartment = globalDepartment;
	}

	/**
	 * @return the timeZone
	 */
	public String getTimeZone() {
		return timeZone;
	}

	/**
	 * @param timeZone the timeZone to set
	 */
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	/**
	 * @return the priveleges
	 */
	public List<String> getPriveleges() {
		return priveleges;
	}

	/**
	 * @param priveleges the priveleges to set
	 */
	public void setPriveleges(List<String> priveleges) {
		this.priveleges = priveleges;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the employee
	 */
	public Long getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Long employee) {
		this.employee = employee;
	}

	/**
	 * @return the userType
	 */
	public LookupEntity getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(LookupEntity userType) {
		this.userType = userType;
	}

	/**
	 * @return the pswModifiedDate
	 */
	public Date getPswModifiedDate() {
		return pswModifiedDate;
	}

	/**
	 * @param pswModifiedDate the pswModifiedDate to set
	 */
	public void setPswModifiedDate(Date pswModifiedDate) {
		this.pswModifiedDate = pswModifiedDate;
	}

	/**
	 * @return the maxFailedLoginAttempt
	 */
	public Integer getMaxFailedLoginAttempt() {
		return maxFailedLoginAttempt;
	}

	/**
	 * @param maxFailedLoginAttempt the maxFailedLoginAttempt to set
	 */
	public void setMaxFailedLoginAttempt(Integer maxFailedLoginAttempt) {
		this.maxFailedLoginAttempt = maxFailedLoginAttempt;
	}

	/**
	 * @return the isPswExpires
	 */
	public Boolean getIsPswExpires() {
		return isPswExpires;
	}

	/**
	 * @param isPswExpires the isPswExpires to set
	 */
	public void setIsPswExpires(Boolean isPswExpires) {
		this.isPswExpires = isPswExpires;
	}

	/**
	 * @return the pswExpiryDays
	 */
	public Integer getPswExpiryDays() {
		return pswExpiryDays;
	}

	/**
	 * @param pswExpiryDays the pswExpiryDays to set
	 */
	public void setPswExpiryDays(Integer pswExpiryDays) {
		this.pswExpiryDays = pswExpiryDays;
	}

	/**
	 * @return the pswChangeReqd
	 */
	public Boolean getPswChangeReqd() {
		return pswChangeReqd;
	}

	/**
	 * @param pswChangeReqd the pswChangeReqd to set
	 */
	public void setPswChangeReqd(Boolean pswChangeReqd) {
		this.pswChangeReqd = pswChangeReqd;
	}

	/**
	 * @return the imageName
	 */
	public String getImageName() {
		return imageName;
	}

	/**
	 * @param imageName the imageName to set
	 */
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param userFullName the userFullName to set
	 */
	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	/**
	 * Method toAcegiUser
	 * @author Madhava
	 * @since Jul 27, 2014 - 4:47:36 PM
	 * @version UserManagement 1.5
	 * @return
	 * @see com.madhava.service.security.IUser#toAcegiUser()
	 */
	public User toAcegiUser(){
		return new SpringSecurityUser(id, username, password, userFullName, ENTERPRISE_USER_TYPE ,
				isActive, buildGrantedAuthorities(priveleges), employee);
	}

	/**
	 * Method buildGrantedAuthorities
	 * @author Madhava
	 * @since Jul 27, 2014 - 4:47:44 PM
	 * @version UserManagemenr 1.0
	 * @param privelege
	 * @return
	 */
	private static Collection<? extends GrantedAuthority> buildGrantedAuthorities(List<String> privelege) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_DEFAULT"));
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		for(String priveleg : privelege){
			String preveligeObj=(String) priveleg;
			authorities.add(new SimpleGrantedAuthority(preveligeObj));
		}
		return authorities;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getUserFullName() {
		return userFullName;
	}
	
}
