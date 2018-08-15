<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.db.dto.Employee"%>
    
    <!-- attach other html file using jsp -->
<%@
	include  file="base.html" 
%>
<!--  getting the set attribute from Detail -->
 <%
	 Employee employee = (Employee)session.getAttribute("details");
 %>
 <div class="container">
 
 <div class="row bg-light ">
 	<div class="col-sm-0 col-md-3"></div>
 		<div class="col-sm-12 col-md-6 jumbotron jumbotron-fluid p-5 mt-4">
 			<h3 class="text-center">Employee Detail</h3>
 			<div>
 			  <span>Employee ID: </span><span>
 			  <%= employee.getEmpId() %>
 			  </span>
 			</div>
 			<div>
 			  <span>Name: </span><span>
 			  <%= employee.getEmpName() %>
 			  </span>
 			</div>
 			<div>
 			  <span>Salary: </span>
 			  <span>
 			  		<%= employee.getSalary() %>
 			  	</span>
 			</div>
 			
 			<div>
 			  <span>User Name: </span><span><%= employee.getUserName() %></span>
 			</div>
 			
 			<div>
 			  <span>Password: </span><span><%= employee.getPassword() %></span>
 			</div>
 			
 			
 			
 		</div>
 			<div class="col-sm-0 col-md-3"></div>
 </div>
 </div>
 
 </div>

</body>
</html>