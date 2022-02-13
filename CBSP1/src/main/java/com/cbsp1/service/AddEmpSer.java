package com.cbsp1.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cbsp1.dao.AdminImpl;
import com.cbsp1.dao.AdminInt;
import com.cbsp1.model.Dept;
import com.cbsp1.model.Employee;

/**
 * Servlet implementation class AddEmpServlet
 */
public class AddEmpSer extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String chkManager=request.getParameter("checkManager");
		
		String manager="";
		
		if(chkManager=="2") {
			manager="Yes";
		}
		else {
			manager="No";
		}
		
		String password= name+"@2022";
		Date doj = null;
		try {
			doj = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("doj"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Employee emp = new Employee(name, email, mobile, manager, doj, password);
		AdminInt empl = new AdminImpl();

		boolean result = empl.addEmp(emp);
		if(result) {
			out.println("Successfully inserted record");
		}
		else {
			out.println("Mission failed");
		}
	}

}
