package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka是一个高可用的组件，它没有后端缓存，每一个实例注册之后需要向注册中心发送心跳（可以在内存中完成），
 * 默认情况下eureka server也是一个eureka client，必须指定一个server
 * eureka server是有界面的，启动工程，打开浏览器访问http://localhost:[port]
 */
@SpringBootApplication
@EnableEurekaServer// 启动一个服务注册中心
public class SpringCloudServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudServerApplication.class, args);
	}
}
