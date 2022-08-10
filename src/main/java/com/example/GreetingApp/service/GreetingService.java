package com.example.GreetingApp.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.GreetingApp.dto.GreetingAppdto;
import com.example.GreetingApp.dto.Userdto;
import com.example.GreetingApp.model.GreetingApp;
import com.example.GreetingApp.repository.IGreetingRepository;


@Service
public class GreetingService implements IGreetingService{

	@Autowired
	IGreetingRepository repo;
	private final AtomicLong counter = new AtomicLong();
	@Override
	public String getGreeting(GreetingAppdto greetingAppDto) {
		String message = "Hello World";
		GreetingApp greeting = new GreetingApp(counter.incrementAndGet(),message);
		return greeting.getMessage();

	}
	public List<GreetingApp> getAll() {
		return repo.findAll();
	}
	
	@Override
	public GreetingApp getById(long id) {

		return repo.findById(id).orElse(null);
	}
		
	@Override
    public GreetingApp greetingWithUser(Userdto user) {
		String message ="Hello"+(user.getFirstName()==null ? "Helo World":user.getFirstName())
				+ (user.getLastName() == null? "":user.getLastName());
        return new GreetingApp(counter.incrementAndGet(),message);
    }

    @Override
    public GreetingApp greetingWithUser(String firstName, String lastName) {
    	return new GreetingApp(counter.incrementAndGet(),"Greetings"+ firstName+lastName);
    }

    @Override
	public GreetingApp addGreeting(Userdto user) {
		String message ="Hello"+(user.getFirstName() == null ? "Helo World" : user.getFirstName())
				+ (user.getLastName() == null? "" :user.getLastName());
		return repo.save(new GreetingApp(counter.incrementAndGet(),message));
	}

}
	
	
