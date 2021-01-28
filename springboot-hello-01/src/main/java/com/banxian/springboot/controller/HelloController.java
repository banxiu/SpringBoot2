package com.banxian.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: SpringBoot2
 * @description: hellocontroller
 * @author: Wangly
 * @create: 2021-01-28 11:05
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello springboot2";
    }
}