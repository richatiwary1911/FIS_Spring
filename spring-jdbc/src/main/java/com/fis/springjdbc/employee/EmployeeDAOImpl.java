package com.fis.springjdbc.employee;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.fis.springjdbc.product.Product;
import com.fis.springjdbc.product.ProductMapper;

public class EmployeeDAOImpl extends JdbcDaoSupport implements IEmployee{
	
	public void insertEmployee(Employee employee)
	{
		String sql = "insert into employee values(?,?)";
		Object[] args = {employee.getId(), employee.getName()};
		int insertedRows = getJdbcTemplate().update(sql, args);
		System.out.println("Rows Inserted: " + insertedRows);
	}
	
	public void deleteEmployee(int id)
	{
		String sql = "delete from employee where id = ?";
		Object[] args = {id};
		int deletedRows = getJdbcTemplate().update(sql, args);
		System.out.println("Rows Deleted: " + deletedRows);
	}
	
	public void updateEmployee(Employee employee)
	{
		String sql = "update employee set name = ? where id = ?";
		Object[] args = {employee.getName(), employee.getId()};
		int updatedRows = getJdbcTemplate().update(sql, args);
		System.out.println("Rows Updated: " + updatedRows);
	}
	
	public List<Employee> getAllEmployees()
	{
		String sql = "select * from employee";
		List<Employee> employees = getJdbcTemplate().query(sql, new EmployeeMapper());
		return employees;
	}
	
	public Employee getEmployeeByID(int id)
	{
		String sql = "select * from employee where id=?";
		Object[] args = { id };
		Employee employeeById = getJdbcTemplate().queryForObject(sql, args, new EmployeeMapper());
		return employeeById;
	}

}
