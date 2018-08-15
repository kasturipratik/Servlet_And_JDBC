package com.db.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.dao.EmployeeDAO;

/**
 * Servlet implementation class HrPage
 */
@WebServlet("/HrPage")
public class HrPage extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("base.html");
		EmployeeDAO employeeDAO = new EmployeeDAO();
		rd.include(request, response);
		out.println("<div class='jumbotron' align='center'>");
		out.println("<h1 class='p-3'>Welcome to hr home page </h1>");
		out.println("<a href='DisplayPage' class='btn btn-lg btn-success'>Display All the employee</a>");
		out.println("</div>");
		out.println(employeeDAO.scriptString());
		out.println("</body>");
		out.println("</html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
