package com.ems.serviceImpl;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.ems.model.Employee;
import com.ems.service.EmployeeService;

/**
 * @author vinod.nagulkar
 *
 */
public class EmployeeServiceImpl implements EmployeeService {
	Scanner sc = new Scanner(System.in);

	private List<Employee> list = new ArrayList<Employee>();
	
	
	public void dataProvider() 
	{
	
	Employee e1 = new Employee(01, "Vinod", "vinodnagulkar@gmail.com", "9922652131", 60000,
			LocalDate.of(2019, Month.JANUARY, 10), "Admin");
	Employee e2 = new Employee(02, "Vinit", "Vinit@gmail.com", "985858522", 60000,
			LocalDate.of(2019, Month.OCTOBER, 10), "consumer");
	Employee e3 = new Employee(03, "vaibhav", "vaibhav@gmail.com", "7458558585", 45000,
			LocalDate.of(2019, Month.JANUARY, 20), "consumer");
	Employee e4 = new Employee(04, "kunal", "kunal@gmail.com", "7894561236", 35000,
			LocalDate.of(2019, Month.OCTOBER, 20), "consumer");
	Employee e5 = new Employee(05, "Tushar", "tushar@gmail.com", "66666666666", 85000,
			LocalDate.of(2019, Month.JANUARY, 17), "consumer");
	
	list.add(e1);
	list.add(e2);
	list.add(e3);
	list.add(e4);
	list.add(e5);
	}
	
	
	
	//********************** Using Consumer**********************//
	@Override
	public List<Employee> getAllEmployees() {
		Consumer<List<Employee>> consumer = (list) -> list.forEach(System.out::println);
		consumer.accept(list);
		return list;
	}

	 //**********************stream API**********************//
	@Override
	public boolean getEmployeeById(int id) throws ParseException {

		try {
			list.stream().filter((e) -> e.getId() == id).forEach(System.out::println);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean getEmployeeByName(String name) throws ParseException {

		try {
			list.stream().filter((e) -> e.getName().equalsIgnoreCase(name)).forEach(System.out::println);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	//********************** Using Predicate Interface**********************//
	@Override
	public boolean getEmployeeBySalary(double salary, int option) throws ParseException {
		switch (option) {
		case 1:
			Predicate<Employee> predicate = (p) -> p.getSalary() > salary;
			List<Employee> empList = list.stream().filter(predicate).collect(Collectors.toList());
			if (!empList.isEmpty()) {
				System.out.println(empList);
				return true;
			} else {
				System.out.println("No Employee Found With Given Criteria..!");
			}
			break;
		case 2:
			Predicate<Employee> predicate2 = (p) -> p.getSalary() < salary;
			List<Employee> empList2 = list.stream().filter(predicate2).collect(Collectors.toList());
			if (!empList2.isEmpty()) {
				System.out.println(empList2);
				return true;
			} else {
				System.out.println("No Employee Found With Given Criteria..!");
			}
			break;

		default:
			break;
		}

		return false;

	}

//**********************Using Function Interface*************************************//
	@Override
	public List<String> getNewJoinersByUsingFunction() {
		Function<List<Employee>, List<String>> f = (li) -> list.stream()
				.filter((employee) -> ChronoUnit.DAYS.between(LocalDate.of(employee.getJoiningDate().getYear(),
						employee.getJoiningDate().getMonth(), employee.getJoiningDate().getDayOfMonth()),
						LocalDate.now()) < 30)
				.map((e) -> " \n" + e.getName() + " Join on ::" + e.getJoiningDate()).collect(Collectors.toList());

		return f.apply(list);
	}

	//********************** Using Function Interface**********************//
	public boolean getEmployeeByRole(String role) {

		try {

			Function<List<Employee>, List<String>> f = (list) -> list.stream()
					.filter((e) -> e.getRole().equalsIgnoreCase(role)).map((e) -> e.getName())
					.collect(Collectors.toList());
			System.out.println(f.apply(list));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	//**********************JAVA 8 DATE API**********************//
	@Override
	public List<Employee> getNewJoinersd() throws ParseException {
		List<Employee> list = new ArrayList<Employee>();
		for (Employee employee : list) {
			long noOfDays = ChronoUnit.DAYS.between(LocalDate.of(employee.getJoiningDate().getYear(),
					employee.getJoiningDate().getMonth(), employee.getJoiningDate().getDayOfMonth()), LocalDate.now());
			if (noOfDays < 30) {
				System.out.println("Number of Days of " + employee.getName() + " in Yash are " + noOfDays);
				list.add(employee);
			}
		}
		return list;
	}

	@Override
	public boolean deleteEmployee(int id) {
		Iterator<Employee> itr = list.listIterator();
		while (itr.hasNext()) {
			Employee emp = (Employee) itr.next();
			if (emp.getId() == id) {
				itr.remove();
				System.out.println("Employee with Id  " + emp.getId() + " deleted Successfully...!");
			}
			return true;
		}
		return false;
	}

	@SuppressWarnings("resource")
	@Override
	public boolean updateEmployee(int id) {
		for (Employee employee : list) {
			if (employee.getId() == id) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter Employee Name");
				String empName = sc.next();
				System.out.println("Enter Employee Email");
				String mail = sc.next();
				System.out.println("Enter Employee mobile number");
				String mobile = sc.next();
				System.out.println("Enter Employee salary");
				double salary = sc.nextDouble();
				System.out.println("Enter Employee role");
				String emprole = sc.next();

				employee.setName(empName);
				employee.setEmail(mail);
				employee.setMobile(mobile);
				employee.setSalary(salary);
				employee.setRole(emprole);
				System.out.println("Employee with Id  " + employee.getId() + " updated Successfully...!");
				
				return true;
			} else
				System.out.println("No Employee found with this id..!");

		}
		return false;
	}

	@Override
	public boolean addEmployee() {
		
		System.out.println("Enter Employee id");
		int empid=sc.nextInt();
		System.out.println("Enter Employee Name");
		String empName=sc.next();
		System.out.println("Enter Employee Email");
		String mail=sc.next();
		System.out.println("Enter Employee mobile number");
		String mobile=sc.next();
		System.out.println("Enter Employee salary");
		double salary=sc.nextDouble();
		System.out.println("Enter Employee role");
		String emprole=sc.next();
		Employee emp=new Employee();
		emp.setId(empid);
		emp.setName(empName);
		emp.setEmail(mail);
		emp.setMobile(mobile);
		emp.setSalary(salary);
		emp.setJoiningDate(LocalDate.now());
		emp.setRole(emprole);
		try {
			list.add(emp);
			System.out.println("Employee " + emp.getName() + " added Successfully...!");
			return true;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

}
