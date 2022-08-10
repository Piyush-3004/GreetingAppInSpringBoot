package com.example.GreetingApp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.GreetingApp.dto.GreetingAppdto;
import com.example.GreetingApp.model.GreetingApp;


public interface IGreetingRepository extends JpaRepository<GreetingApp , Long> {
	
	
}
