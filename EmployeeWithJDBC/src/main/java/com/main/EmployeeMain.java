package com.main;

import java.util.Scanner;
import com.model.Employee;
import com.service.EmployeeService;
import com.service.EmployeeServiceImpl;

public class EmployeeMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		EmployeeService employeeservice = new EmployeeServiceImpl();

		System.out.println("Enter 1 to Create ");
		System.out.println("Enter 2 to Search By Id ");
		System.out.println("Enter 3 to Search By Name ");
		System.out.println("Enter 4 to Update");
		System.out.println("Enter 5 to Delete");
		int value = scanner.nextInt();
		switch (value) {
		case 1:
			Employee employee1 = new Employee();
			System.out.println("Enter the Name : ");
			String empName = scanner.next();
			employee1.setEmpName(empName);
			System.out.println("Enter the Designation : ");
			String empDesignation = scanner.next();
			employee1.setDesignation(empDesignation);
			System.out.println("Enter The age : ");
			int empAge = scanner.nextInt();
			employee1.setAge(empAge);
			System.out.println("Enter The salary : ");
			Float empsalary = scanner.nextFloat();
			employee1.setSalary(empsalary);
			// EmployeeService employeeservice = new EmployeeServiceImpl();
			int result0 = employeeservice.createEmployee(employee1);

			if (result0 == 1) {
				System.out.println("Details added Successfully");
			}
			break;
		case 2:
			System.out.println("Enter Employee Id to Search : ");
			int userData = scanner.nextInt();

			Employee result = employeeservice.readEmployeeById(userData);

			if (result != null) {
				System.out.println("Employee Id is :" + result.getEmpId());
				System.out.println("Employee name is :" + result.getEmpName());
				System.out.println("Employee Designation :" + result.getDesignation());
				System.out.println("Employee Age is :" + result.getAge());
				System.out.println("Employee Salary is :" + result.getSalary());
			}
			break;
		case 3:
			System.out.println("Enter Employee Name to Search : ");
			String userName = scanner.next();
			Employee result1 = employeeservice.readEmployeeByName(userName);
			if (result1 != null) {
				System.out.println("Employee Id is :" + result1.getEmpId());
				System.out.println("Employee name is :" + result1.getEmpName());
				System.out.println("Employee Designation :" + result1.getDesignation());
				System.out.println("Employee Age is :" + result1.getAge());
				System.out.println("Employee Salary is :" + result1.getSalary());
			}
			break;
		case 4:
			Employee employee2 = new Employee();
			System.out.println("Enter Employee Id to Update Details : ");
			int id = scanner.nextInt();
			employee2.setEmpId(id);
			System.out.println("Enter the Name : ");
			String updateEmpName = scanner.next();
			employee2.setEmpName(updateEmpName);
			System.out.println("Enter the Designation : ");
			String updateEmpDesignation = scanner.next();
			employee2.setDesignation(updateEmpDesignation);
			System.out.println("Enter The age : ");
			int updateEmpAge = scanner.nextInt();
			employee2.setAge(updateEmpAge);
			System.out.println("Enter The salary : ");
			Float updateEmpsalary = scanner.nextFloat();
			employee2.setSalary(updateEmpsalary);
			int result2 = employeeservice.updateEmployee(employee2);
			if (result2 == 1) {
				System.out.println("Details updated Successfully");
			}
			break;

		case 5:
			System.out.println("Enter Employee Id to Delete : ");
			int deleteId = scanner.nextInt();
			int result3 = employeeservice.deleteEmployeeById(deleteId);
			if (result3 != 0) {
				System.out.println("Details deleted");
			}
			break;
		default:
			System.out.println("Enter between 1 to 5  ");
		}

	}

}
