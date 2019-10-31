package org.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.dto.UserDetails;
import org.hibernate.dto.Vehicle;

public class Test {

	public static void main(String[] args) {

		UserDetails user1 = new UserDetails();
		user1.setUserName("First User");
		
		UserDetails user2 = new UserDetails();
		user2.setUserName("Second User");

		Vehicle vehicle1 = new Vehicle();
		Vehicle vehicle2 = new Vehicle();
		Vehicle vehicle3 = new Vehicle();
		vehicle1.setModel("Tesla S");
		vehicle2.setModel("Jeep");
		vehicle3.setModel("Activa");

		user1.getListOfVehicle().add(vehicle1);
		user1.getListOfVehicle().add(vehicle2);
		user1.getListOfVehicle().add(vehicle3);
		vehicle1.getListOfUser().add(user1);
		vehicle2.getListOfUser().add(user1);
		vehicle3.getListOfUser().add(user1);


		Vehicle vehicle4 = new Vehicle();
		Vehicle vehicle5 = new Vehicle();
		Vehicle vehicle6 = new Vehicle();
		vehicle4.setModel("Toyota Corolla");
		vehicle5.setModel("Hyundai");
		vehicle6.setModel("Dominar");
		
		user2.getListOfVehicle().add(vehicle4);
		user2.getListOfVehicle().add(vehicle5);
		user2.getListOfVehicle().add(vehicle6);
		vehicle4.getListOfUser().add(user2);
		vehicle5.getListOfUser().add(user2);
		vehicle6.getListOfUser().add(user2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user1);
		session.save(user2);
		session.save(vehicle1);
		session.save(vehicle2);
		session.save(vehicle3);
		session.save(vehicle4);
		session.save(vehicle5);
		session.save(vehicle6);

		
		session.getTransaction().commit();
		session.close();

//		session = null;
//		try {
//			session = new Configuration().configure().buildSessionFactory().openSession();
//
//			Vehicle v = session.get(Vehicle.class, 1);
//			System.out.println(m.getId() + " " + m.getBrand() + " " + m.getModel());
//			UserDetails userObject = m.getUser();
//			System.out.println(userObject.getUserName());
//		} catch (Exception e) {
//			e.printStackTrace();
//			
//
//		}

	}

}
