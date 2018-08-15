package com.db;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
public class MyConnection {
	/**
	 * Connection to the database
	 * @return database connection
	 */
	public static Connection getConnection() {
		// write your code here
	        Connection con = null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp","root","password");
	            
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
			return con;

	}
}
