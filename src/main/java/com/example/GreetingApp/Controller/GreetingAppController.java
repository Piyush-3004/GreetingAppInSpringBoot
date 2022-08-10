package com.example.GreetingApp.Controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.GreetingApp.dto.GreetingAppdto;
import com.example.GreetingApp.model.GreetingApp;

import com.example.GreetingApp.dto.Userdto;

import com.example.GreetingApp.service.IGreetingService;

@RestController
@RequestMapping("/greetings")
public class GreetingAppController {
	
	private final AtomicLong counter = new AtomicLong();
	@Autowired
	private IGreetingService greetingService;
	
//// Uc 8 Delete Message
	@DeleteMapping("deleteMessage/{id}")
		public GreetingApp deleteMessage(@PathVariable Long id){
		return greetingService.deleteMessage(id);
	}
	
	
//// Uc 7 Edit the message
	@PutMapping("/edit/{id}")
	public GreetingApp edit(@RequestBody GreetingApp greetingApp , @PathVariable long id) {

		return greetingService.edit(id,greetingApp);
	}

	
//// Uc 6 Get All messages

	@GetMapping("getAllMessages")
	public List<GreetingApp> getAllMessages(){
		return greetingService.getAll();
	}
	
///// Uc 5 Find by Id

	@GetMapping("getById/{id}")
	public GreetingApp getById(@PathVariable long id) {
		return greetingService.getById(id);
	}
	
///// Uc 4 Save Message in Repository	
	//adds first or and last name to greeting if passed in parameters
	
	@PostMapping("/addmessage")
	public GreetingApp greeting(@RequestParam(value = "firstName", defaultValue="")String firstName,@RequestParam(value = "lastName", defaultValue="")String lastName) {
		Userdto user = new Userdto();
		user.setFirstName(firstName);
		user.setFirstName(lastName);
		return greetingService.addGreeting(user);		   

	}
///// Uc 3 Greeting with User attributes
      //1. User First Name and LastName or
	  //2. With just First Name or LastName based on User attributes provides or
	  //3. Just Hello World.
	  @GetMapping("/greetings")
	  public GreetingApp greetingWithUser(@RequestParam (value = "firstName", defaultValue="")String firstName
			  							 ,@RequestParam(value = "lastName", defaultValue="")String lastName) {
		  Userdto user = new Userdto();
		  user.setFirstName(firstName);
		  user.setLastName(lastName);
		  return greetingService.greetingWithUser(user);
	
	  }
	  //http://localhost:8080/greetings/greetingswithfirstnameandlastname
	  //{"id": 0,"message": "GreetingsPiyushPatil"	}
//	  @PostMapping("/greetingswithfirstnameandlastname")
//	  public GreetingApp userGreeting1(@RequestBody Userdto userDTO) {
//		  
//        return greetingService.greetingWithUser("Hello"+userDTO.getFirstName()+userDTO.getLastName());
//	  }
	  
//// Uc 2 get "Hello World" using Service Layer
	
	@GetMapping("/getgreetingservice")
	public String getGreeting(@RequestBody GreetingAppdto greetingAppDto){

	    return greetingService.getGreeting(greetingAppDto);
	}
	
	
	// Uc 1
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

