package com.ss.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
public class LmsApplication {

	public static void main(String[] args) {
		System.out.println("Hello there");
		SpringApplication.run(LmsApplication.class, args);
	}
}
