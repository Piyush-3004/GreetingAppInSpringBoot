package com.example.GreetingApp.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GreetingApp.dto.GreetingAppdto;
import com.example.GreetingApp.dto.Userdto;
import com.example.GreetingApp.model.GreetingApp;
import com.example.GreetingApp.repository.IGreetingRepository;

@Service
public class GreetingService implements IGreetingService {

	@Autowired
	IGreetingRepository repo;
	private final AtomicLong counter = new AtomicLong();

	// Uc 8
	
	public GreetingApp deleteMessage(Long id) {
		Optional<GreetingApp> ifMessage=repo.findById(id);
		if(ifMessage.isPresent()){
			repo.delete(ifMessage.get());
			return ifMessage.get();
		}
		return null;
	}
	// Uc7
	@Override
	public GreetingApp edit(long id, GreetingApp greetingApp) {
		Optional<GreetingApp> data = repo.findById(id);
		data.get().setMessage(greetingApp.getMessage());
		repo.save(data.get());
		return data.get();
	}

	// Uc 6
	public List<GreetingApp> getAll() {
		return repo.findAll();
	}

	// Uc 5
	@Override
	public GreetingApp getById(long id) {

		return repo.findById(id).orElse(null);
	}

	// Uc 4
	@Override
	public GreetingApp addGreeting(Userdto user) {
		String message = "Hello" + (user.getFirstName() == null ? "Helo World" : user.getFirstName())
				+ (user.getLastName() == null ? "" : user.getLastName());
		return repo.save(new GreetingApp(counter.incrementAndGet(), message));
	}

	// Uc 3
	@Override
	public GreetingApp greetingWithUser(Userdto user) {
		String message = "Hello" + (user.getFirstName() == null ? "Helo World" : user.getFirstName())
				+ (user.getLastName() == null ? "" : user.getLastName());
		return new GreetingApp(counter.incrementAndGet(), message);
	}

	// Uc 2
	@Override
	public String getGreeting(GreetingAppdto greetingAppDto) {
		String message = "Hello World";
		GreetingApp greeting = new GreetingApp(counter.incrementAndGet(), message);
		return greeting.getMessage();

	}

}
