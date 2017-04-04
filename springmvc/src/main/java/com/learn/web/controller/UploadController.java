package com.learn.web.controller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by ldy on 2017/3/28.
 */
@Controller
public class UploadController {
    /**
     * available to subclasses.
     */
    protected final Log logger = LogFactory.getLog(getClass());

    /**
     * 上传实现Demo
     * @param file 该参数一定要注意：如果请求中携带的name名称与参数不匹配时，需要使用@RequestParam("")与实际参数名绑定
     * @param request
     * @return
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST,consumes = "multipart/form-data")
    public @ResponseBody String upload( MultipartFile file,HttpServletRequest request) {
        MultipartFile tempFile = file;

        //应用程序生成文件路径
        String rootPath = "/shanghai/myself_resource/temp";//request.getServletContext().getRealPath("/");
        if (logger.isInfoEnabled()) {
            logger.info("rootPath:" + rootPath);
        }
        try{
            FileUtils.writeByteArrayToFile(new File(rootPath,tempFile.getOriginalFilename()), tempFile.getBytes());
            return "ok";
        }catch (IOException e){
            e.printStackTrace();
            return "error";
        }
    }
}
