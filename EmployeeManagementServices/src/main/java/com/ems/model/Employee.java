package com.ems.model;

import java.time.LocalDate;

/**
 * @author vinod.nagulkar
 *
 */
public class Employee  {
	private int id;
	private String name;
	private String email;
	private String mobile;
	private double salary;
	
	private LocalDate joiningDate;
	private String role;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public LocalDate getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "\nEmployee [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", salary="
				+ salary + ", joiningDate=" + joiningDate + ", role=" + role + "]";
	}
	public Employee(int id, String name, String email, String mobile, double salary, LocalDate joiningDate, String role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.salary = salary;
		this.joiningDate = joiningDate;
		this.role = role;
		
	}
	
	
	

}
