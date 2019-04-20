package com.tsystems.demo.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsystems.demo.model.User;
import com.tsystems.demo.model.UserDeatilsDto;
import com.tsystems.demo.repository.UserReposiroty;
import com.tsystems.demo.service.CounterService;
import com.tsystems.demo.util.CounterEnum;

@RestController
@RequestMapping("/user")
public class UserApi {

	@Autowired
	private CounterService counterService;
	
	@Autowired
	private UserReposiroty userRepo;
	
	@PostMapping("/create")
	public ResponseEntity<String> createUser(@RequestBody UserDeatilsDto deatilsDto){

		String body = " user created successfully ";
		Long id = counterService.increment(CounterEnum.USER);
		User user = userRepo.findByUserName(deatilsDto.userName);
		if(user==null) {
		user = new User();
		user.setEmail(deatilsDto.getEmail());
		user.setId(id);
		user.setUserName(deatilsDto.getUserName());
		user.setPassword(deatilsDto.getPassword());

		userRepo.save(user);
		}else {
			body = " user name is not unique";
		}
		
		
		return new ResponseEntity<String>(body, HttpStatus.OK);
	}
	
	
	// edit api also 
}
