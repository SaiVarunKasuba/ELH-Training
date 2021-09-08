package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public int createEmployee(Employee employee) {
		
	int rowCreated =0;

		Connection connection =DataBaseConnection.getConnection(); //Got Connection -- mysql=elh database
		String Sql = "insert into Employee(name,designation,age,salary) values(?,?,?,?)";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(Sql);
			preparedStatement.setString(1,employee.getEmpName());
			preparedStatement.setString(2, employee.getDesignation());
			preparedStatement.setInt(3, employee.getAge());
			preparedStatement.setFloat(4, employee.getSalary());
			int details=preparedStatement.executeUpdate();
			if(details==1)
			{
				rowCreated=details;
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		return rowCreated;
		
		
		
	}

	@Override
	public Employee readEmployeeById(int empId) {
		Employee employee = null;
		Connection connection =DataBaseConnection.getConnection(); //Got Connection -- mysql=elh database
		String Sql = "Select * from Employee where id =?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(Sql);
			preparedStatement.setInt(1, empId);
			ResultSet resultSet = preparedStatement.executeQuery();
			employee = new Employee();
			while(resultSet.next())
			{
				employee.setEmpId(resultSet.getInt("id"));
				employee.setEmpName(resultSet.getString("name"));
				employee.setDesignation(resultSet.getString("designation"));
				employee.setAge(resultSet.getInt("age"));
				employee.setSalary(resultSet.getFloat("salary"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employee;
	}

	@Override
	public Employee readEmployeeByName(String empName) {
		Employee employee = null;
		Connection connection =DataBaseConnection.getConnection(); //Got Connection -- mysql=elh database
		String Sql = "Select * from Employee where name =?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(Sql);
			preparedStatement.setString(1, empName);
			ResultSet resultSet = preparedStatement.executeQuery();
			employee = new Employee();
			while(resultSet.next())
			{
				employee.setEmpId(resultSet.getInt("id"));
				employee.setEmpName(resultSet.getString("name"));
				employee.setDesignation(resultSet.getString("designation"));
				employee.setAge(resultSet.getInt("age"));
				employee.setSalary(resultSet.getFloat("salary"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employee;
	}

	@Override
	public int updateEmployee(Employee employee) {
		int rowUpdated =0;
		Connection connection =DataBaseConnection.getConnection();
		String Sql = "update Employee set name=?,designation=?,age=?,salary=? where id=?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(Sql);
			preparedStatement.setString(1,employee.getEmpName());
			preparedStatement.setString(2, employee.getDesignation());
			preparedStatement.setInt(3, employee.getAge());
			preparedStatement.setFloat(4, employee.getSalary());
			preparedStatement.setInt(5, employee.getEmpId());
			int details=preparedStatement.executeUpdate();
			if(details==1)
			{
				rowUpdated=details;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}

	@Override
	public int deleteEmployeeById(int empId) {
	
		int rowDeleted =0;
		Connection connection =DataBaseConnection.getConnection(); //Got Connection -- mysql=elh database
		String Sql = "DELETE FROM Employee WHERE id= ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(Sql);
			preparedStatement.setInt(1, empId);
			int resultSet = preparedStatement.executeUpdate();

			if(resultSet==1)
			{
				rowDeleted=resultSet;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}

}
