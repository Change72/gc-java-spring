package com.gc.receiver;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Value;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DeliverCallback;

public class UTestReceiver {
	private String host;

	@Value("${spring.rabbitmq.host}")
	public void setHost(String host) {
		this.host = host;
	}

	private String queue;

	@Value("#{autoDeleteQueueDirect1.name}")
	public void setName(String name) {
		this.queue = name;
	}

	public void secondReceiver() throws IOException, TimeoutException {
		System.out.println(queue);
		ConnectionFactory factory = new ConnectionFactory();

		factory.setHost(host);
		factory.setPort(5672);
		factory.setUsername("guest");
        factory.setPassword("guest");
		try (
				Connection connection2 = factory.newConnection(); 
				Channel channel = connection2.createChannel();
				) {
//			Consumer deliverCallback =  {
//				System.out.println("flag");
//				String message = new String(delivery.getBody(), "utf-8");
//				System.out.println(message);
//			};
//			System.out.println(queue);
//			channel.basicConsume(queue, false, deliverCallback);
		}
	}
}
