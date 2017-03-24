package com.learn.ch3.for_test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ldy on 2017/3/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {FortestConfig.class})
@ActiveProfiles("pro")
public class DemoBeanIntegrationTests {
    @Autowired
    private TestBean testBean;
    @Test
    public void demoTestBean(){
        String expect = "from dev profile";
        String actual = testBean.getContent();
        //System.out.println(actual);
        Assert.assertEquals(expect,actual);
    }
}
