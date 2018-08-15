package com.db.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.dao.EmployeeDAO;
import com.db.dto.Employee;

/**
 * Class implementing and validating the login from the database and starting the session upon successful user info
 * @author prati
 *
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		EmployeeDAO eDao = new EmployeeDAO();
		
		Employee employee = eDao.getEmployee(userName, password);
		
	
		if(userName.equals("hr") && password.equals("hr")) {
			// calling another servlet
			RequestDispatcher rd = request.getRequestDispatcher("HrPage");
			rd.forward(request, response);
		
		}
		else if(employee != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", employee);
			RequestDispatcher rd = request.getRequestDispatcher("EmpPage");
			rd.forward(request, response);
		
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("base.html");
			rd.include(request, response);
			out.println("<div class=\"alert alert-warning\" role=\"alert\" align=\"center\">\r\n" + 
					"  Invalid Entry" + 
					"</div>");
			rd = request.getRequestDispatcher("Login.html");
			rd.include(request, response);
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
