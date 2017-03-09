package com.learn.ch1.di.service;

import org.springframework.stereotype.Service;

/**
 * Created by ldy on 2017/3/9.
 */
@Service
public class FunctionService {
    public String sayHello(String word){
        return "Hello "+word+" ! ";
    }
}
