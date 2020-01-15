package com.blue.fish.source.controller;

import com.blue.fish.source.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bluefish 2020-01-10
 * @version 1.0.0
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public String hello() {
        return helloService.hello();
    }
}
