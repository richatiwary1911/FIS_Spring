  
package com.fis.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fis.springlearn.bean.Employee;
import com.fis.springlearn.controller.EmployeeController;

import java.util.ArrayList;

@SpringBootApplication
public class SpringLearnApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		//SpringApplication.run(SpringLearnApplication.class, args);
		//displayDate();
		//displayCountry();
		//displayCountries();
		//displayEmployee();
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(EmployeeController.class);
		displayEmployeeControllerAnnotation(applicationContext);
	}
	
	public static void displayEmployeeControllerAnnotation(ApplicationContext applicationContext)
	{
		LOGGER.info("START");
		EmployeeController employeeController = applicationContext.getBean("employeeController", EmployeeController.class);
		LOGGER.debug("EmployeeController : {}", employeeController);
		LOGGER.info("END");

	}
	
	static void displayEmployee()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		Employee employee = context.getBean("employee", Employee.class);
		LOGGER.debug("Employee : {}", employee.toString());
	}
	
	static void displayCountry()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = context.getBean("country", Country.class);
		Country anotherCountry = context.getBean("country", Country.class);
		LOGGER.debug("Country : {}", country.toString());

	}
	
	static void displayCountries()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> countries = context.getBean("countryList", ArrayList.class);
		LOGGER.info("START");
		for(Country c : countries)
			LOGGER.debug(c.toString());
		LOGGER.info("END");
	}
	
	static void displayDate()  {
		 LOGGER.info("START");
		 ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		 SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		  try {
			Date parseDate = format.parse("31/12/2018");
//			System.out.println(parseDate);
			LOGGER.debug(parseDate + "");

		} catch (ParseException e) {
			e.printStackTrace();
		}
		  LOGGER.info("END");
	}


}