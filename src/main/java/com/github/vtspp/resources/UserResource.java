package com.github.vtspp.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.vtspp.domain.User;
import com.github.vtspp.dto.UserDTO;
import com.github.vtspp.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = userService.listAll();
		List<UserDTO> listDTO = list.stream().map( dto -> new UserDTO(dto)).collect(Collectors.toList());
		return new ResponseEntity<>(listDTO, HttpStatus.OK);
	}

}
