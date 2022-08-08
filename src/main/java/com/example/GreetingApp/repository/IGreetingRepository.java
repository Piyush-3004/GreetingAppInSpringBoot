package com.example.GreetingApp.repository;
import com.example.GreetingApp.dto.GreetingAppdto;
import com.example.GreetingApp.model.GreetingApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGreetingRepository extends JpaRepository<GreetingApp, Long> {
	
	 GreetingApp addGreeting(GreetingAppdto greetingAppDto);
}
