package com.tsystems.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tsystems.demo.model.FailedNotification;

public interface FailedNotificationRepository extends MongoRepository<FailedNotification, Long> {

}
