package com.cbsp1.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cbsp1.model.Cab;
import com.cbsp1.model.Employee;
import com.cbsp1.model.Requests;

public class AdminImpl implements AdminInt{

	public static List<Cab> cablist = null;
	public static List<Employee> emplist = null;
	
	public boolean addEmp(Employee emp) {
		Session session = DbConnectImpl.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(emp);
		
		if(tx!=null) {
			tx.commit();
		}
		else {
			tx.rollback();
		}
		session.close();
		return true;
	}
	
	public boolean addCab(Cab cab) {
		Session session = DbConnectImpl.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(cab);
		if(tx!=null) {
			tx.commit();
		}
		else {
			tx.rollback();
		}
		session.close();
		return true;
	}
	
	public boolean viewCabs() {
		Session session = DbConnectImpl.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Query query=session.createQuery("from Cab c");
		cablist = query.list();

		if(tx!=null) {
			tx.commit();
		}
		else {
			tx.rollback();
		}
		session.close();
		return true;
	}
	
	public boolean viewEmp() {
		Session session = DbConnectImpl.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Query query=session.createQuery("from Employee e where EId > :EId");
		query.setParameter("EId", 100);
		emplist = query.list();

		if(tx!=null) {
			tx.commit();
		}
		else {
			tx.rollback();
		}
		session.close();
		return true;
	}
	
	public boolean AssignCab() {
		
		return true;
	}


}
