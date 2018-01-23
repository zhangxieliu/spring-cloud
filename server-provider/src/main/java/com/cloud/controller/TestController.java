package com.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${server.port}")
    private String port;// 获取服务端口号

    @GetMapping("/{name}")
    public String test(@PathVariable("name") String name) {
        return "test: " + name + ", from port: " + port;
    }
}
