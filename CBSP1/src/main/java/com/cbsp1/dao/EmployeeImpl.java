package com.cbsp1.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cbsp1.model.BookingHistory;
import com.cbsp1.model.Cab;
import com.cbsp1.model.Employee;
import com.cbsp1.model.Requests;

public class EmployeeImpl implements EmployeeInt {

	public static List<Employee> employees = null;
	public static List<Requests> requests = null;
	public static List<BookingHistory> bookinghistory = null;
	public static List<Cab> cablist = null;
	
public boolean login(Integer EId, String password) {
		
		Session session = DbConnectImpl.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Query query=session.createQuery("from Employee e where e.EId = :EId and e.password = :password")
				.setParameter("EId",EId)
				.setParameter("password",password);
		employees = query.list();
		if(employees.size()==1) {
			return true;
		}
		else {
			tx.rollback();
		}
		session.close();
		return true;
	}

	public boolean requestCab(Requests req) {
		Session session = DbConnectImpl.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(req);
		if(tx!=null) {
			tx.commit();
		}
		else {
			tx.rollback();
		}
		session.close();
		return true;
	}
	
	public boolean viewReq(Employee emp) {
		Session session = DbConnectImpl.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Query query=session.createQuery("from "+Requests.class.getName()+" r where emp_EId = :EId")
				.setParameter("EId", EmployeeImpl.employees.get(0));
		requests = query.list();
		
		return true;
	}
	
	public boolean viewCabs() {
		Session session = DbConnectImpl.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Query query=session.createQuery("from Cab c where c.active = 1");
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
	
	public boolean viewBookHis(Employee emp) {
		Session session = DbConnectImpl.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Query query=session.createQuery("from "+ BookingHistory.class.getName()+" r where emp_EId = :EId")
				.setParameter("EId", EmployeeImpl.employees.get(0));
		bookinghistory = query.list();
		session.close();
		return true;
	}
	
}
