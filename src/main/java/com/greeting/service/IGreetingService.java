package com.greeting.service;

import java.util.List;

import com.greeting.model.Greeting;
import com.greeting.model.User;

public interface IGreetingService {
	Greeting addGreeting(User user);
	Greeting getGreetingById(long id);
	List<Greeting> getAllGreetings();
	String deleteGreeting(long id);
	Greeting updateGreeting(long id, String message);
}

