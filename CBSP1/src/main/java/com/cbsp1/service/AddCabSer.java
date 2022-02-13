package com.cbsp1.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cbsp1.dao.AdminImpl;
import com.cbsp1.dao.AdminInt;
import com.cbsp1.model.Cab;

/**
 * Servlet implementation class AddCabSer
 */
public class AddCabSer extends HttpServlet {
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String cabNo=request.getParameter("cabNo");
		String dName=request.getParameter("dName");
		String dMobile=request.getParameter("mobile");
		Integer AvailableTime=Integer.parseInt(request.getParameter("hours"));
		Integer active=1;
		
		Cab cab = new Cab(cabNo, dName, dMobile, AvailableTime, active);
		AdminInt adImpl = new AdminImpl();
		
		boolean result = adImpl.addCab(cab);
		if(result) {
			out.println("Successfully inserted record");
		}
		else {
			out.println("Mission failed");
		}
	}

}
