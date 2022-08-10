package com.example.GreetingApp.service;
import java.util.List;

import com.example.GreetingApp.dto.GreetingAppdto;
import com.example.GreetingApp.dto.Userdto;
import com.example.GreetingApp.model.GreetingApp;

public interface IGreetingService {
	// Uc 2
	String getGreeting(GreetingAppdto greetingAppDto);

	// Uc 3
	GreetingApp greetingWithUser(Userdto user);	
	
	// Uc 4
	GreetingApp addGreeting(Userdto userDto);

	// Uc 5
	GreetingApp getById(long id);

	// Uc 6
	List<GreetingApp> getAll();
	
	// Uc 7
	GreetingApp edit(long id ,GreetingApp greetingApp);

	// Uc 8
	GreetingApp deleteMessage(Long id);
}
