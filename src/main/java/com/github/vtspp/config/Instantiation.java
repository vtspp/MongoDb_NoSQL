package com.github.vtspp.config;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.github.vtspp.domain.Post;
import com.github.vtspp.domain.User;
import com.github.vtspp.repository.impl.PostRepositoryImpl;
import com.github.vtspp.repository.impl.UserRepositoryImpl;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	UserRepositoryImpl userRepositoryImpl;
	
	@Autowired
	PostRepositoryImpl postRepositoryImpl;

	@Override
	public void run(String... args) throws Exception {
		
		// Limpa a base de dados
		userRepositoryImpl.deleteAll();
		postRepositoryImpl.deleteAll();
		
		// Alimenta a base de dados
		userRepositoryImpl.saveAll(Arrays.asList(new User(null, "Naruto", "naruto@gmail.com"),
				                                 new User(null, "Sasuke", "sasuke@gmail.com"), 
				                                 new User(null, "Kakashi", "kakashi@gmail.com"), 
				                                 new User(null, "Maito Gai", "maitogai@gmail.com"),
				                                 new User(null, "Tsunade", "tsunade@gmail.com"),
				                                 new User(null, "Jiraya", "jiraya@gmail.com")));
		
		
		postRepositoryImpl.saveAll(Arrays.asList(new Post(null, LocalDateTime.of(2020, 10, 03, 12, 30), "Partiu viagem", "Vou viajar para São Paulo. Abraços !",userRepositoryImpl.findAll().get(0)),
				                                 new Post(null, LocalDateTime.of(2020, 12, 28, 8, 00), "Partiu viagem", "Vou viajar para Rio de Janeiro. Abraços !",userRepositoryImpl.findAll().get(1))));
		
		
	}

}
