package com.db.dao;
import com.db.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.db.dto.Employee;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

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
}
