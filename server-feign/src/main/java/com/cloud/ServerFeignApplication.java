package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Feign是一个声明式的伪Http客户端，使用Feign只需要创建一个接口并注解。它具有可插拔的注解特性，可使用Feign注解和JAX-RS注解。
 * Feign支持可插拔的编码器和解码器。Feign默认集成了Ribbon，并和Eureka结合，默认实现了负载均衡的效果。
 * Feign采用的是基于接口的注解
 * Feign整合了ribbon
 */
@SpringBootApplication
@EnableDiscoveryClient// 开启从注册中心发现客户端服务的功能
@EnableFeignClients// 开启Feign的功能
public class ServerFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerFeignApplication.class, args);
	}
}
