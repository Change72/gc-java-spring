package com.gc.config;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gc.receiver.UDirectReceiver;
import com.gc.receiver.UTestReceiver;
import com.gc.sender.UDirectSender;

@Configuration
public class UDirectConfig {
	@Bean
	public DirectExchange direct() {
		return new DirectExchange("tut.direct");
	}

	@Bean
	public Queue autoDeleteQueueDirect1() {
		return new AnonymousQueue();
	}

	@Bean
	public Queue autoDeleteQueueDirect2() {
		return new AnonymousQueue();
	}

	@Bean
	public Binding binding1a(DirectExchange direct, Queue autoDeleteQueueDirect1) {
		return BindingBuilder.bind(autoDeleteQueueDirect1).to(direct).with("orange");
	}

	@Bean
	public Binding binding1b(DirectExchange direct, Queue autoDeleteQueueDirect1) {
		return BindingBuilder.bind(autoDeleteQueueDirect1).to(direct).with("black");
	}

	@Bean
	public Binding binding2a(DirectExchange direct, Queue autoDeleteQueueDirect2) {
		return BindingBuilder.bind(autoDeleteQueueDirect2).to(direct).with("green");
	}

	@Bean
	public Binding binding2b(DirectExchange direct, Queue autoDeleteQueueDirect2) {
		return BindingBuilder.bind(autoDeleteQueueDirect2).to(direct).with("black");
	}

	@Bean
	public UDirectReceiver uDirectReceiver() {
		return new UDirectReceiver();
	}
	
	@Bean
	public UTestReceiver uTestReceiver(){
		return new UTestReceiver();
	}

	@Bean
	public UDirectSender uDirectSender() {
		return new UDirectSender();
	}
}
