package com.learn.ch3.annotation;

import org.springframework.stereotype.Service;

/**
 * Created
 * by ldy on 2017/3/20.
 */
@Service
public class DemoService {
    public void outputResult(){
        System.out.println("Demonstrate the bean normal access.");
    }
}
