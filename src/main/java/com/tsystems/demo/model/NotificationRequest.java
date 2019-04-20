package com.tsystems.demo.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.tsystems.demo.util.PackageType;

@Document
public class NotificationRequest {

	@Id
	private Long id;
	
	private List<NotifyUser> listOfUser;
	
	private PackageType packageType;
	
	private String messsage;
	
	
	
	
	
	public String getMesssage() {
		return messsage;
	}

	public void setMesssage(String messsage) {
		this.messsage = messsage;
	}

	public PackageType getPackageType() {
		return packageType;
	}

	public void setPackageType(PackageType packageType) {
		this.packageType = packageType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	private String userName;
	
	private Long timeInMillis;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<NotifyUser> getListOfUser() {
		return listOfUser;
	}

	public void setListOfUser(List<NotifyUser> listOfUser) {
		this.listOfUser = listOfUser;
	}

	public Long getTimeInMillis() {
		return timeInMillis;
	}

	public void setTimeInMillis(Long timeInMillis) {
		this.timeInMillis = timeInMillis;
	}
	
	
}
