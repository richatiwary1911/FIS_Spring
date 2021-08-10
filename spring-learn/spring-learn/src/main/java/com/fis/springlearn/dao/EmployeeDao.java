package com.fis.springlearn.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fis.springlearn.controller.EmployeeController;

public class EmployeeDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	public EmployeeDao()
	{
		LOGGER.debug("Inside Employee DAO");
	}

}
