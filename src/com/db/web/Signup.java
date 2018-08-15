package com.db.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.MyConnection;
import com.db.dto.Employee;

/**
 * Servlet implementation class Signup to retrieve and store the data from the form to the database
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection connection = MyConnection.getConnection();
		PreparedStatement pStatement = null;
		String fullName ="";
		try {
			pStatement = connection.prepareStatement("insert into employee values(?,?,?,?,?)");
			fullName = request.getParameter("fName");
			String userName = request.getParameter("userName");
			double salary = Double.parseDouble( request.getParameter("salary"));
			String password = request.getParameter("password");
			Employee employee = new Employee(fullName,userName,password,salary);
			
			pStatement.setInt(1, employee.getEmpId());
			pStatement.setString(2, employee.getEmpName());
			pStatement.setDouble(3, employee.getSalary());
			pStatement.setString(4, employee.getUserName());
			pStatement.setString(5, employee.getPassword());
			
			pStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		RequestDispatcher rd = request.getRequestDispatcher("signup.html");
		rd.include(request, response);
		out.println("<h2 class='text-center'>"+ fullName+ " has been added to the database</h2>");
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}