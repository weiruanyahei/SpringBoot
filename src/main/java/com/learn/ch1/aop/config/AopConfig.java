package com.learn.ch1.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by ldy on 2017/3/9.
 */
@Configuration
@ComponentScan("com.learn.ch1.aop")
//开启spring对Aspectj代理的支持
@EnableAspectJAutoProxy
public class AopConfig {
}
