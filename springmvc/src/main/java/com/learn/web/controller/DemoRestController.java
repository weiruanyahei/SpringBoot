package com.learn.web.controller;

import com.learn.web.controller.model.DemoObj;
import com.learn.web.start.GetHttpServletRequestWrapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * Created by ldy on 2017/3/24.
 */
@RestController//声明此类为一个构造器
@RequestMapping("/rest")//映射此类的统一访问路径
public class DemoRestController {
    /**
     * Logger available to subclasses
     */
    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(produces = "text/plain; charset=UTF-8")//3
    public String index(HttpServletRequest request) {//4
        return "url:" + request.getRequestURL() + " can access";
    }

    @RequestMapping(value = "/pathvar/{str}", produces = "text/plain; charset=UTF-8")//5
    public String demoPathVar(@PathVariable String str, HttpServletRequest request) {
        return request.getRequestURL() + "str:" + str;
    }

    @RequestMapping(value = "/requestParam", produces = "text/plain; charset=UTF-8")//6
    public String passRequestParam(Long id, HttpServletRequest request) {
        return "id:" + id;
    }

    @RequestMapping(value = "/obj", produces = "application/json; charset=UTF-8")//7
    @ResponseBody//8
    public String passObj(DemoObj obj, HttpServletRequest request) {
        return "obj id:" + obj.getId() + " , obj name:" + this.convert(obj.getName());
    }

    @RequestMapping(value = {"/path1", "/path2"}, produces = "text/plain; charset=UTF-8")//9
    public String remove(HttpServletRequest request) {
        return "url : " + request.getRequestURL() + " can access.";
    }

    @RequestMapping(value = "/getJson", produces = "application/json; charset=UTF-8")
    public DemoObj getJson() {
        return new DemoObj(123L, "KOBO");
    }

    @RequestMapping(value = "/getXml", produces = {"application/xml; charset=UTF-8"})
    public DemoObj getXml() {
        return new DemoObj(123L, "KOBO");
    }

    public String convert(String target) {
        if (logger.isDebugEnabled()) {
            logger.debug("编码转换之前：" + target);
        }
        try {
            return new String(target.trim().getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return target;
        }
    }

}
