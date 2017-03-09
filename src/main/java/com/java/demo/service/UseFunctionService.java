package com.java.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
