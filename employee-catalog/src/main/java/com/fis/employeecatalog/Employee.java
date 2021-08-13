package com.fis.employeecatalog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Employee {
	
	@Id
	@GeneratedValue
	
	private Long id;
	private String name;
	
	public Employee(String name)
	{
		this.name = name;
	}


}
