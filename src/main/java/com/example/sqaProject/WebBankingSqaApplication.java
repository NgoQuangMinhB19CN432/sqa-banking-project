package com.example.sqaProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class WebBankingSqaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebBankingSqaApplication.class, args);
	}

}
