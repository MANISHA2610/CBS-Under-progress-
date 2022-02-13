package com.cbsp1.dao;

import com.cbsp1.model.Cab;
import com.cbsp1.model.Employee;

public interface AdminInt {

	public boolean addEmp(Employee emp);
	public boolean addCab(Cab cab);
	public boolean viewCabs();
	public boolean viewEmp();
}
