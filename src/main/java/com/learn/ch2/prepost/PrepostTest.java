package com.learn.ch2.prepost;

import com.learn.ch2.prepost.config.LifeConfig;
import com.learn.ch2.prepost.service.BeanWayService;
import com.learn.ch2.prepost.service.JSR250WayService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by ldy on 2017/3/13.
 */
public class PrepostTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeConfig.class);
        context.getBean(BeanWayService.class);
        context.getBean(JSR250WayService.class);
        context.close();
    }
}
