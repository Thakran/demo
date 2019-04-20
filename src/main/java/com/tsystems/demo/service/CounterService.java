package com.tsystems.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.tsystems.demo.model.Counter;
import com.tsystems.demo.repository.CounterRepository;
import com.tsystems.demo.util.CounterEnum;



@Service
public class CounterService {

	@Autowired
	CounterRepository counterRepository;
	
	@Autowired
	MongoTemplate mongoTemplate;

	public Long increment(CounterEnum counterEnum) {
		
		if(!counterRepository.existsById(counterEnum.toString())){
			createandInitialize();	
			}
			Query query = new Query(Criteria.where("name").is(counterEnum.toString()));
			Update update = new Update().inc("counter", 1);
			return mongoTemplate.findAndModify(query, update, new FindAndModifyOptions().returnNew(true), Counter.class).getCounter();

	}

	public boolean createandInitialize() {
		for(CounterEnum counterEnum:CounterEnum.values())
			if(!counterRepository.existsById(counterEnum.toString())){
				counterRepository.save(new Counter(counterEnum.toString(),1l));
			}
			return true;

	}
}
