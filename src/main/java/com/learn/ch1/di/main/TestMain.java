package com.learn.ch1.di.main;

import com.learn.ch1.di.config.DIConfig;
import com.learn.ch1.di.service.UseFunctionService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by ldy on 2017/3/9.
 */
public class TestMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfig.class);
        UseFunctionService functionService = context.getBean(UseFunctionService.class);
        functionService.sayHello("成功啦？");
        context.close();
    }
}
