package com.example.GreetingApp.Controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.GreetingApp.model.GreetingApp;

@RestController
@RequestMapping("/greetings")
public class GreetingAppController {
	
	private final AtomicLong counter = new AtomicLong();
	@GetMapping("/greeting")
	public GreetingApp getGreeting(@RequestParam(value = "message", defaultValue="Default")String message) {
		GreetingApp greeting = new GreetingApp(counter.incrementAndGet(),message);
		return greeting;
	}
	//HTTP getmapping method with default and Request parameters
	//curl http://localhost:8080/greetings/greeting
	//	{"id": 0,"message": "Default"}
	
	// curl http://localhost:8080/greetings/greeting?message="parammessage"
	//{"id":0,"message":"parammessage"}
	@PostMapping("/greetingpost")
	public GreetingApp postGreeting(@RequestBody GreetingApp greeting) {	
		return greeting;
	}
	// postmapping tasted with postman returns json for given json without passing id.
	//http://localhost:8080/greetings/greetingpost
	@GetMapping("/greetingput/{message}")
	public GreetingApp putGreeting(@PathVariable String message) {
		GreetingApp greeting = new GreetingApp(counter.incrementAndGet(),message);
		return greeting;
	}
	//curl http://localhost:8080/greetings/greetingput/hello
	//{"id":0,"message":"hello"}
}

