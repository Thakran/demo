package com.tsystems.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.tsystems.demo.util.PackageType;

@Document
public class User {

	@Id
	private Long id;
	
	private String userName;
	
	private String email;
	
	private PackageType packageType;
	
	private boolean emailAccess;
	
	private boolean smsAccess;
	
	private Long emailCount;
	
	private Long smsCount;
	
	private String password;
	
	
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public User() {}
	

	public User(Long id, String userName, String email, PackageType packageType, boolean emailAccess, boolean smsAccess,
			Long emailCount, Long smsCount) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.packageType = packageType;
		this.emailAccess = emailAccess;
		this.smsAccess = smsAccess;
		this.emailCount = emailCount;
		this.smsCount = smsCount;
	}

	public boolean isEmailAccess() {
		return emailAccess;
	}

	public void setEmailAccess(boolean emailAccess) {
		this.emailAccess = emailAccess;
	}

	public boolean isSmsAccess() {
		return smsAccess;
	}

	public void setSmsAccess(boolean smsAccess) {
		this.smsAccess = smsAccess;
	}

	public Long getEmailCount() {
		return emailCount;
	}

	public void setEmailCount(Long emailCount) {
		this.emailCount = emailCount;
	}

	public Long getSmsCount() {
		return smsCount;
	}

	public void setSmsCount(Long smsCount) {
		this.smsCount = smsCount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PackageType getPackageType() {
		return packageType;
	}

	public void setPackageType(PackageType packageType) {
		this.packageType = packageType;
	}
	
	
}
