package com.example.GreetingApp.service;
import com.example.GreetingApp.dto.GreetingAppdto;
import com.example.GreetingApp.model.GreetingApp;

public interface IGreetingService {

	String getGreeting(GreetingAppdto greetingAppDto);

	GreetingApp greetingWithUser(String firstName);

	GreetingApp greetingWithUser(String firstName, String lastName);
}
