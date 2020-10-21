package com.github.vtspp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.vtspp.domain.User;
import com.github.vtspp.dto.UserDTO;
import com.github.vtspp.repository.impl.UserRepositoryImpl;
import com.github.vtspp.services.exceptions.ObjectAlreadyRegisteredException;
import com.github.vtspp.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepositoryImpl userRepositoryImpl;

	public List<User> listAll() {
		return userRepositoryImpl.findAll();
	}

	public User findById(String id) {

		if (!userRepositoryImpl.findById(id).isPresent()) {
			throw new ObjectNotFoundException("Usuário não encontrado");
		}
		return userRepositoryImpl.findById(id).get();
	}

	public User insert(User user) {
		if(userRepositoryImpl.existsById(user.getId())) {
			throw new ObjectAlreadyRegisteredException("Usuário já cadastrado. Somente alteração é possível.");
		}
		return userRepositoryImpl.insert(user);
	}

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}

	public User update(User user) {
		User u = findById(user.getId());
		u.setName(user.getName());
		u.setEmail(user.getEmail());
		userRepositoryImpl.save(u);
		return u;

	}

	public void delete(String id) {
		findById(id);
		userRepositoryImpl.deleteById(id);
	}

}
