package com.ems.service;

import java.text.ParseException;
import java.util.List;

import com.ems.model.Employee;

/**
 * @author vinod.nagulkar
 *
 */
public interface EmployeeService {
	
	
	public  List<Employee> getAllEmployees();

	public boolean getEmployeeById(int id) throws ParseException;

	public boolean getEmployeeByName(String name) throws ParseException;

	public boolean getEmployeeBySalary(double salary,int option) throws ParseException;

	public boolean getEmployeeByRole(String role);
	
	public List<String> getNewJoinersByUsingFunction() throws ParseException;

	public List<Employee> getNewJoinersd() throws ParseException;
	
	public boolean deleteEmployee(int id);
	
	public boolean updateEmployee(int id);

	public boolean addEmployee();

}
