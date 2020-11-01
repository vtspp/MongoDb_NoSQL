package com.github.vtspp.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.github.vtspp.domain.Post;
import com.github.vtspp.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	PostService postService;
	
	@GetMapping
	public ResponseEntity<List<Post>> findAll(){
		return new ResponseEntity<>( postService.listAll(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		return new ResponseEntity<>(postService.findById(id), HttpStatus.OK);
	
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Post post){
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				                             .path("/{id}")
				                             .buildAndExpand(postService.insert(post)
				                             .getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping
	public ResponseEntity<Void> update(@RequestBody Post post) {
		postService.update(post);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		postService.delete(id);
		return ResponseEntity.noContent().build();
	}
	

}
