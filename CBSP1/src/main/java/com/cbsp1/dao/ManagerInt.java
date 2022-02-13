package com.cbsp1.dao;

import com.cbsp1.model.Requests;

public interface ManagerInt {

//	public boolean loginM();
	public boolean acceptRequest(Integer reqId);
	public boolean rejectRequest(Integer reqId);
	public boolean checkRequest();
}
