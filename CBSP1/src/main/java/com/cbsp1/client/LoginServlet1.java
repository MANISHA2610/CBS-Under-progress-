package com.cbsp1.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cbsp1.dao.EmployeeImpl;
import com.cbsp1.dao.EmployeeInt;

public class LoginServlet1 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
				
		Integer EId=Integer.parseInt(request.getParameter("EId"));
		String password=request.getParameter("password");
		Integer ch=Integer.parseInt(request.getParameter("loginperson"));
		
		EmployeeInt empl = new EmployeeImpl(); 
		
		switch(ch)
		{
		case 1:
			out.println("Please select any one option to login");
			break;
		case 2:
			if(empl.login(EId, password)) {
				HttpSession sess=request.getSession();
				sess.setMaxInactiveInterval(10000);
				sess.setAttribute("EId",EId);
				out.println("Logged in Successfully as Employee !!");
				out.println("<!DOCTYPE html>\r\n"
						+ "<html>\r\n"
						+ "<head>\r\n"
						+ "<meta charset=\"ISO-8859-1\">\r\n"
						+ "<title>Insert title here</title>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "  <br>\r\n"
						+ "  <form action=\"requestcab\" method=\"post\">\r\n"
						+ "<h3>Welcome Mr. Employee</h3>\r\n"
						+ "  <input type=\"submit\" name=\"requestCab\" value=\"Request a Cab\">\r\n"
						+ "  </form>\r\n"
						+ "  <br>\r\n"
						+ "  <form action=\"viewcab\" method=\"post\">\r\n"
						+ "  <input type=\"submit\" name=\"availCab\" value=\"View available Cabs\">\r\n"
						+ "  </form>\r\n"
						+ "  <br>\r\n"
						+ "  <form action=\"viewrequests\" method=\"post\">\r\n"
						+ "  <input type=\"submit\" name=\"reqStatus\" value=\"Check request status\">\r\n"
						+ "  </form>\r\n"
						+ "  <br>\r\n"
						+ "  <form action=\"bookinghistory\" method=\"post\">\r\n"
						+ "  <input type=\"submit\" name=\"bookHis\" value=\"View Booking History\">\r\n"
						+ "  </form>\r\n"
						+ "</body>\r\n"
						+ "</html>");
//				RequestDispatcher rd=request.getRequestDispatcher("Manager.html");
//				rd.include(request, response);
				}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
				rd.include(request, response);
				out.println("Wrong credentials!! Please try again!");
				}
			break;

		case 3:
			if(empl.login(EId, password)) {
				HttpSession s=request.getSession(true);
				s.setMaxInactiveInterval(10000);
				s.setAttribute("EId",EId);
				out.println("Logged in Successfully as Manager!!");
//				RequestDispatcher rd=request.getRequestDispatcher("Manager.html");
//				rd.include(request, response);
				out.println("<!DOCTYPE html>\r\n"
						+ "<html>\r\n"
						+ "<head>\r\n"
						+ "<meta charset=\"ISO-8859-1\">\r\n"
						+ "<title>Insert title here</title>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "\r\n"
						+ "<h3>Welcome Mr. Manager</h3>\r\n"
						+ "  <br>\r\n"
						+ "  <form action=\"viewemp\" method=\"post\">\r\n"
						+ "  <input type=\"submit\" name=\"viewEmp\" value=\"View Employees\">\r\n"
						+ "  </form>\r\n"
						+ "  <br>\r\n"
						+ "  <form action=\"viewcab\" method=\"post\">\r\n"
						+ "  <input type=\"submit\" name=\"viewCab\" value=\"View Cabs\">\r\n"
						+ "  </form>\r\n"
						+ "  <br>\r\n"
						+ "  <form action=\"checkrequests\" method=\"post\">\r\n"
						+ "  <input type=\"submit\" name=\"checkPendingReq\" value=\"Check Requests\">\r\n"
						+ "  </form>\r\n"
						+ "  <br>\r\n"
						+ "\r\n"
						+ "</body>\r\n"
						+ "</html>");
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
				rd.include(request, response);
				out.println("Wrong credentials!! Please try again!");
				}
			break;
		case 4:
			if(empl.login(EId, password)) {
				HttpSession s=request.getSession(true);
				s.setMaxInactiveInterval(10000);
				s.setAttribute("EId",EId);
				out.println("Logged in Successfully as Admin!!");
				out.println("<!DOCTYPE html>\r\n"
						+ "<html>\r\n"
						+ "<head>\r\n"
						+ "<meta charset=\"ISO-8859-1\">\r\n"
						+ "<title>Insert title here</title>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "<h3>Welcome Mr. Admin</h3>\r\n"
						+ "<div>\r\n"
						+ "  <br>\r\n"
						+ "  <form action=\"viewemp\" method=\"post\">\r\n"
						+ "  <input type=\"submit\" name=\"viewEmp\" value=\"View Employees\">\r\n"
						+ "  </form>\r\n"
						+ "  <br>\r\n"
						+ "  <form action=\"viewcab\" method=\"post\">\r\n"
						+ "  <input type=\"submit\" name=\"viewCab\" value=\"View Cabs\">\r\n"
						+ "  </form>\r\n"
						+ "  <br>\r\n"
						+ "  <form action=\"AddEmployee.html\" method=\"post\">\r\n"
						+ "  <input type=\"submit\" name=\"addEmp\" value=\"Add Employees\">\r\n"
						+ "  </form>\r\n"
						+ "  <br>\r\n"
						+ "  <form action=\"Cab.html\" method=\"post\">\r\n"
						+ "  <input type=\"submit\" name=\"addCab\" value=\"Add Cab\">\r\n"
						+ "  </form>\r\n"
						+ "  <br>\r\n"
						+ "  <form action=\"viewrequest\" method=\"post\">\r\n"
						+ "  <input type=\"submit\" name=\"checkReq\" value=\"Check Requests\">\r\n"
						+ "  </form>\r\n"
						+ "  <br>\r\n"
						+ "  <form action=\"bookinghistory\" method=\"post\">\r\n"
						+ "  <input type=\"submit\" name=\"bookHis\" value=\"View Booking History\">\r\n"
						+ "  </form>\r\n"
						+ "  <br>\r\n"
						+ "  <form action=\"assignmanager\" method=\"post\">\r\n"
						+ "  <input type=\"submit\" name=\"assignMan\" value=\"Assign Manager\">\r\n"
						+ "</form>\r\n"
						+ "</div>\r\n"
						+ "</body>\r\n"
						+ "</html>");
				break;
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
				rd.include(request, response);
				out.println("Wrong credentials!! Please try again!");
				}
			
		}
		
	}

}
