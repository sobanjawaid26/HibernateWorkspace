package org.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.dto.FourWheeler;
import org.hibernate.dto.TwoWheeler;
import org.hibernate.dto.Vehicle;

public class Test {

	public static void main(String[] args) {

		Vehicle v = new Vehicle();
		v.setVehicleName("Truck");

		TwoWheeler bike = new TwoWheeler();
		bike.setControlHandle("handle");
		
		FourWheeler car = new FourWheeler();
		car.setSteeringWheel("Steering Wheel");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(v);
		session.save(bike);
		session.save(car);

		session.getTransaction().commit();
		session.close();

//		session = null;
//		try {
//			session = new Configuration().configure().buildSessionFactory().openSession();
//
//			Mobile m = session.load(Mobile.class, 2);
//			System.out.println(m.getId() + " " + m.getBrand() + " " + m.getModel());
//			UserDetails userObject = m.getUser();
//			System.out.println(userObject.getUserName());
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//
//		}

	}

}
