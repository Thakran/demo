package com.tsystems.demo.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsystems.demo.model.User;
import com.tsystems.demo.model.UserDeatilsDto;
import com.tsystems.demo.repository.UserReposiroty;
import com.tsystems.demo.service.SubscriptionService;
import com.tsystems.demo.util.PackageType;

@RestController
@RequestMapping("/subscribe")
public class SubscribeApi {

	public static final Logger LOGGER = LoggerFactory.getLogger(SubscribeApi.class);
	
	@Autowired
	@Qualifier("silverService")
	private SubscriptionService silverService;
	
	@Autowired
	@Qualifier("goldService")
	private SubscriptionService goldService;
	
	@Autowired
	@Qualifier("platiniumService")
	private SubscriptionService platiniumService;
	
	@Autowired
	private UserReposiroty userRepo;
	
	
	@PostMapping("/package")
	public ResponseEntity<String> subscribePackage(@RequestHeader(value="packageType") PackageType type,
			@RequestBody UserDeatilsDto userDetailsDto
			) throws Exception{
		LOGGER.info(" getting request for user for subscription type "+type);
		
        HttpStatus status = HttpStatus.OK;
		String message = "done with subscription ";
		User user= userRepo.findByUserName(userDetailsDto.getUserName());
		 if(user!=null) {
			 try {
					switch(type) {
					
					case SILVER: 
						silverService.subscribe(user);
						break;
						
					case GOLD:	
					     goldService.subscribe(user);
					     break;
					case PLATINIUM:
						platiniumService.subscribe(user);
						break;
					default : {message = " package type is not valid ";
					status = HttpStatus.BAD_REQUEST;
					}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					message = "Exception occurred";
					status = HttpStatus.EXPECTATION_FAILED;
					LOGGER.info(e.getMessage());
					
				} 
			 
		 }else {
			 message= "user not found";
		 }
		
		
		
		
		
		
		return new ResponseEntity<String>(message, status);
	}
	
	
}
