package com.cbsp1.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbConnectImpl {

	public static SessionFactory getSessionFactory() {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		return factory;
		
	}
}
