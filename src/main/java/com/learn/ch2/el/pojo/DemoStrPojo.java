package com.learn.ch2.el.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by ldy on 2017/3/10.
 */
@Component
public class DemoStrPojo {
    @Value("我仅代表演示的常规字符串")
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
