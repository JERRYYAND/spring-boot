package com.didispace;

import javax.jms.Queue;
import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

@org.springframework.boot.autoconfigure.SpringBootApplication
@MapperScan("com.didispace.dao")
public class SpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplication.class, args);
	}
	
	@Bean
	public Queue queue(){
		return new ActiveMQQueue("sample.queue");
	}

	@Bean
	public Topic topic(){
		return new ActiveMQTopic("sample.topic");
	}
}
