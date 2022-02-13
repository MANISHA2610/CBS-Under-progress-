package com.cbsp1.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cbsp1.model.Requests;

public class ManagerImpl implements ManagerInt{
	
	public static List<Requests> requests = null;

	public boolean acceptRequest(Integer reqId) {
		
		Session session = DbConnectImpl.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query q=session.createQuery(" update Requests r set r.status='Approved' where r.reqId= :reqId")
				.setParameter("reqId", reqId);
		q.executeUpdate();
		
		if(tx!=null) {
			tx.commit();
		}
		else {
			tx.rollback();
		}
		session.close();
		return true;
	}
	
	public boolean rejectRequest(Integer reqId) {
		
		Session session = DbConnectImpl.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query q=session.createQuery(" update Requests r set r.status='Rejected' where r.reqId= :reqId")
				.setParameter("reqId", reqId);
		q.executeUpdate();
		
		if(tx!=null) {
			tx.commit();
		}
		else {
			tx.rollback();
		}
		session.close();
		return true;
	}
	
	public boolean checkRequest() {
		Session session = DbConnectImpl.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Query query=session.createQuery("from "+ Requests.class.getName() +" r where status = 'Pending'");
		requests = query.list();
		
		return true;
	}

}
