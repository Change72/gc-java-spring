package com.gc.angela;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GCServerRabbitmqConsumer {

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

	@Test
	public void contextReceive() throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();

		factory.setHost(host);
		try (
				Connection connection2 = factory.newConnection(); 
				Channel channel = connection2.createChannel();
				) {
			DeliverCallback deliverCallback = (consumerTag, delivery) -> {
				String message = new String(delivery.getBody(), "utf-8");
				System.out.println(message);
			};
			System.out.println(queue);
			channel.basicConsume(queue, false, deliverCallback, consumerTag -> {
			});
		}
	}
}
