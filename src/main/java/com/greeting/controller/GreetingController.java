package com.greeting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greeting.model.Greeting;
import com.greeting.model.User;
import com.greeting.service.IGreetingService;

@RestController
@RequestMapping("/greetings")
public class GreetingController {
	@Autowired
	private IGreetingService greetingService;
	@GetMapping(value="/")
	public Greeting greeting(@RequestParam(value = "fname", defaultValue = "")String firstName,
			                 @RequestParam(value = "lname", defaultValue = "")String lastName) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		return greetingService.addGreeting(user);
	}
	@GetMapping("/{id}")
	public String getGreeting(@PathVariable long id) {
		return greetingService.getGreetingById(id).getMessage();	
	}
	@GetMapping("/getAll")
	public List<Greeting> getAllGreeting() {
		return greetingService.getAllGreetings();
	}
	@DeleteMapping("/delete/{id}")
	public String deleteGreeting(@PathVariable long id) {
		return greetingService.deleteGreeting(id);
	}
	@PutMapping("/put")
	public Greeting updateGreeting(@RequestParam(value = "id") long id,
			@RequestParam(value = "message", defaultValue = "")String message) {
		return greetingService.updateGreeting(id, message);		
	}	
}


