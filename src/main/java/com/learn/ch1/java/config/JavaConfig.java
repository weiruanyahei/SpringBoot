package com.learn.ch1.java.config;

import com.learn.ch1.java.service.FunctionService;
import com.learn.ch1.java.service.UseFunctionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ldy on 2017/3/9.
 */
@Configuration
public class JavaConfig {
    @Bean
    public FunctionService getFunctionService(){
        return new FunctionService();
    }
    @Bean
    public UseFunctionService getUseFunctionService(){
        UseFunctionService useFunctionService = new UseFunctionService();
        useFunctionService.setService(getFunctionService());
        return useFunctionService;
    }
}
