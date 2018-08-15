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

import com.db.dao.EmployeeDAO;
import com.db.dto.Employee;


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
		
		out.print("<html>");
		if(userName.equals("hr") && password.equals("hr")) {
			// calling another servlet
			RequestDispatcher rd = request.getRequestDispatcher("HrPage");
			rd.forward(request, response);
		
		}
		else if(employee != null) {
			request.setAttribute("user", employee);
			RequestDispatcher rd = request.getRequestDispatcher("EmpPage");
			rd.forward(request, response);
		
		}
		else {
			out.println("<body bgcolor=yellow text=red>");
			out.println("<h2 class='text-center'>Invalid Credentials </h2>");
			RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			rd.include(request, response);
			out.println("</body>");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
