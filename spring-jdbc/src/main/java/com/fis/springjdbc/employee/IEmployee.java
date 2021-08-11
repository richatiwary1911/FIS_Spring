package com.fis.springjdbc.employee;

import java.util.List;

public interface IEmployee {
	
	public void insertEmployee(Employee employee);
	
	public void deleteEmployee(int id);
	
	public void updateEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeByID(int id);

}
