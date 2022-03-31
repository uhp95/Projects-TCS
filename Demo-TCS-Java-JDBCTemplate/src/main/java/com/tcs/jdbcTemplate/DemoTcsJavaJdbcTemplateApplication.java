package com.tcs.jdbcTemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.tcs.dao.EmployeeDAOImpl;

@EnableAutoConfiguration
@ComponentScan({"com.tcs.*"})
@SpringBootApplication
public class DemoTcsJavaJdbcTemplateApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoTcsJavaJdbcTemplateApplication.class, args);
		
		ApplicationContext context = SpringApplication.run(DemoTcsJavaJdbcTemplateApplication.class, args);
		EmployeeDAOImpl obj = context.getBean(EmployeeDAOImpl.class);
		obj.createEmployee("RRR", 2);
	}

}
