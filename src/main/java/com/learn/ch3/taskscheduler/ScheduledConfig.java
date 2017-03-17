package com.learn.ch3.taskscheduler;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by ldy on 2017/3/16.
 */
@Configuration
@EnableScheduling
@ComponentScan("com.learn.ch3.taskscheduler")
public class ScheduledConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(ScheduledConfig.class);

    }
}
