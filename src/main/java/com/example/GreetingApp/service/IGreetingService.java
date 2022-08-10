package com.example.GreetingApp.service;
import java.util.List;

import com.example.GreetingApp.dto.GreetingAppdto;
import com.example.GreetingApp.dto.Userdto;
import com.example.GreetingApp.model.GreetingApp;

public interface IGreetingService {

	String getGreeting(GreetingAppdto greetingAppDto);

	GreetingApp greetingWithUser(Userdto user);

	GreetingApp greetingWithUser(String firstName, String lastName);
	
	GreetingApp addGreeting(Userdto userDto);

	GreetingApp getById(long id);
//	GreetingApp addGreeting(GreetingAppdto greetingAppDto);

	List<GreetingApp> getAll();
}
