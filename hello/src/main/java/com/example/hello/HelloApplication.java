package com.example.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}
	
	@RequestMapping("/")
	
	public String hello() {
		return "Lets do this";
	}
	
	@RequestMapping("/random")
	
	public String random() {
		return "random";
	}
}
