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

import com.db.dto.Employee;
import com.mysql.cj.Session;

/**
 * Servlet implementation class EmpPage to display the user who has log in
 */
@WebServlet("/EmpPage")
public class EmpPage extends HttpServlet {

	/**
	 * method to display the user info on the page
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("user");
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("base.html");
		
		rd.include(request, response);
		out.println("<h1 class='text-center jumbotron p-5'>Welcome "+ employee.getEmpName() +" to your home page </h1>");
		out.println("<a href='Detail' class='btn btn-lg btn-warning'>Profile</a>");
		out.println("</div>");
		//script to run the navigation bar
		out.println(employeeDAO.scriptString());
		out.println("</body>");
		out.println("</html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}