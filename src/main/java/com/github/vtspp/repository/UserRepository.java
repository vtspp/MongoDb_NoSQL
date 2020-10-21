package com.github.vtspp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.github.vtspp.domain.User;

public interface UserRepository extends Repositories<User, String>, MongoRepository<User, String>{

}
