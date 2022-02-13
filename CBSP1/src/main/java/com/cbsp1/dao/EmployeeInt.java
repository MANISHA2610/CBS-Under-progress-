package com.cbsp1.dao;

import com.cbsp1.model.Employee;
import com.cbsp1.model.Requests;

public interface EmployeeInt {

	public boolean login(Integer EId, String password);
	public boolean requestCab(Requests request);
	public boolean viewBookHis(Employee emp);
	public boolean viewCabs();
	public boolean viewReq(Employee employee);
	
	
}
