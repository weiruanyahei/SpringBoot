package com.learn.ch1.aop;

import com.learn.ch1.aop.annotation.Action;
import org.springframework.stereotype.Service;

/**
 * Created by ldy on 2017/3/9.
 */
@Service
public class DemoAnnotationService {
    @Action(name = "基于注解式拦截的add操作。")
    public void add(){

    }
}
