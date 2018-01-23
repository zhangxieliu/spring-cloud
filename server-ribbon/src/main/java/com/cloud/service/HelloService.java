package com.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    private RestTemplate restTemplate;// 注入我们用于负载均衡的restTemplate，用于消费server-provider服务的接口

    /**
     * @HystrixCommand(fallbackMethod = "hasError") 创建了熔断器的功能，并指定fallbackMethod熔断方法
     */
    @HystrixCommand(fallbackMethod = "hasError")
    public String hiService(String name) {
        // 这里做了负载均衡，访问了不同的端口的服务实例
        // 这里我们用之前在application中指定的name服务名称来选择具体的服务实例，根据服务实例在请求的时候会用具体的url替换掉服务名称
        return restTemplate.getForObject("http://server-provider/" + name, String.class);
    }

    public String hasError(String name) {
        return "使用ribbon服务消费者, 出现错误，传递参数是name: " + name;
    }
}
