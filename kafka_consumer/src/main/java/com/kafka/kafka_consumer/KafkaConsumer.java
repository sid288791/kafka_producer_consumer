package com.kafka.kafka_consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	
	@KafkaListener(topics="test",groupId="group_id")
	public void consume(String message) {
		System.out.println("consumed message"+message);
	}
	
	@KafkaListener(topics="test_json",groupId="group_json",containerFactory="userkafkaListenerContainerFactory")
	public void consumeJson(User user) {
		System.out.println("consumed json"+user);
	}

}
