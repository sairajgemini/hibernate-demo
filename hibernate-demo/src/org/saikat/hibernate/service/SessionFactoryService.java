package org.saikat.hibernate.service;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryService {

	private static SessionFactory sessionFactory;

	public static SessionFactory create() {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		return sessionFactory;
	}

	public static void close(SessionFactory factory) {
		sessionFactory = factory;
		if (sessionFactory != null) {
			sessionFactory.close();
			sessionFactory = null;
		}
	}

}
