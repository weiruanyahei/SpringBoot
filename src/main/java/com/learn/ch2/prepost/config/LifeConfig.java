package com.learn.ch2.prepost.config;

import com.learn.ch2.prepost.service.BeanWayService;
import com.learn.ch2.prepost.service.JSR250WayService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ldy on 2017/3/13.
 */
@Configuration
@ComponentScan("com.learn.ch2.prepost.service")
public class LifeConfig {
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public BeanWayService beanWayService(){
        return new BeanWayService();
    }
    @Bean
    public JSR250WayService jsr250WayService(){
        return new JSR250WayService();
    }
}
