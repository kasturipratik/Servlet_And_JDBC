package com.db.dao;
import com.db.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.dto.Employee;

public class EmployeeDAO {

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
			

		return null;
		
	}
}
