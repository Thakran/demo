package com.tsystems.demo.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tsystems.demo.model.User;
import com.tsystems.demo.service.SubscriptionService;

@Service
@Qualifier("goldService")
public class GoldServiceImpl implements SubscriptionService{

	@Override
	public void subscribe(User user) {
		// TODO Auto-generated method stub
		
	}

	
}
