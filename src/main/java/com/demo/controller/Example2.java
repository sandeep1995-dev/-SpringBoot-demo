package com.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Example2 {

	@GetMapping("/welcome")
	public String sayHello() {
		return "welcome";
	}
	
	
}
