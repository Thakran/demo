package com.tsystems.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tsystems.demo.model.User;

@Repository
public interface UserReposiroty extends MongoRepository<User, Long> {

	public User findByUserName(String userName);
}
