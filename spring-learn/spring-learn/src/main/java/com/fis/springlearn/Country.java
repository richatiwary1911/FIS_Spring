 package com.fis.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Country
{
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	String name;
	String code;
	
	public Country()
	{
		LOGGER.debug("Inside country constructor");
	}

	@Override
	public String toString() {
		return "country [name=" + name + ", code=" + code + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	
}