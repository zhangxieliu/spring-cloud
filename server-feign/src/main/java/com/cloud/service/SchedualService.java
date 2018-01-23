package com.cloud.service;

import com.cloud.service.impl.SchedualServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign自带断路器，需要在配置文件里打开它，在@FeignClient中的fallback填写类，该类需要实现我们自己自己定义的接口，并注入到IOC容器中
 * 通过@FeignClient("服务名")，来指定调用哪个服务。在application.yml中指定的spring.application.name="服务名"
 */
@FeignClient(value = "server-provider", fallback = SchedualServiceImpl.class)
public interface SchedualService {

    /**
     * 在web层的Controller层，对外暴露一个"/hi"的api接口，通过上面定义的Feign客户端SchedualService来消费服务
     * @GetMapping("/test") 这里指定需要调用的服务的url地址映射
     */
    @GetMapping("/test")
    String sayhi(@RequestParam("name") String name);
}
