package com.learn.config;

import com.learn.web.converter.LearnMessageConverter;
import com.learn.web.interceptor.WasteTimePerRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

/**
 * Created by ldy on 2017/3/23.
 *
 */
@Configuration
@EnableWebMvc//开启一些默认配置，如一些ViewResolver或者MessageConverter等;同时，若不包含此注解时，重写WebMvcConfigurerAdapter方法无效
@ComponentScan("com.learn")
public class MvcConfig extends WebMvcConfigurerAdapter{
    //
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }
    //每次请求完成消耗时长
    @Bean
    public WasteTimePerRequestInterceptor wasteTimePerRequestInterceptor(){
        return new WasteTimePerRequestInterceptor();
    }
    //文件上传支持
    @Bean("multipartResolver")
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(1000000);
        return multipartResolver;
    }
    //自定义消息转换器
    @Bean
    public LearnMessageConverter messageConverter(){
        return new LearnMessageConverter();
    }



    /**
     * 静态资源映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/assets/**")//对外暴露的访问路径
                .addResourceLocations("classpath:/assets/");//文件放置的位置
    }

    /**
     * 拦截器配置
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(wasteTimePerRequestInterceptor());
    }

    /**
     * 简化跳转配置
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index/home").setViewName("index");
        registry.addViewController("/toUpload").setViewName("upload");
    }

    /**
     * 不忽略"."后面的参数
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(Boolean.FALSE);
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(messageConverter());
    }
}
