package com.cbsp1.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cbsp1.dao.ManagerImpl;
import com.cbsp1.dao.ManagerInt;
import com.cbsp1.model.Requests;

/**
 * Servlet implementation class AcceptRequest
 */
public class AcceptRequest extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession sess = request.getSession(false);
		Integer EId =(Integer)sess.getAttribute("EId");
		
		ManagerInt req = new ManagerImpl();
		List<Integer> reqList = (List<Integer>)sess.getAttribute("reqList");
		
		for(int i=0; i<reqList.size();i++) {
			if(req.acceptRequest(reqList.get(i))) {
				out.println("Succesfully approved " + reqList.get(i));
		}
		/*
		 * RequestDispatcher rd=request.getRequestDispatcher("CheckRequests");
		 * rd.include(request, response);
		 */
		}
	}

}
