package com.db.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.dto.Employee;

/**
 * Servlet implementation class HrPage
 */
@WebServlet("/EmpPage")
public class EmpPage extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Employee employee = (Employee) request.getAttribute("user");
		RequestDispatcher rd = request.getRequestDispatcher("base.html");
		rd.include(request, response);
		out.println("<h1 class='text-center jumbotron p-5'>Welcome "+ employee.getEmpName() +" to your home page </h1>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}