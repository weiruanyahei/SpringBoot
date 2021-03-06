package com.learn.ch1.java.main;

import com.learn.ch1.java.config.JavaConfig;
import com.learn.ch1.java.service.UseFunctionService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by ldy on 2017/3/9.
 */
public class TestMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        UseFunctionService functionService = context.getBean(UseFunctionService.class);
        functionService.sayHello("JAVA Config.");
        context.close();
    }
}
