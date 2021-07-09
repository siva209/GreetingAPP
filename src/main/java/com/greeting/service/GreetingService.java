package com.greeting.service;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greeting.model.Greeting;
import com.greeting.model.User;
import com.greeting.repository.GreetingRepository;

@Service
public class GreetingService implements IGreetingService {
	private static final String template = "Hello, %s";
	private final AtomicLong counter = new AtomicLong();
	@Autowired
	private GreetingRepository greetingRepository;

	@Override
	public Greeting addGreeting(User user) {
		String message = String.format(template, (user.toString().trim().isEmpty()) ? "World" : user.toString());
		System.out.println(message);
		return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
	}

	@Override
	public Greeting getGreetingById(long id) {
		return greetingRepository.findById(id).get();
	}

	@Override
	public List<Greeting> getAllGreetings() {
		return greetingRepository.findAll();
	}

	@Override
	public String deleteGreeting(long id) {
		greetingRepository.deleteById(id);
		return "Deleted Successfully";
	}

	@Override
	public Greeting updateGreeting(long id, String message) {
		Greeting greet = this.getGreetingById(id);
		greet.setMessage(message);
		greetingRepository.save(greet);
		return this.getGreetingById(id);
	}
}
