package com.db.web;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.dao.EmployeeDAO;
import com.db.dto.Employee;


/**
 * Servlet implementation class HrPage
 */
@WebServlet("/DisplayPage")
public class DisplayData extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		EmployeeDAO employeeDAO = new EmployeeDAO();
		ArrayList<Employee> list = new ArrayList<>();
		employeeDAO.displayAll(list);
		RequestDispatcher rd = request.getRequestDispatcher("DisplayData.html");
		rd.include(request, response);
		for(Employee a:list)
		{ 
			out.println("<tr>");
			out.println("<td>" + a.getEmpId() + "</td>");
			out.println("<td>" + a.getEmpName() + "</td>");
			out.println("<td>" + a.getSalary() + "</td>");
			out.println("<td>" + a.getUserName()+ "</td>");
			out.println("<td>" + a.getPassword() + "</td>");
			out.println("</tr>");
			
		}	
		out.println("</tbody>");
		out.println("</table>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}