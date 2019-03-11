package com.gc.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gc.receiver.SecWorkersReceiver;
import com.gc.sender.SecWorkersSender;

@Configuration
public class SecWorkersConfig {
//	@Bean
//	public Queue worker() {
//		return new Queue("tut.hello");
//	}
	
	@Bean
	public SecWorkersReceiver secWorkersReceiver1() {
		return new SecWorkersReceiver(1);
	}
	
	@Bean
	public SecWorkersReceiver secWorkersReceiver2() {
		return new SecWorkersReceiver(2);
	}
	
	@Bean
	public SecWorkersSender secWorkersSender() {
		return new SecWorkersSender();
	}
}
