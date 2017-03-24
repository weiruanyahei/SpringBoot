package com.learn.web.controller;

import com.learn.web.controller.model.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ldy on 2017/3/24.
 */
@Controller//声明此类为一个构造器
@RequestMapping("/anno")//映射此类的统一访问路径
public class DemoJacksonController {
    @RequestMapping(produces = "application/json; charset=UTF-8")
    public @ResponseBody String index(HttpServletRequest request){
        return "url:"+request.getRequestURL()+" can access";
    }

    @RequestMapping(value = "getxml",produces = "application/json; charset=UTF-8")
    public @ResponseBody
    DemoObj getXML(){
        return new DemoObj(123L,"KOBO");
    }

}
