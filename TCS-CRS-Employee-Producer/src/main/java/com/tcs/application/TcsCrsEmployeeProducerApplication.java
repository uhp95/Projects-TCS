package com.tcs.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableAutoConfiguration
@ComponentScan({"tcs.com.*"})
@EnableWebMvc
@EnableEurekaClient
@SpringBootApplication
public class TcsCrsEmployeeProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TcsCrsEmployeeProducerApplication.class, args);
	}

}
