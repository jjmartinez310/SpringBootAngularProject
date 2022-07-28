package com.groupproject.telecomproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

import com.groupproject.telecomproject.dao.UsersRepository;

@RestController
@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UsersRepository.class)
public class TelecomprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelecomprojectApplication.class, args);
	}

}
