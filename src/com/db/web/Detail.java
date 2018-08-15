package com.db.web;


import com.db.dao.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;

import com.db.dto.Employee;

/**
 * Servlet implementation class HrPage
 */
@WebServlet("/Detail")
public class Detail extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("user");

		session.setAttribute("details", employee);
		
		RequestDispatcher rd = request.getRequestDispatcher("detail.jsp");
		
		
		System.out.println("The value is not entered");
		System.out.println(employee.getEmpName());
		
		
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}