package com.github.vtspp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.vtspp.domain.User;
import com.github.vtspp.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> listAll(){
		return userRepository.findAll();
	}

}
