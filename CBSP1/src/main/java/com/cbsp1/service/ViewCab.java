package com.cbsp1.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cbsp1.dao.AdminImpl;
import com.cbsp1.dao.AdminInt;
import com.cbsp1.dao.EmployeeImpl;
import com.cbsp1.dao.EmployeeInt;
import com.cbsp1.model.Cab;
import com.cbsp1.model.Requests;

/**
 * Servlet implementation class ViewCab
 */
public class ViewCab extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession sess = request.getSession(false);
		
		Timestamp availtime =new Timestamp(System.currentTimeMillis());
		
		EmployeeInt cab = new EmployeeImpl();
		Integer EId = (Integer) sess.getAttribute("EId");
		AdminInt admincab = new AdminImpl();
		
			if(cab.viewCabs()) {
				out.println("Here is the list of cabs available!");
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
					+ "<th>Cab Id</th>\r\n"
					+ "<th>Cab No</th>\r\n"
					+ "<th>Driver Name</th>\r\n"
					+ "<th>Driver Contact</th>\r\n"
					+ "<th>Available for</th>\r\n"
					+ "</tr>\r\n");
					for(Cab c: EmployeeImpl.cablist ) {
						out.println("<tr>\r\n");	
						out.println("<td>"+c.getCabId()+"</td>\\r\\n");
						out.println("<td>"+c.getCabNo()+"</td>\\r\\n");
						out.println("<td>"+c.getdName()+"</td>\\r\\n");
						out.println("<td>"+c.getdMobile()+"</td>\\r\\n");
						out.println("<td>"+c.getAvailableTime()+" hours</td>\\r\\n");
						out.println("</tr>\r\n");
					}
					out.println("</table>\r\n"
							+ "</div>\r\n"
							+ "</body>\r\n"
							+ "</html>"); 
					}
			
			else {
				if(admincab.viewCabs()) {
					out.println("Here is the list of cabs available!");
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
							+ "<th>Cab Id</th>\r\n"
							+ "<th>Cab No</th>\r\n"
							+ "<th>Driver Name</th>\r\n"
							+ "<th>Driver Contact</th>\r\n"
							+ "<th>Available for</th>\r\n"
							+ "</tr>\r\n");
							for(Cab c: AdminImpl.cablist ) {
								out.println("<tr>\r\n");	
								out.println("<td>"+c.getCabId()+"</td>\\r\\n");
								out.println("<td>"+c.getCabNo()+"</td>\\r\\n");
								out.println("<td>"+c.getdName()+"</td>\\r\\n");
								out.println("<td>"+c.getdMobile()+"</td>\\r\\n");
								out.println("<td>"+c.getAvailableTime()+" hours</td>\\r\\n");
								out.println("</tr>\r\n");
							}
							out.println("</table>\r\n"
									+ "</div>\r\n"
									+ "</body>\r\n"
									+ "</html>"); 
				}
			}
	}
}


