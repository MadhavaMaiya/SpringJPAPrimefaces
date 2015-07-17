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

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
/**
 * Class ContactMode
 * @author Madhava
 * @since Jul 31, 2014 - 10:56:18 AM
 * @version UserManagement 1.0
 */
@Entity
@Audited
@Table(name="CONTACTMODE")
public class ContactMode extends BaseDomain{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5697837760947430054L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CONTACTMODE_ID")
	private Long contactModeId;
	@ManyToOne @JoinColumn(name="MODE_OF_CONTACT")
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	private LookupEntity methodOfContact=new LookupEntity();
	@Column(name="CONTACT_ID")
	private String contactId;
	@Column(name="ISPRIMARYCONTACT", nullable=false)
	private Boolean isPrimayContact = Boolean.FALSE;
	/**
	 * @return the contactModeId
	 */
	public Long getContactModeId() {
		return contactModeId;
	}
	/**
	 * @param contactModeId the contactModeId to set
	 */
	public void setContactModeId(Long contactModeId) {
		this.contactModeId = contactModeId;
	}
	/**
	 * @return the methodOfContact
	 */
	public LookupEntity getMethodOfContact() {
		return methodOfContact;
	}
	/**
	 * @param methodOfContact the methodOfContact to set
	 */
	public void setMethodOfContact(LookupEntity methodOfContact) {
		this.methodOfContact = methodOfContact;
	}
	/**
	 * @return the contactId
	 */
	public String getContactId() {
		return contactId;
	}
	/**
	 * @param contactId the contactId to set
	 */
	public void setContactId(String contactId) {
		this.contactId = contactId;
	}
	/**
	 * @return the isPrimayContact
	 */
	public Boolean getIsPrimayContact() {
		return isPrimayContact;
	}
	/**
	 * @param isPrimayContact the isPrimayContact to set
	 */
	public void setIsPrimayContact(Boolean isPrimayContact) {
		this.isPrimayContact = isPrimayContact;
	}
	
	
}
