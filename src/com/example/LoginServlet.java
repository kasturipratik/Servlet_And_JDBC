package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		out.print("<html>");
		if(userName.equals("hr") && password.equals("hr")) {
			/*RequestDispatcher rd = request.getRequestDispatcher("HrPage");
			rd.forward(request, response);*/
			out.println("<body bgcolor=yellow text=red>");
			out.println("<h1>Welcome to hr home page </h1>");
			out.println("</body>");
		
		}
		else {
			out.println("<body bgcolor=yellow text=red>");
			out.println("<h1>Invalid Credentials </h1>");
			out.println("</body>");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
