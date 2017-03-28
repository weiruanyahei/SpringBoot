package com.learn.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ldy on 2017/3/28.
 */
@RestController
public class UploadController {
    /** available to subclasses. */
    protected final Log logger = LogFactory.getLog(getClass());
    @RequestMapping(method = {RequestMethod.POST},value = "/upload")
    public String upload(MultipartFile multipartFile, HttpServletRequest request){
        if(logger.isInfoEnabled()){
            ClassPathResource resource = new ClassPathResource("/");
            logger.info("resource.getPath():"+resource.getPath());
        }
        return "ok";
    }
}
