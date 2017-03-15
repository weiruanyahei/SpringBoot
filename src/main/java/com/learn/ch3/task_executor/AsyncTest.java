package com.learn.ch3.task_executor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by ldy on 2017/3/15.
 */
public class AsyncTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig
        .class);
        AsyncService asyncService = context.getBean(AsyncService.class);
        for(int i=1;i<11;i++){
            asyncService.outputIndex(i);
            asyncService.outputIndexPlus(i);
        }
        //context.
        context.close();
    }
}
