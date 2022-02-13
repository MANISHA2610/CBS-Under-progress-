package com.cbsp1.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cbsp1.dao.EmployeeImpl;
import com.cbsp1.dao.EmployeeInt;
import com.cbsp1.model.Employee;
import com.cbsp1.model.Requests;

/**
 * Servlet implementation class RequestCab
 */
public class RequestCab extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession sess = request.getSession(false);
		Integer EId = (Integer) sess.getAttribute("EId");
		
		String status ="Pending";
		Timestamp rDate = new Timestamp(System.currentTimeMillis());
		EmployeeInt reqCab = new EmployeeImpl();
		Requests req = new Requests(status, EId, rDate);
		req.setStatus(status);
		req.setEmp(EmployeeImpl.employees.get(0));
		req.setrDate(rDate);
		if(reqCab.requestCab(req)) {
			out.println("Cab requested successfully!!");
		}
		else {
			out.println("Cab request failed!!");
		}

}
}