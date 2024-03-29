package com.luv2code.springdemo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	@GetMapping("/")
	public String sayHello() {
		return "Current server time is : " + LocalDateTime.now();
	}
	
	@GetMapping("/daily-workout")
	public String getWorkout() {
		return "run";
	}
	
	@GetMapping("/teamInfo")
	public String teamInfo() {
		return coachName + " " + teamName;
	}
}
