package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 服务的消费者
 * 在浏览器打开http://localhost:8084/ribbon
 * 如果有多个不同端口的服务实例，可以在浏览器反复访问看到交替访问不同实例，因为这里ribbon做了负载均衡的处理
 */
@SpringBootApplication
@EnableDiscoveryClient// 启用发现客户端，用于向服务中心注册；并且向程序的IOC注入一个bean：restTemplate
@EnableHystrix// 激活断路器
@EnableHystrixDashboard// 激活断路器仪表盘
public class ServerRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerRibbonApplication.class, args);
	}

	@Bean
	@LoadBalanced// 表明这个restTemplate开启了负载均衡的功能
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
