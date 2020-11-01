package com.github.vtspp.repository;

import org.springframework.stereotype.Repository;

import com.github.vtspp.domain.Post;

@Repository
public interface PostRepository extends Repositories<Post, String> {

}
