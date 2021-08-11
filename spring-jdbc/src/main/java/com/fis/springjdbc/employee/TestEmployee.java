package com.fis.springjdbc.employee;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fis.springjdbc.employee.Employee;
import com.fis.springjdbc.employee.EmployeeDAOImpl;

public class TestEmployee {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("daoexample.xml");
		
		EmployeeDAOImpl bean = context.getBean("employeeDao", EmployeeDAOImpl.class);

		System.out.println("===============================");
		System.out.println("Insert the Employee Record");
		Employee newEmployee = new Employee();
		newEmployee.setId(30);
		newEmployee.setName("Richa");
		bean.insertEmployee(newEmployee);
		System.out.println("===============================");
		System.out.println("Delete Employee Record");
		int id = 10;
		bean.deleteEmployee(id);
		System.out.println("===============================");
		System.out.println("Get Employee Details Based on Id");
		id = 20;
		Employee employeeById = bean.getEmployeeByID(id);
		System.out.println(employeeById);
		System.out.println("===============================");
		System.out.println("Update Employee Record");
		newEmployee = new Employee();
		newEmployee.setName("Hanish");
		newEmployee.setId(30);
		bean.updateEmployee(newEmployee);
		System.out.println("===============================");
		System.out.println("Get All Employees Details");
		System.out.println(bean.getAllEmployees());
		System.out.println("===============================");

		context.close();
	}


}
