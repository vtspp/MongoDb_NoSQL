package com.github.vtspp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface Repositories<T, K> extends MongoRepository<T, K>{

}
