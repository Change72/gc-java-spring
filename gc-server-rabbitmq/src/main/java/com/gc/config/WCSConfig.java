package com.gc.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gc.receiver.WCSServer;
import com.gc.sender.WCSClient;

@Configuration
public class WCSConfig {

	@Bean
	public Queue queue() {
		return new Queue("tut.rpc.requests");
	}

	@Bean
	public DirectExchange exchange() {
		return new DirectExchange("tut.rpc");
	}

	@Bean
	public Binding binding(DirectExchange exchange, Queue queue) {
		return BindingBuilder.bind(queue).to(exchange).with("rpc");
	}

	@Bean
	public WCSServer wCSServer() {
		return new WCSServer();
	}
	
	@Bean
	public WCSClient wCSClient() {
		return new WCSClient();
	}
}
