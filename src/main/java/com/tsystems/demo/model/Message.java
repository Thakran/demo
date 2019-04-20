package com.tsystems.demo.model;

public class Message {

	private String message;
	
	private NotifyUser user;
	
	private String fromUser;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public NotifyUser getUser() {
		return user;
	}

	public void setUser(NotifyUser user) {
		this.user = user;
	}

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
}
