package com.learn.ch3.for_test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by ldy on 2017/3/22.
 */
@Configuration
public class FortestConfig {
    @Bean
    @Profile("dev")
    public TestBean devTestBean() {
        return new TestBean("from dev profile");
    }

    @Bean
    @Profile("pro")
    public TestBean proTestBean() {
        return new TestBean("from pro profile");
    }
}
