package org.hibernate.dto;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "user_details")
public class UserDetails {

	@Id
	@Column(name = "id")
	private int userId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Embedded
	@AttributeOverrides({
	@AttributeOverride (name = "street",
						column = @Column(name="home_street_name")
			),
	@AttributeOverride (name = "city",
						column = @Column(name="home_city_name")
			),
	@AttributeOverride (name = "state",
						column = @Column(name="home_state_name")
			),
	@AttributeOverride (name = "pincode",
						column = @Column(name="home_pincode_name")
			)})
	
	private Address homeAddress;
	
	@Embedded
	private Address officeAddress;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	

	
}
	
