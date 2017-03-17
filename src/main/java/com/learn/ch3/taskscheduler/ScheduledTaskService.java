package com.learn.ch3.taskscheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ldy on 2017/3/15.
 */
@Service
public class ScheduledTaskService {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void fixRateExe() {
        System.out.println("每隔5秒执行一次："+simpleDateFormat.format(new Date()));
    }
    @Scheduled(cron = "0 29 11 ? * *")
    public void fixTimeExe(){
        System.out.println("固定时间执行任务："+simpleDateFormat.format(new Date()));
    }
}
