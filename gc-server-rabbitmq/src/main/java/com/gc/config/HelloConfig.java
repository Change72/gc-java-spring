package com.gc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gc.receiver.HelloReceiver;
import com.gc.sender.HelloSender;

@Configuration
public class HelloConfig {

	// 关于Queue的Bean只能注入一个
//	@Bean
//	public Queue hello() {
//		return new Queue("hello");
//	}
	
	@Bean
	public HelloReceiver helloReceiver() {
		return new HelloReceiver();
	}
	
	@Bean
	public HelloSender helloSender() {
		return new HelloSender();
	}
}
