package com.learn.ch2.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by ldy on 2017/3/13.
 */
public class ProfileTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ProfileConfig.class);
        context.getEnvironment().setActiveProfiles("prod");
        context.refresh();
        Demo demo = context.getBean(Demo.class);
        System.out.println(demo.getCurrEnv());
        context.close();
    }
}
