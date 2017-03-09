package com.learn.ch1.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ldy on 2017/3/9.
 */
@Service
public class UseFunctionService {
    @Autowired
    public FunctionService service;

    public void sayHello(String word){
        System.out.println(service.sayHello(word));
    }
}
