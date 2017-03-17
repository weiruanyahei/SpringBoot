package com.learn.ch3.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by ldy on 2017/3/17.
 */
public class ConditionalTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
        System.out.println("当前系统名称："+context.getEnvironment().getProperty("os.name"));
        ListCMDService listCMDService = context.getBean(ListCMDService.class);
        System.out.println("在当前系统查看当前目录文件清单命令为："+listCMDService.listCMD());
    }
}
