package org.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.dto.Mobile;
import org.hibernate.dto.UserDetails;

public class Test {

	public static void main(String[] args) {

		UserDetails user = new UserDetails();
		user.setUserId(1);
		user.setUserName("First User");

		Mobile mobile1 = new Mobile();
		mobile1.setBrand("Samsung");
		mobile1.setModel("galaxy");

		Mobile mobile2 = new Mobile();
		mobile2.setBrand("Oppo");
		mobile2.setModel("A1");

		user.getListOfMobile().add(mobile1);
		user.getListOfMobile().add(mobile2);
		mobile1.setUser(user);
		mobile2.setUser(user);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();

		session = null;
		try {
			session = new Configuration().configure().buildSessionFactory().openSession();

			Mobile m = session.load(Mobile.class, 2);
			System.out.println(m.getId() + " " + m.getBrand() + " " + m.getModel());
			UserDetails userObject = m.getUser();
			System.out.println(userObject.getUserName());
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();

		}

	}

}
