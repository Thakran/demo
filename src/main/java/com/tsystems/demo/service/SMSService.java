package com.tsystems.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tsystems.demo.model.NotifyUser;

@Service
public class SMSService {

	public void sendNotification(List<NotifyUser> listOfUser, String userName, String message) {
		System.out.println(" notifcation sent");
	}
}
