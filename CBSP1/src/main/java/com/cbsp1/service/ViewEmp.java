package com.cbsp1.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cbsp1.dao.AdminImpl;
import com.cbsp1.dao.AdminInt;
import com.cbsp1.dao.EmployeeImpl;
import com.cbsp1.dao.EmployeeInt;
import com.cbsp1.model.Employee;
import com.cbsp1.model.Requests;

/**
 * Servlet implementation class ViewEmp
 */
public class ViewEmp extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession sess = request.getSession(false);
		
		AdminInt Adminemp = new AdminImpl();
		Adminemp.viewEmp();
		if(Adminemp.viewEmp()) {
			out.println("Here is the list of your requests!");
			out.println("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Insert title here</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "<div>\r\n"
					+ "<table>\r\n"
					+ "\r\n"
					+ "<tr>\r\n"
					+ "<th>Employee Id</th>\r\n"
					+ "<th>Name</th>\r\n"
					+ "<th>Mobile</th>\r\n"
					+ "<th>Email Id</th>\r\n"
					+ "<th>Date of Joining</th>\r\n"
					+ "<th>Department Id</th>\r\n"
					+ "</tr>\r\n");
			for(Employee e: AdminImpl.emplist) {
				out.println("<tr>\r\n");	
				out.println("<td>"+e.getEId()+"</td>\\r\\n");
				out.println("<td>"+e.getName()+"</td>\\r\\n");
				out.println("<td>"+e.getMobile()+"</td>\\r\\n");
				out.println("<td>"+e.getEmail()+"</td>\\r\\n");
				out.println("<td>"+e.getDoj()+"</td>\\r\\n");
				out.println("<td>"+e.getDept()+"</td>\\r\\n");
				out.println("</tr>\r\n");
			}
					out.println("</table>\r\n"
							+ "</div>\r\n"
							+ "</body>\r\n"
							+ "</html>");
		}
		else {
			out.println("Please try again later!");
		}
	}

}
