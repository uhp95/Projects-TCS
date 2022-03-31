package com.tcs.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableEurekaClient
@EnableAutoConfiguration
@ComponentScan({"com.tcs.*"})
@EnableJpaRepositories({"com.tcs.repository"})
@EntityScan({"com.tcs.entity"})
@EnableWebMvc
@SpringBootApplication
public class TcsCrsAdminProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TcsCrsAdminProducerApplication.class, args);
	}

}
