package com.github.vtspp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.vtspp.domain.User;
import com.github.vtspp.repository.UserRepository;
import com.github.vtspp.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> listAll() {
		return userRepository.findAll();
	}

	public User findById(String id) {

		if (!userRepository.findById(id).isPresent()) {
			throw new ObjectNotFoundException("Usuário não encontrado");
		}
		return userRepository.findById(id).get();
	}

}
