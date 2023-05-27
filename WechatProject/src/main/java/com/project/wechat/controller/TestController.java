package com.project.wechat.controller;

import com.project.wechat.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/getValue")
    public boolean getValue() {
        return testService.getValue();
    }
}
