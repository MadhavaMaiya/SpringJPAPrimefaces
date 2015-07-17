/*
 * Created on Jul 27, 2014
 * @author Madhava
 */
package com.madhava.domain.security.helper;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * Class SpringSecurityUser
 * 
 * @author Madhava
 * @since Jul 27, 2014 - 4:09:10 PM
 * @version UserManagement 1.0
 */
public class SpringSecurityUser extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5176471809060925035L;

	private Long id;
	private String userFullName;
	private Long userType;
	private LogedInUser logedUser;
	private Long employeeId;


	/**
	 * Constructor SpringSecurityUser
	 * 
	 * @author Madhava
	 * @since Jul 27, 2014 - 4:09:31 PM
	 * @version UserManagement 1.0
	 * @param username
	 * @param password
	 * @param enabled
	 * @param accountNonExpired
	 * @param credentialsNonExpired
	 * @param accountNonLocked
	 * @param authorities
	 */
	public SpringSecurityUser(String username, String password,
			boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
	}

	/**
	 * Constructor SpringSecurityUser
	 * 
	 * @author Madhava
	 * @since Jul 28, 2014 - 11:40:07 AM
	 * @version UserManagement 1.0
	 * @param id
	 * @param username
	 * @param password
	 * @param userFullName
	 * @param userType
	 * @param isActive
	 * @param buildGrantedAuthorities
	 * @param employee
	 */
	public SpringSecurityUser(Long id, String username, String password,
			String userFullName, Long userType, boolean isActive,
			Collection<? extends GrantedAuthority> buildGrantedAuthorities,
			Long employee) {
		super(username, password, isActive, true, true, true,
				buildGrantedAuthorities);
		this.id = id;
		this.userFullName = userFullName;
		this.userType = userType;
		this.employeeId = employee;
	}

	/**
	 * Constructor SpringSecurityUser
	 * 
	 * @author Madhava
	 * @since Jul 28, 2014 - 11:40:34 AM
	 * @version UserManagement 1.0
	 * @param id
	 * @param username
	 * @param password
	 * @param userFullName
	 * @param userType
	 * @param active
	 * @param roles
	 * @param logedUser
	 * @param employeeId
	 * @throws IllegalArgumentException
	 */
	public SpringSecurityUser(Long id, String username, String password,
			String userFullName, Long userType, boolean active,
			Collection<? extends GrantedAuthority> roles,
			LogedInUser logedUser, Long employeeId)
			throws IllegalArgumentException {
		super(username, password, active, true, true, true, roles);
		this.id = id;
		this.userFullName = userFullName;
		this.userType = userType;
		this.logedUser = logedUser;
		this.employeeId = employeeId;
	}
	
	public LogedInUser getLogedUser() {
		return logedUser;
	}

	public Long getId() {
		return id;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public Long getUserType() {
		return userType;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

}
