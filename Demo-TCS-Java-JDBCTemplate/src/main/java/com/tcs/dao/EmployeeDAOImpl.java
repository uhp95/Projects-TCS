/**
 * 
 */
package com.tcs.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/*
 * import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.mapper.EmployeeMapper;
import com.tcs.model.Employee;

 * 
 */
/**
 * @author springuser05
 *
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	@Transactional
	public String createEmployee(String name, Integer age)
	{
		String Sql = "insert into Employee(name,age) values (?,?)";
		jdbcTemplate.update(Sql, name,age);
		logger.debug("in debug");
		return "Employee Created Successfully";
	}

}
