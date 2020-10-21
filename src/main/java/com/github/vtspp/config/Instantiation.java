package com.github.vtspp.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.github.vtspp.domain.User;
import com.github.vtspp.repository.impl.UserRepositoryImpl;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	UserRepositoryImpl userRepositoryImpl;

	@Override
	public void run(String... args) throws Exception {
		
		userRepositoryImpl.deleteAll(); // Limpa a base de dados
		
		// Alimenta a base de dados
		userRepositoryImpl.saveAll(Arrays.asList(new User(null, "Naruto", "naruto@gmail.com"),
				                                 new User(null, "Sasuke", "sasuke@gmail.com"), 
				                                 new User(null, "Kakashi", "kakashi@gmail.com"), 
				                                 new User(null, "Maito Gai", "maitogai@gmail.com"),
				                                 new User(null, "Tsunade", "tsunade@gmail.com"),
				                                 new User(null, "Jiraya", "jiraya@gmail.com")));
		
	}

}
