package com.learn.ch1.aop.annotation;

import java.lang.annotation.*;

/**
 * Created by ldy on 2017/3/9.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}
