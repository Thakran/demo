package com.tsystems.demo.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsystems.demo.model.NotificationRequest;
import com.tsystems.demo.model.NotifyUser;
import com.tsystems.demo.model.User;
import com.tsystems.demo.repository.NotificationRequestRepository;
import com.tsystems.demo.repository.UserReposiroty;
import com.tsystems.demo.service.CounterService;
import com.tsystems.demo.service.NotificationService;
import com.tsystems.demo.util.CounterEnum;
import com.tsystems.demo.util.PackageType;

@RestController
@RequestMapping("/notification")
public class NotificationApi {
	
	
	@Autowired
	private NotificationService notificationService;
	
	@Autowired
	private UserReposiroty userRepo;
	
	@Autowired
	private NotificationRequestRepository notificationRequestRepo;

	@Autowired
	private CounterService counterService;
	
	@PostMapping("/request")
	public ResponseEntity<String> sendNotification(@RequestHeader("userName") String userName,
			@RequestHeader("messsge" )String messageToSend,
			@RequestBody List<NotifyUser> list){
		
		User user = userRepo.findByUserName(userName);
		String message = "request taken ";
		HttpStatus status = HttpStatus.OK;
		if(user!=null) {
		
			Long id = counterService.increment(CounterEnum.NOTIFYREQUEST);
			NotificationRequest request = new NotificationRequest();
			request.setUserName(userName);
			request.setListOfUser(list);
			request.setId(id);
			request.setTimeInMillis(System.currentTimeMillis());
			request.setPackageType(user.getPackageType());
			request.setMesssage(messageToSend);
			notificationRequestRepo.save(request);
			
		}else {
	
			message= " User does not exits "+ userName;
			status = HttpStatus.BAD_REQUEST;
		}
		
		
		return new ResponseEntity<String>(message, status);
	}
	
	
	@Scheduled(cron = "0 0 12 * * ?")
	@PostMapping("/send")
	public void sendNotification() {
		
		List<NotificationRequest> listOfRequest = notificationRequestRepo.findAll();
		
		listOfRequest.forEach((request )->{
			if(request.getPackageType().equals(PackageType.SILVER)) {
				notificationService.sendSmsNotificaiton(request.getListOfUser(), 
						request.getUserName(),request.getMesssage(),request.getId());
			}
		});
		
	}
	

}
