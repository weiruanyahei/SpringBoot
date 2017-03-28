package com.learn.web.controller;

import com.learn.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ldy on 2017/3/28.
 */
@Controller
public class NormalController {
    @Autowired
    DemoService demoService;
    @RequestMapping("/normal")
    public String testPage(Model model){
        model.addAttribute("msg",demoService.sayHello("kobe"));
        return "page";
    }
}
