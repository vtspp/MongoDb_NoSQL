package com.github.vtspp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.vtspp.domain.Post;
import com.github.vtspp.repository.impl.PostRepositoryImpl;
import com.github.vtspp.services.exceptions.ObjectAlreadyRegisteredException;
import com.github.vtspp.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepositoryImpl postRepositoryImpl;

	public List<Post> listAll() {
		return postRepositoryImpl.findAll();
	}

	public Post findById(String id) {

		if (!postRepositoryImpl.findById(id).isPresent()) {
			throw new ObjectNotFoundException("Postagem não encontrado");
		}
		return postRepositoryImpl.findById(id).get();
	}

	public Post insert(Post post) {
		if(postRepositoryImpl.existsById(post.getId())) {
			throw new ObjectAlreadyRegisteredException("Postagem já cadastrado. Somente alteração é possível.");
		}
		return postRepositoryImpl.insert(post);
	}

	public Post update(Post post) {
		Post p = findById(post.getId());
		p.setTitle(post.getTitle());
		p.setBody(post.getBody());
		p.setData(post.getData());
		postRepositoryImpl.save(p);
		return p;

	}

	public void delete(String id) {
		findById(id);
		postRepositoryImpl.deleteById(id);
	}

}
