package com.cloud.service.impl;

import com.cloud.service.SchedualService;
import org.springframework.stereotype.Component;

@Component
public class SchedualServiceImpl implements SchedualService {
    @Override
    public String sayhi(String name) {
        return "使用feign出现错误了，你的参数是：name: " + name;
    }
}
