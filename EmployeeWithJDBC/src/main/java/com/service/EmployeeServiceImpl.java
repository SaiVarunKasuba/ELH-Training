package com.service;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public int createEmployee(Employee employee) {
		
		
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		int details = employeeDao.createEmployee(employee);
		return details;
	}

	@Override
	public Employee readEmployeeById(int empId) {
		
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		Employee details = employeeDao.readEmployeeById(empId);
		return details;
	}

	@Override
	public Employee readEmployeeByName(String empName) {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		Employee details = employeeDao.readEmployeeByName(empName);
		return details;
	}

	@Override
	public int updateEmployee(Employee employee) {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		int details = employeeDao.updateEmployee(employee);
		return details;
	}

	@Override
	public int deleteEmployeeById(int empId) {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		int details = employeeDao.deleteEmployeeById(empId);
		return details;
	}

}
