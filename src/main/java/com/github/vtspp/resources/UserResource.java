package com.github.vtspp.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		return new ResponseEntity<>(new UserDTO(userService.findById(id)), HttpStatus.OK);
	
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO){
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				                             .path("/{id}")
				                             .buildAndExpand(userService.insert(userService.fromDTO(userDTO))
				                             .getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
