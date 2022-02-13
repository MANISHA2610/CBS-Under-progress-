package com.cbsp1.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cbsp1.dao.ManagerImpl;
import com.cbsp1.dao.ManagerInt;
import com.cbsp1.model.Requests;

/**
 * Servlet implementation class RejectRequest
 */
public class RejectRequest extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession sess = request.getSession(false);
		Integer EId = (Integer) sess.getAttribute("EId");
		
		ManagerInt req = new ManagerImpl();
		String emp_Id = (String)sess.getAttribute("emp_Id");
		
		if(req.rejectRequest(emp_Id)) {
			if(req.checkRequest()) {
				
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
						+ "<th>Accept</th>\r\n"
						+ "<th>Reject</th>\r\n"
						+ "</tr>\r\n");
						for(Requests r: ManagerImpl.requests ) {
							out.println("<tr>\r\n");	
							out.println("<td>"+r.getReqId()+"</td>\\r\\n");
							out.println("<td name='emp_Id'>"+r.getEmp().getEId()+"</td>\\r\\n");
							out.println("<td>"+r.getrDate()+"</td>\\r\\n");
							out.println("<td>\r\n"
									+ " <form action=\"acceptrequest\" method=\"post\">\r\n"
									+ "  <input type=\"submit\" name=\"acceptreq\" value=\"Accept\">\r\n"
									+ "  </form>\r\n"
									+ "  </td>\r\n"
									+ "  <td>\r\n"
									+ "  <br>\r\n"
									+ "   <form action=\"rejectrequest\" method=\"post\">\r\n"
									+ "  <input type=\"submit\" name=\"rejectreq\" value=\"Reject\">\r\n"
									+ "  </form>\r\n"
									+ "</td>");
						}
						out.println("</table>\r\n"
								+ "</div>\r\n"
								+ "</body>\r\n"
								+ "</html>"); 
			}
		}
	}

}
