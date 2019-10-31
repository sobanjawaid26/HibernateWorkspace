package org.hibernate;

import java.util.Date;

import org.hibernate.cfg.Configuration;
import org.hibernate.dto.Address;
import org.hibernate.dto.UserDetails;

public class Test {

	public static void main(String[] args) {
		
		UserDetails user = new UserDetails();
		user.setUserId(1);
		user.setUserName("First User");		
		
		Address address1 = new Address();
		address1.setStreet("2nd cross");
		address1.setCity("Bangalore");
		address1.setState("Karnataka");
		address1.setPincode("560029");
		address1.setAddressType("home");
	
		user.setAddress(address1);
		address1.setUser(user);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
	}
	
}
