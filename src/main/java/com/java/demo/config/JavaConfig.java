package com.java.demo.config;

import com.java.demo.service.FunctionService;
import com.java.demo.service.UseFunctionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
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
