package com.example.GreetingApp.service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.GreetingApp.dto.GreetingAppdto;
import com.example.GreetingApp.model.GreetingApp;


@Service
public class GreetingService implements IGreetingService{

	private final AtomicLong counter = new AtomicLong();
	@Override
	public String getGreeting(GreetingAppdto greetingAppDto) {
		String message = "Hello World";
		GreetingApp greeting = new GreetingApp(counter.incrementAndGet(),message);
		return greeting.getMessage();

	}
	@Override
    public GreetingApp greetingWithUser(String firstName) {
        return new GreetingApp(counter.incrementAndGet(),"Greetings"+ firstName);
    }

    @Override
    public GreetingApp greetingWithUser(String firstName, String lastName) {
    	return new GreetingApp(counter.incrementAndGet(),"Greetings"+ firstName+lastName);
    }
	
	
}