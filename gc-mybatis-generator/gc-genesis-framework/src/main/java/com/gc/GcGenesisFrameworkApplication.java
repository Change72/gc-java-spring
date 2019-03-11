package com.gc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableDiscoveryClient
@SpringBootApplication
@EnableSwagger2
@EnableFeignClients
@MapperScan("com.gc.*.mapper")
public class GcGenesisFrameworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(GcGenesisFrameworkApplication.class, args);
	}
}
