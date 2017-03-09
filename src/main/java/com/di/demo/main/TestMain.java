package com.di.demo.main;

import com.di.demo.config.DIConfig;
import com.di.demo.service.UseFunctionService;
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
