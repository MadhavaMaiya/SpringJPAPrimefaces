/*
* Created on Aug 24, 2014
* @author Madhava
*/
package com.madhava.domain.common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;

import com.madhava.domain.security.Branch;
/**
 * Class EnterpriseUserBranch
 * @author Madhava
 * @since Aug 24, 2014 - 11:11:56 AM
 * @version UserManagement 1.0
 */
@Entity
@Indexed
@Audited
@Table(name="USERSITEMAP")
public class EnterpriseUserBranch implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -181543391193416504L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USERSITEMAPID")
	private Long id;
	
	@Column(name="ENTERPRISEUSER")
	private Long user;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="SITE")
	private Branch branch;

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
	 * @return the user
	 */
	public Long getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(Long user) {
		this.user = user;
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
	
	
}
