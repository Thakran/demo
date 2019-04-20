package com.tsystems.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tsystems.demo.model.NotificationRequest;

@Repository
public interface NotificationRequestRepository extends 
MongoRepository<NotificationRequest, Long>{

}
