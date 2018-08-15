package com.db.dto;

/**
 * Employee object for the database
 * @author prati
 *
 */
public class Employee {
	
 private int empId;
 private String empName;
 private String userName;
 private String password;
 private double salary;
 static int count = 106;
 
 
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
public Employee( String empName, String userName, String password, double salary) {
	super();
	this.empId = count++;
	this.empName = empName;
	this.userName = userName;
	this.password = password;
	this.salary = salary;
}
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
@Override
public String toString() {
	return "Employee [empId=" + empId + ", empName=" + empName + ", userName=" + userName + ", password=" + password
			+ ", salary=" + salary + "]";
}
 
 
}
