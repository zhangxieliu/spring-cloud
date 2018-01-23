package com.cloud.controller;

import com.cloud.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @GetMapping("/{name}")
    public String hello(@PathVariable("name") String name) {
        // 这里调用自己的服务方法
        return "使用ribbon访问, " + helloService.hiService(name);
    }
}
