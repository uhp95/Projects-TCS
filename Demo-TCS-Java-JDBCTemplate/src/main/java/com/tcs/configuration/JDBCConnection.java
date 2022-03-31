/**
 * 
 */
package com.tcs.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;



/*
 * import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
 */

/**
 * @author springuser05
 *
 */

@Configuration
@PropertySource("classpath:application.properties")
public class JDBCConnection {
	
	@Autowired
	Environment environment;
	
	@Bean
	DataSource dataSources()
	{
		DriverManagerDataSource dataSources = new DriverManagerDataSource();
		dataSources.setUrl(environment.getProperty("spring.datasource.url"));
		dataSources.setUsername(environment.getProperty("spring.datasource.username"));
		dataSources.setPassword(environment.getProperty("spring.datasource.password"));
		dataSources.setDriverClassName(environment.getProperty("spring.datasource.driverClassName"));
		
		return  dataSources;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate()
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource( dataSources());
		return jdbcTemplate;
	}

}
