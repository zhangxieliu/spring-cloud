package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 当client向server注册时，它会提供一些元数据，例如主机端口，URL，主页等。Eureka server从每个Client实例接受心跳信息。
 * 如果心跳超时，则通常将该实例从注册server中删除
 */
@SpringBootApplication
@EnableEurekaClient// 启动一个Eureka客户端
public class ServerProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerProviderApplication.class, args);
	}
}