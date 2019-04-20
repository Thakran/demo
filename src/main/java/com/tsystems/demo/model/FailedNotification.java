package com.tsystems.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FailedNotification {

	@Id
	private Long id;
	
	private String userId;
	
	private Long timeInMills;
	
	private boolean processed;

	private Long requestId;
	
	
	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getTimeInMills() {
		return timeInMills;
	}

	public void setTimeInMills(Long timeInMills) {
		this.timeInMills = timeInMills;
	}

	public boolean isProcessed() {
		return processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}
	
	
}
