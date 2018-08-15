package com.db.dao;
import com.db.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.db.dto.Employee;

/**
 * 
 * @author prati
 *
 */
public class EmployeeDAO {

	/**
	 * Returns the information about the user after passing the username and password in the login form
	 * @param userName
	 * @param password
	 * @return
	 */
	public Employee getEmployee(String userName, String password) {
		
		Connection con=null;
		PreparedStatement ps = null;;
		ResultSet rs = null;
		
			con =MyConnection.getConnection();	
			try {
				ps = con.prepareStatement("select * from employee where username =? and password = ?");
				ps.setString(1, userName);
				ps.setString(2, password);
				//get the data from the database 
				rs = ps.executeQuery();
				//set the result from the query to java object
				Employee employee = new Employee();
				//list the detail about the employee
				if(rs.next()) {
				employee.setEmpId(rs.getInt(1));
				employee.setEmpName(rs.getString(2));
				employee.setUserName(rs.getString(4));
				employee.setPassword(rs.getString(5));
				employee.setSalary(rs.getDouble(3));
				
				return employee;
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return null;
		
	}
	
	/**
	 * Returns all the list of employee in the database
	 * @param list
	 * @return
	 */
	public ArrayList<Employee> displayAll(ArrayList<Employee> list){
		Connection connection = null;
		PreparedStatement ps = null;;
		ResultSet rs = null;
		
			connection = MyConnection.getConnection();	
			try {
				ps = connection.prepareStatement("select * from employee ");
				//get the data from the database 
				rs = ps.executeQuery();
				//set the result from the query to java object
			
				//list the detail about the employee
				int count =0;
				while(rs.next()) {
					
				Employee employee = new Employee();
				employee.setEmpId(rs.getInt(1));
				employee.setEmpName(rs.getString(2));
				employee.setUserName(rs.getString(4));
				employee.setPassword(rs.getString(5));
				employee.setSalary(rs.getDouble(3));
				System.out.println(count++);
				list.add(employee);
				}
				return list;
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return null;

	}
	/**
	 * Bootstrap script for the  navigation bar 
	 * @return
	 */
	public String scriptString() {
		
		return " <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\r\n" + 
				"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\"></script>\r\n" + 
				"<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>";
	}
}
