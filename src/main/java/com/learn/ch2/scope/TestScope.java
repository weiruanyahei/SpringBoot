package com.learn.ch2.scope;

import com.learn.ch2.scope.config.ScopeConfig;
import com.learn.ch2.scope.service.DemoPrototypeService;
import com.learn.ch2.scope.service.DemoSingletonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by ldy on 2017/3/10.
 */
public class TestScope {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScopeConfig.class);
        DemoSingletonService singletonService1 = applicationContext.getBean(DemoSingletonService.class);
        DemoSingletonService singletonService2 = applicationContext.getBean(DemoSingletonService.class);
        DemoPrototypeService prototypeService1 = applicationContext.getBean(DemoPrototypeService.class);
        DemoPrototypeService prototypeService2 = applicationContext.getBean(DemoPrototypeService.class);
        System.out.println("singletonService1.equals(singletonService2):"+singletonService1.equals(singletonService2));
        System.out.println("prototypeService1.equals(prototypeService2):"+prototypeService1.equals(prototypeService2));
        applicationContext.close();
    }
}
