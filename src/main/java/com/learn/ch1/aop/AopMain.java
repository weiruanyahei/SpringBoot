package com.learn.ch1.aop;

import com.learn.ch1.aop.config.AopConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by ldy on 2017/3/9.
 */
public class AopMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
        DemoAnnotationService annotationService = configApplicationContext.getBean(DemoAnnotationService.class);
        DemoMethodService methodService = configApplicationContext.getBean(DemoMethodService.class);
        annotationService.add();
        methodService.add();
        configApplicationContext.close();
    }
}
