package com.learn.ch2.prepost.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by ldy on 2017/3/13.
 */
public class JSR250WayService {
    @PostConstruct
    public void init(){
        System.out.println("基于JSR250方式的init方法被执行。");
    }

    public JSR250WayService() {
        System.out.println("基于JSR250方式的实例被创建。");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("基于JSR250方式的destroy方法被执行。");
    }
}
