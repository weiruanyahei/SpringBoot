package com.learn.service.impl;

import com.learn.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * Created by ldy on 2017/3/28.
 */
@Service
public class DemoServiceImpl implements DemoService{

    @Override
    public String sayHello(String name) {
        return "Hello "+name;
    }
}
