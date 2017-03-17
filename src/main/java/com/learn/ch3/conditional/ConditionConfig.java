package com.learn.ch3.conditional;

import com.learn.ch3.conditional.condition.LinuxCondition;
import com.learn.ch3.conditional.condition.WindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ldy on 2017/3/17.
 */
@Configuration
public class ConditionConfig {
    @Bean
    @Conditional(WindowsCondition.class)
    public ListCMDService listWindowsCMDService(){
        return new ListWindowsCMDService();
    }
    @Bean
    @Conditional(LinuxCondition.class)
    public ListCMDService listLinuxCMDService(){
        return new ListLinuxCMDService();
    }
}
