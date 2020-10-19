package com.github.vtspp.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.vtspp.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = Arrays.asList(new User(1, "Naruto", "naruto@gmail.com"), new User(2, "Sasuke", "sasuke@gmail.com"));
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
