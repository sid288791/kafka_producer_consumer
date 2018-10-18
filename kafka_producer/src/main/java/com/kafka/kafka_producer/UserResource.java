package com.kafka.kafka_producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="kafka")
public class UserResource {
	
	@Autowired
	KafkaTemplate<String, User> kafkaTemplate;
	
	private static final String TOPIC = "test";
	
	@GetMapping(value="/publish/{name}")
	public String getMessage(@PathVariable("name") final String name) {
		
		kafkaTemplate.send(TOPIC,new User(name,"Tech","200"));
		
		return "Published Successfully";
		
	}

}
