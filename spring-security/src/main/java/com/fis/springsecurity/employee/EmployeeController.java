package com.fis.springsecurity.employee;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController  //@Controller + @ResponseBody

//@Controller
@RequestMapping(path = "/emp")

public class EmployeeController {
	 @Autowired // This means to get the bean called userRepository
     // Which is auto-generated by Spring, we will use it to handle the data
private EmployeeRepository employeeRepository;

		@PostMapping(path="/add") // Map ONLY POST Requests
//		public @ResponseBody String addNewEmployee (@RequestParam String name, @RequestParam String email) {
		public String addNewEmployee (@RequestBody Employee employee) {
			// @ResponseBody means the returned String is the response, not a view name
			// @RequestParam means it is a parameter from the GET or POST request
//		
//			Employee e = new Employee();
//			e.setName(name);
//			e.setEmail(email);
			employeeRepository.save(employee);
			return "Saved";
		}
		
		@GetMapping(path="/all")
//		  public @ResponseBody Iterable<Employee> getAllEmployees() {
		    // This returns a JSON or XML with the users
		
		public Iterable<Employee> getAllEmployees() {
		    return employeeRepository.findAll();
		  }
		
		@PutMapping(path="/edit")
		public String updateEmployee(@RequestBody Employee employee)
		{
			Optional<Employee> e = employeeRepository.findById(employee.getId());
			
			if(e.isPresent()) {
				employeeRepository.save(employee);
				return "updated";
			}
			else
			{
				return "Record not found";
			}
			
		}
		
		@DeleteMapping(path="/del")
		public String deleteEmployee(@RequestBody Employee employee)
		{
			Optional<Employee> e = employeeRepository.findById(employee.getId());
			
			if(e.isPresent()) {
				employeeRepository.delete(e.get());
				return "deleted";
			}
			else
			{
				return "Record not found";
			}
		}
		
		@GetMapping("/{id}")            //localhost:8081/emp/4
		public Object getSingleEmployeeDetails(@PathVariable int id)
		{
			Optional<Employee> e = employeeRepository.findById(id);
			
			if(e.isPresent()) {
				return e.get();
				
			}
			else
			{
				return "Record not found";
			}
			
		}
			
		
}
