package com.fis.springsecurity.employee;

import org.springframework.data.repository.CrudRepository;

import com.fis.springsecurity.employee.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}

