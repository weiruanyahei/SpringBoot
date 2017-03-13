package com.learn.ch2.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by ldy on 2017/3/13.
 */
@Configuration
public class ProfileConfig {
    @Bean
    @Profile("dev")
    public Demo devDemo(){
        Demo demo = new Demo();
        demo.setCurrEnv("当前为开发环境。");
        return demo;
    }

    @Bean
    @Profile("prod")
    public Demo prodDemo() {
        Demo demo = new Demo();
        demo.setCurrEnv("当前为生产环境。");
        return demo;
    }
}
