package com.github.vtspp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.vtspp.domain.User;
import com.github.vtspp.dto.UserDTO;
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

	public User insert(User user) {
		return userRepository.insert(user);
	}

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}

	public User update(User user) {
		User u = findById(user.getId());
		u.setName(user.getName());
		u.setEmail(user.getEmail());
		userRepository.save(u);
		return u;

	}

	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}

}
