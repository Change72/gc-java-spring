package com.gc.config;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gc.receiver.ThirdFanoutReceiver;
import com.gc.sender.ThirdFanoutSender;

@Configuration
public class ThirdFanoutConfig {
	@Bean
	public FanoutExchange fanout() {
		return new FanoutExchange("tut.fanout");
	}
	
	@Bean
	public Queue autoDeleteQueue1() {
		return new AnonymousQueue();
	}

	@Bean
	public Queue autoDeleteQueue2() {
		return new AnonymousQueue();
	}
	
	@Bean
	public Binding binding1(FanoutExchange fanout, Queue autoDeleteQueue1) {
		return BindingBuilder.bind(autoDeleteQueue1).to(fanout);
	}

	@Bean
	public Binding binding2(FanoutExchange fanout, Queue autoDeleteQueue2) {
		return BindingBuilder.bind(autoDeleteQueue2).to(fanout);
	}
	
	@Bean
	public ThirdFanoutReceiver thirdFanoutReceiver() {
		return new ThirdFanoutReceiver();
	}
	
	@Bean
	public ThirdFanoutSender TthirdFanoutSender() {
		return new ThirdFanoutSender();
	}
}
