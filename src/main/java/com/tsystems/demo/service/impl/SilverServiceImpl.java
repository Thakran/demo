package com.tsystems.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tsystems.demo.model.User;
import com.tsystems.demo.model.UserDeatilsDto;
import com.tsystems.demo.repository.CounterRepository;
import com.tsystems.demo.repository.UserReposiroty;
import com.tsystems.demo.service.CounterService;
import com.tsystems.demo.service.SubscriptionService;
import com.tsystems.demo.util.ApplicationConstants;
import com.tsystems.demo.util.CounterEnum;
import com.tsystems.demo.util.PackageType;

@Service
@Qualifier("silverService")
public class SilverServiceImpl implements SubscriptionService{

	@Autowired
	private UserReposiroty userRepo;
	
	@Autowired
	private CounterService counterService;
	
	
	@Override
	public void subscribe(User silverUser) {
		// TODO Auto-generated method stub
	
			silverUser.setPackageType(PackageType.SILVER);
			silverUser.setSmsAccess(true);
			silverUser.setEmailAccess(false);
			silverUser.setSmsCount(ApplicationConstants.silverSms);
			silverUser.setEmailCount(ApplicationConstants.silverEmail);
			
		userRepo.save(silverUser);
	}

	
}
