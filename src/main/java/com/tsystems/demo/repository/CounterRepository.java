package com.tsystems.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tsystems.demo.model.Counter;

public interface CounterRepository extends MongoRepository<Counter, String>{

}
