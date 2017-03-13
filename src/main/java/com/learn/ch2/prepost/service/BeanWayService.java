package com.learn.ch2.prepost.service;

/**
 * Created by ldy on 2017/3/13.
 */
public class BeanWayService {
    public void init(){
        System.out.println("基于Bean方式的init方法被执行。");
    }

    public BeanWayService() {
        System.out.println("基于Bean方式的实例被创建。");
    }
    public void destroy(){
        System.out.println("基于Bean方式的destroy方法被执行。");
    }
}
