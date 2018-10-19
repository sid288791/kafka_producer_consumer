package com.kafka.kafka_consumer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@EnableKafka
@Configuration
public class KafkaCnfiguration {
	
	@Bean
	public ConsumerFactory<String, String> consumerFactory() {
	  return new DefaultKafkaConsumerFactory<>(consumerConfigs());
	}
	
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
	  ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
	  factory.setConsumerFactory(consumerFactory());
	  // NOTE - set up of reply template
	 // factory.setReplyTemplate(kafkaTemplate());
	  return factory;
	}
	
	@Bean
	public Map<String, Object> consumerConfigs() {
	  Map<String, Object> config = new HashMap<>();
	  config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
	            "127.0.0.1:9092");
	  config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
	            StringDeserializer.class);
	  config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	  config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
	  return config;
	}
	
	@Bean
	public ConsumerFactory<String, User> userConsumerFactory() {
		Map<String, Object> config = new HashMap<>();
		  config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
		            "127.0.0.1:9092");
		  config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
		            StringDeserializer.class);
		  config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		  config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
		  return new DefaultKafkaConsumerFactory<>(config,new StringDeserializer(),new JsonDeserializer<>(User.class));
		}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, User> userkafkaListenerContainerFactory() {
	  ConcurrentKafkaListenerContainerFactory<String, User> factory = new ConcurrentKafkaListenerContainerFactory<>();
	  factory.setConsumerFactory(userConsumerFactory());
	  // NOTE - set up of reply template
	 // factory.setReplyTemplate(kafkaTemplate());
	  return factory;
	}

}
