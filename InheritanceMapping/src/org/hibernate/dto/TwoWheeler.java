package org.hibernate.dto;

import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vehicle {

	private String controlHandle;

	public String getControlHandle() {
		return controlHandle;
	}

	public void setControlHandle(String controlHandle) {
		this.controlHandle = controlHandle;
	}
	
}
