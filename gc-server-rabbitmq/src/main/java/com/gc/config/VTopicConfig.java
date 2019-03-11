package com.gc.config;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gc.receiver.VTopicReceiver;
import com.gc.sender.VTopicSender;

@Configuration
public class VTopicConfig {
	@Bean
	public TopicExchange topic() {
		return new TopicExchange("tut.topic");
	}

	@Bean
	public Queue autoDeleteQueueTopic1() {
		return new AnonymousQueue();
	}

	@Bean
	public Queue autoDeleteQueueTopic2() {
		return new AnonymousQueue();
	}

	@Bean
	public Binding bindingTopic1a(TopicExchange topic, Queue autoDeleteQueueTopic1) {
		return BindingBuilder.bind(autoDeleteQueueTopic1).to(topic).with("*.orange.*");
	}

	@Bean
	public Binding bindingTopic1b(TopicExchange topic, Queue autoDeleteQueueTopic1) {
		return BindingBuilder.bind(autoDeleteQueueTopic1).to(topic).with("*.*.rabbit");
	}

	@Bean
	public Binding bindingTopic2a(TopicExchange topic, Queue autoDeleteQueueTopic2) {
		return BindingBuilder.bind(autoDeleteQueueTopic2).to(topic).with("lazy.#");
	}

	@Bean
	public VTopicReceiver vTopicReceiver() {
		return new VTopicReceiver();
	}

	@Bean
	public VTopicSender vTopicSender() {
		return new VTopicSender();
	}
}
