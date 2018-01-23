package com.cloud.controller;

import com.cloud.service.SchedualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private SchedualService schedualService;

    @GetMapping("/test")
    public String sayHi(@RequestParam String name) {
        return "使用feign访问， " + schedualService.sayhi(name);
    }
}
