package com.university.of.hull.eportal.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.university.of.hull.eportal")
@SpringBootApplication
@EnableJpaRepositories("com.university.of.hull.eportal.*")
@EntityScan("com.university.of.hull.eportal.*")  
public class EPortalApplication {


	public static void main(String[] args) {
		SpringApplication.run(EPortalApplication.class, args);
		
	}
}