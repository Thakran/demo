package com.tsystems.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.tsystems.demo.util.CounterEnum;

@Document
public class Counter {

	@Id
	private String name;
	
	private Long counter;
	
	public Counter() {}
	
	

	public Counter(String name, Long counter) {
		super();
		this.name = name;
		this.counter = counter;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCounter() {
		return counter;
	}

	public void setCounter(Long counter) {
		this.counter = counter;
	}
	
	
	
	
}
