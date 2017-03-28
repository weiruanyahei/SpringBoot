package com.learn.web.controller;

import com.learn.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ldy on 2017/3/28.
 */
@RestController
public class RestForMockController {
    @Autowired
    DemoService demoService;
    @RequestMapping(value = "/testRest",produces = "text/plain;charset=UTF-8")
    public String testRest(){
        return demoService.sayHello("kobe");
    }
}
