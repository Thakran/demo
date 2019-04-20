package com.tsystems.demo.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsystems.demo.endpoint.SubscribeApi;
import com.tsystems.demo.model.FailedNotification;
import com.tsystems.demo.model.NotifyUser;
import com.tsystems.demo.repository.FailedNotificationRepository;
import com.tsystems.demo.util.CounterEnum;

@Service
public class NotificationService {

	public static final Logger LOGGER = LoggerFactory.getLogger(NotificationService.class);

	
	@Autowired
	private SMSService smsService;
	
	@Autowired
	private CounterService counterService;
	
	@Autowired
	private FailedNotificationRepository failedNotificationRepo;
	
	public void sendSmsNotificaiton(List<NotifyUser> listOfUser,
			String userName, String message, Long requestId) {
		

		int retryCount =5;
		
		while(retryCount > 0) {
		try {
			smsService.sendNotification(listOfUser,userName,message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.error(" exception occured while sending notification "+e.getMessage());
			if(retryCount==0) {
				Long id = counterService.increment(CounterEnum.FAILEDNOTIFICATION);
				FailedNotification failedNotification = new FailedNotification();
				failedNotification.setUserId(userName);
				failedNotification.setTimeInMills(System.currentTimeMillis());
				failedNotification.setProcessed(false);
				failedNotification.setId(id);
				failedNotification.setRequestId(requestId);
				failedNotificationRepo.save(failedNotification);
			}
			
			
		   }
		}
	
	}	
	
	
	public void sendEmailNotificaiton() {}
}


