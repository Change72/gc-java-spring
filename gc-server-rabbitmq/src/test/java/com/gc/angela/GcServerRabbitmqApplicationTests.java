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

@RunWith(SpringRunner.class)
@SpringBootTest
public class GcServerRabbitmqApplicationTests {
	
	private String host;
	
	@Value("${spring.rabbitmq.host}")
	public void setHost(String host) {
		this.host = host;
	}
	
	private String name;
	@Value("#{direct.name}")
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Test
	public void contextLoads() throws IOException, TimeoutException {
		
		ConnectionFactory factory = new ConnectionFactory();
		
		factory.setHost(host);
		try (
				Connection connection = factory.newConnection();
				Channel channel = connection.createChannel();			
		){
			System.out.println(name);
			String message = "test";
			channel.basicPublish(name, "orange", null, message.getBytes("utf-8"));
		}
	}

}

