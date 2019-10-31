package org.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vehicle_id")
	private int id;
	private String model;
	
	@ManyToMany(mappedBy="listOfVehicle")
	private Collection<UserDetails> listOfUser = new ArrayList<UserDetails>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Collection<UserDetails> getListOfUser() {
		return listOfUser;
	}
	public void setListOfUser(Collection<UserDetails> listOfUser) {
		this.listOfUser = listOfUser;
	}
	
	
	
}
