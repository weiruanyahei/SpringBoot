package com.learn.ch4;

import com.learn.config.MvcConfig;
import com.learn.service.DemoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by ldy on 2017/3/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MvcConfig.class)
/** 用来声明加载的ApplicationContext是一个WebApplicationContext。它的属性指定的是Web资源的位置，
 * 默认"src/main/webapp"，此处为："src/main/resources" */
@WebAppConfiguration("src/main/resources")
public class TestControllerIntegrationTests {
    /** 模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(webApplicationContext).build()初始化*/
    private MockMvc mockMvc;
    /* 在测试用例中注入Spring的Bean */
    @Autowired
    private DemoService demoService;

    @Autowired
    WebApplicationContext webApplicationContext;
    //可注入模拟的http session http request
    @Autowired
    MockHttpSession session;
    @Autowired
    MockHttpServletRequest request;

    @Before //在测试开始前进行的初始化工作
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testNormalController() throws Exception {
        this.mockMvc.perform(get("/normal"))//模拟向/normal进行get请求
                .andExpect(status().isOk())//预期控制返回状态为200
                .andExpect(view().name("page"))//预期视图名称为page
                .andExpect(forwardedUrl("/WEB-INF/classes/views/page.jsp"))//预期页面转向的真正路径
                .andExpect(model().attribute("msg", demoService.sayHello("kobe")));//预期model里的值
    }

    @Test
    public void testRestController() throws Exception {
        this.mockMvc.perform(get("/testRest"))//模拟向/testRest进行get请求
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))//预期返回值的媒体类型
                .andExpect(content().string(demoService.sayHello("kobe")));//预期返回值的内容
    }
}
