package com.ems.main;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;

import com.ems.model.Employee;
import com.ems.serviceImpl.EmployeeServiceImpl;

/**
 * @author vinod.nagulkar
 *
 */
public class EmployeeMain {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws ParseException {
	

		EmployeeServiceImpl service = new EmployeeServiceImpl();
		service.dataProvider();

		while (true) {
			System.out.println("\n============================================================Employee Management System==============================================================================");
			System.err.println("\n\n 1. Search Employee by Id\t2. Get All Employees\t3. Search Employee by Name\t4. Search Employee By Salary\t5. Get new joiners\n\n\n 6. Search Employee by Role\t7. Add Employee \t8. Update Employee\t\t 9. Delete Employee\t\t10. Exit");
			System.out.print("\nEnter Your choice:" );
			System.out.println("\n==========================================================================================================================================================================");
			
			int i = sc.nextInt();
			switch (i) {
			case 1:
				System.out.println("Enter Employee Id:");
				int id = sc.nextInt();
		        service.getEmployeeById(id);

				break;
			case 2:
				
				service.getAllEmployees();

				break;
			case 3:
				System.out.println("Enter Employee Name:");
				String name = sc.next();
				service.getEmployeeByName(name);

				break;
			case 4:
				System.out.println("Please Choose Options");
				System.out.println(" 1.Salary Greater Than:\t2.Salary Less Than: ");
				int j = sc.nextInt();
					System.out.println("Enter Salary:");
					double s = sc.nextDouble();
					service.getEmployeeBySalary(s,j);
			case 5:
				service.getNewJoinersByUsingFunction().forEach(System.out::println);;
				
				break;
			case 6:

				System.out.println("Enter Role");
				String role=sc.next();
				service.getEmployeeByRole(role);
				break;
				
			case 7:
				service.addEmployee();
				
				break;
				
			case 8:
				System.out.println("Enter Employee id to update");
				int id1=sc.nextInt();
				service.updateEmployee(id1);
				break;
				
			case 9:
				System.out.println("Enter Employee id to delete");
				int id2=sc.nextInt();
				service.deleteEmployee(id2);
				break;
			default:
				break;
			}
		}

	}
	
}
