package com.learn.ch1.aop;

import com.learn.ch1.aop.annotation.Action;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by ldy on 2017/3/9.
 */
@Aspect
//让此切面成为spring容器管理的bean
@Component
public class LogAspect {
    //声明切点
    @Pointcut("@annotation(com.learn.ch1.aop.annotation.Action)")
    public void getAnnotation() {
    }

    @After("getAnnotation()")
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("基于注解拦截：" + action.name());
    }

    /**
     * 首先让我们来了解下AspectJ类型匹配的通配符：
     *   *：匹配任何数量字符；
     *   ..：匹配任何数量字符的重复，如在类型模式中匹配任何数量子包；而在方法参数模式中匹配任何数量参数。
     *   +：匹配指定类型的子类型；仅能作为后缀放在类型模式后边。
     * @param joinPoint
     */
    @Before("execution(* com.learn.ch1.aop.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println("方法规则式拦截，"+method.getName());
    }
}
