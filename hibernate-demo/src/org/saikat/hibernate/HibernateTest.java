package org.saikat.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.saikat.dto.Address;
import org.saikat.dto.UserDetails;
import org.saikat.hibernate.service.SessionFactoryService;

public class HibernateTest {

	public static void main(String[] args) {
		SessionFactory factory = SessionFactoryService.create();
		Session session = factory.openSession();

		List<Address> addresses = new ArrayList<>();

		addresses.add(new Address("J1886 CR Park", "New Delhi", "Delhi", "110019"));
		addresses.add(new Address("26/A Chandra Mondal Lane", "Kolkata", "West Bengal", "700026"));

		UserDetails user = new UserDetails("Saikat Gupta", new Date(), addresses, "Admin user");

		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();

		user = null;
		session = factory.openSession();
		session.beginTransaction();
		user = session.get(UserDetails.class, 1);
		System.out.println(user);
		session.getTransaction().commit();
		session.close();

		SessionFactoryService.close(factory);
	}

}
