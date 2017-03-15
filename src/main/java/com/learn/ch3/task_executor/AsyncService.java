package com.learn.ch3.task_executor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by ldy on 2017/3/15.
 */
@Service
public class AsyncService {
    @Async
    public void outputIndex(int i){
        System.out.println("normal:"+i);
    }
    @Async
    public void outputIndexPlus(int i){
        System.out.println("plus:"+(i+1));
    }
}
