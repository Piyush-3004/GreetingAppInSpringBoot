package com.example.GreetingApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.GreetingApp.dto.GreetingAppdto;

@Entity
@Data
public class GreetingApp {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	public GreetingApp() {
		super();
	}
	private String message;
	
	public GreetingApp(long incrementAndGet, String string) {
		
		this.message=string;
	}

//	public GreetingApp(GreetingAppdto greetingAppDto) {
//
//		this.message=greetingAppDto.
//	}

	public GreetingApp(GreetingAppdto greetingAppDto) {
		this.message=greetingAppDto.toString();
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
