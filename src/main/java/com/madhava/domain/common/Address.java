/*
* Created on Jul 31, 2014
* @author Madhava
*/
package com.madhava.domain.common;

import java.io.Serializable;

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
 * Class Address
 * @author Madhava
 * @since Jul 31, 2014 - 10:51:12 AM
 * @version UserManagement 1.0
 */

@Entity
@Table(name="ADDRESS")
@Audited
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2882066804479276824L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ADDRESS_ID")
	private Long addressId;
	
	@Column(name="ADDRESS")
	private String address;
	@Column(name="ADDRESS1")
	private String address1;
	@Column(name="PLACE")
	private String place;
	@Column(name="PIN")
	private String pin;
	@ManyToOne @JoinColumn(name="CITY_ID")
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	private City city=new City();
	@ManyToOne @JoinColumn(name="COUNTRY_ID", nullable=false)
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	private Country country=new Country();
	@ManyToOne @JoinColumn(name="STATE_ID")
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	private State state=new State();	
	@ManyToOne @JoinColumn(name="DISTRICT_ID")
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	private District district=new District();
	
	/**
	 * Constructor Address
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:09:29 PM
	 * @version UserManagement 1.0
	 */
	public Address() {
		super();
	}

	/**
	 * Constructor Address
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:09:36 PM
	 * @version UserManagement 1.0
	 * @param address
	 * @param address1
	 * @param place
	 * @param pin
	 * @param cityId
	 * @param cityName
	 * @param countryId
	 * @param countryName
	 * @param stateId
	 * @param stateName
	 * @param districtId
	 * @param districtName
	 */
	public Address(String address, String address1,
			String place, String pin,Long cityId ,String cityName, Long countryId,String countryName, Long stateId,String stateName,
			Long districtId,String districtName) {
		super();
		this.address = address;
		this.address1 = address1;
		this.place = place;
		this.pin = pin;
		this.city = new City(cityId,cityName);
		this.country = new Country(countryId,countryName);
		this.state = new State(stateId,stateName);
		this.district = new District(districtId,districtName);
	}
	
	/**
	 * Constructor Address
	 * @author Madhava
	 * @since Jul 31, 2014 - 9:09:49 PM
	 * @version UserManagement 1.0
	 * @param address
	 * @param address1
	 * @param place
	 * @param pin
	 * @param cityName
	 * @param countryName
	 * @param stateName
	 * @param districtName
	 */
	public Address(String address, String address1,
			String place, String pin, String cityName, String countryName, String stateName,
			String districtName) {
		super();
		this.address = address;
		this.address1 = address1;
		this.place = place;
		this.pin = pin;
		this.city = new City(cityName);
		this.country = new Country(countryName);
		this.state = new State(stateName);
		this.district = new District(districtName);
	}

	/**
	 * @return the addressId
	 */
	public Long getAddressId() {
		return addressId;
	}

	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * @param place the place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * @return the pin
	 */
	public String getPin() {
		return pin;
	}

	/**
	 * @param pin the pin to set
	 */
	public void setPin(String pin) {
		this.pin = pin;
	}

	/**
	 * @return the city
	 */
	public City getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}

	/**
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
	}

	/**
	 * @return the state
	 */
	public State getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 * @return the district
	 */
	public District getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(District district) {
		this.district = district;
	}
	
	

}
