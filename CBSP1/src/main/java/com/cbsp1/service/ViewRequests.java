package com.cbsp1.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cbsp1.dao.EmployeeImpl;
import com.cbsp1.dao.EmployeeInt;
import com.cbsp1.dao.ManagerImpl;
import com.cbsp1.dao.ManagerInt;
import com.cbsp1.model.Requests;

/**
 * Servlet implementation class ViewRequests
 */
public class ViewRequests extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession sess = request.getSession(false);
		Integer EId = (Integer) sess.getAttribute("EId");
		
		EmployeeInt req = new EmployeeImpl();
		
		if(req.viewReq(EmployeeImpl.employees.get(0))) {
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
					+ "<th>Request Id</th>\r\n"
					+ "<th>Employee Id</th>\r\n"
					+ "<th>Requested On</th>\r\n"
					+ "<th>Status</th>\r\n"
					+ "</tr>\r\n");
					for(Requests r: EmployeeImpl.requests ) {
						out.println("<tr>\r\n");	
						out.println("<td>"+r.getReqId()+"</td>\\r\\n");
						out.println("<td>"+EId+"</td>\\r\\n");
						out.println("<td>"+r.getrDate()+"</td>\\r\\n");
						out.println("<td>"+r.getStatus()+"</td>\\r\\n");
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
