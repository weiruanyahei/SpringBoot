package com.learn.ch1.java.service;

/**
 * Created by ldy on 2017/3/9.
 */
public class UseFunctionService {
    public FunctionService service;

    public void setService(FunctionService service) {
        this.service = service;
    }

    public void sayHello(String word){
        System.out.println(service.sayHello(word));
    }
}
