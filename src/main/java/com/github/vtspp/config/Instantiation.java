package com.github.vtspp.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.github.vtspp.domain.User;
import com.github.vtspp.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll(); // Limpa a base de dados
		
		// Alimenta a base de dados
		userRepository.saveAll(Arrays.asList(new User(null, "Naruto", "naruto@gmail.com"),
				                             new User(null, "Sasuke", "sasuke@gmail.com"), 
				                             new User(null, "Kakashi", "kakashi@gmail.com"), 
				                             new User(null, "Maito Gai", "maitogai@gmail.com"),
				                             new User(null, "Tsunade", "tsunade@gmail.com"),
				                             new User(null, "Jiraya", "jiraya@gmail.com")));
		
	}

}
