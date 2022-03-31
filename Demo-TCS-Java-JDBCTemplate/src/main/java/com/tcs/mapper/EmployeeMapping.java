/**
 * 
 */
package com.tcs.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tcs.model.Employee;

/**
 * @author springuser05
 *
 */
public class EmployeeMapping implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet r, int rows) throws SQLException
	{
		Employee employee = new Employee();
		employee.setName(r.getString("name"));
		employee.setAge(r.getInt("age"));
		return employee;
		
	}
	

}
