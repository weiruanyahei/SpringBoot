package com.learn.web.controller;

import com.learn.web.controller.model.DemoObj;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ldy on 2017/4/4.
 */
@RestController
public class LearnMsgConverterController {
    @RequestMapping(value = "/converter",method = RequestMethod.POST,produces = "application/x-learn")
    public DemoObj converter(@RequestBody DemoObj obj){
        return obj;
    }
}
