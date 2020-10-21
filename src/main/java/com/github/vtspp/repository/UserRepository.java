package com.github.vtspp.repository;

import org.springframework.stereotype.Repository;

import com.github.vtspp.domain.User;

@Repository
public interface UserRepository extends Repositories<User, String>{

}
