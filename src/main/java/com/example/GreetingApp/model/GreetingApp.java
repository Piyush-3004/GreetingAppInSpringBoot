package com.example.GreetingApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class GreetingApp {
	
	private long id;
	private String message;
	
	public GreetingApp(long incrementAndGet, String string) {
		this.message=string;
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
