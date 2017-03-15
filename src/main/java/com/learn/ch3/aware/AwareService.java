package com.learn.ch3.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by ldy on 2017/3/14.
 */
@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {
    private String beanName;
    private ResourceLoader resourceLoader;
    @Override
    public void setBeanName(String name) {
        this.beanName = name;
        //System.out.println("当前Bean的名称：" + name);
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        /*Resource resource = resourceLoader.getResource("classpath:/ch3_aware_test/test.txt");
        try {
            String resourceStr = IOUtils.toString(resource.getInputStream(),"utf8");
            System.out.println("加载文本字符串内容：");
            System.out.println(resourceStr);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
    public void output(){
        System.out.println("当前Bean的名称：" + this.beanName);
        Resource resource = resourceLoader.getResource("classpath:/ch3_aware_test/test.txt");
        try {
            String resourceStr = IOUtils.toString(resource.getInputStream(),"utf8");
            System.out.println("加载文本字符串内容：");
            System.out.println(resourceStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
