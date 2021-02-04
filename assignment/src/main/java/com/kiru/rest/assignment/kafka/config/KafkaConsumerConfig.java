package com.kiru.rest.assignment.kafka.config;

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

import com.kiru.rest.assignment.dto.TransactionDTO;
import com.kiru.rest.assignment.model.Balance;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {

	@Bean
	public ConsumerFactory<String,Balance> balanceConsumerFactory(){
		Map<String,Object> configs=new HashMap<>();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,JsonDeserializer.class);
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, "testGroup1");
		return new DefaultKafkaConsumerFactory<>(configs, new StringDeserializer(),new JsonDeserializer<>(Balance.class));
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Balance> balanceKafkaListernerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, Balance> factory= new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(balanceConsumerFactory());
		return factory;
	}
	
	@Bean
	public ConsumerFactory<String, TransactionDTO> transactionConsumerFactory(){
		Map<String,Object> configs=new HashMap<>();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,JsonDeserializer.class);
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, "testGroup2");
		return new DefaultKafkaConsumerFactory<>(configs, new StringDeserializer(),new JsonDeserializer<>(TransactionDTO.class));
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, TransactionDTO> transactionKafkaListernerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, TransactionDTO> factory= new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(transactionConsumerFactory());
		return factory;
		
	}
}
