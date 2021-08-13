package com.fis.employeecatalog;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class EmployeeInitializer implements CommandLineRunner{
	
	private final EmployeeRepository employeeRepository;
	
	EmployeeInitializer(EmployeeRepository employeeRepository)
	{
		this.employeeRepository = employeeRepository;
	}
	
	@Override
    public void run(String... args) throws Exception {
        Stream.of("Richa", "Rajat", "Preethi", "Pavani", "Imran", "Shreya", "Arpita")
                .forEach(employee -> employeeRepository.save(new Employee(employee)));

        employeeRepository.findAll().forEach(System.out::println);
    }
	
}


