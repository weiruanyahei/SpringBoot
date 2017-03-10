package com.learn.ch2.el.config;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by ldy on 2017/3/10.
 */
@Configuration
@PropertySource("classpath:/ch2_el_test/Test.properties")
@ComponentScan("com.learn.ch2.el.pojo")
public class ELConfig {
    @Value("我只是一个开始。")
    private String normal;
    @Value("#{demoStrPojo.msg}")
    private String otherMsg;
    @Value("classpath:/ch2_el_test/Test.txt")
    private File testFile;
    @Value("#{systemProperties['os.arch']}")
    private String osArch;
    @Value("#{systemProperties['os.name']}")
    private String osName;
    @Value("#{systemProperties['os.version']}")
    private String osVersion;
    @Value("${learn.phase}")
    private String learnPhase;
    @Value("https://www.baidu.com")
    private Resource resource;
    @Value("#{ T(java.lang.Math).random()*100.0}")
    private double randomNumber;
    @Autowired
    private Environment environment;

    public void outPut() throws Exception {
        System.out.println("normal:"+normal);
        System.out.println("otherMsg:"+otherMsg);
        System.out.println("testFile:"+ IOUtils.toString(new FileInputStream(testFile),"utf8"));
        System.out.println("osArch:"+osArch);
        System.out.println("osName:"+osName);
        System.out.println("osVersion:"+osVersion);
        System.out.println("learnPhase:"+learnPhase);
        System.out.println("resource:"+IOUtils.toString(resource.getInputStream(),"utf8"));
        System.out.println("randomNumber:"+randomNumber);
        System.out.println("environment:"+environment.getProperty("learn.currPage"));
    }
}
