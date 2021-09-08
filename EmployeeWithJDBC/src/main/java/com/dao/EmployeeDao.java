package com.dao;

import com.model.Employee;

public interface EmployeeDao {
	public abstract int createEmployee(Employee employee);
	public abstract Employee readEmployeeById(int empId);
	public abstract Employee readEmployeeByName(String empName);
	public abstract int updateEmployee(Employee employee);
	public abstract int deleteEmployeeById(int empId);
}
