package com.learn.web.converter;

import com.learn.web.controller.model.DemoObj;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 扩展抽象类AbstractHttpMessageConverter 来实现自定义的HttpMessageConverter
 * Created by ldy on 2017/4/4.
 */
public class LearnMessageConverter extends AbstractHttpMessageConverter<DemoObj> {

    public LearnMessageConverter() {
        //新建一个自定义的媒体类型application/x-learn
        super(new MediaType("application","x-learn", Charset.forName("utf8")));
    }

    /**
     * 只处理DemoObj这个类
     * @param clazz
     * @return
     */
    @Override
    protected boolean supports(Class clazz) {
        return DemoObj.class.isAssignableFrom(clazz);
    }

    /**
     * 处理请求的数据。
     * @param clazz
     * @param inputMessage
     * @return
     * @throws IOException
     * @throws HttpMessageNotReadableException
     */
    @Override
    protected DemoObj readInternal(Class<? extends DemoObj> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        String inputMsgStr = StreamUtils.copyToString(inputMessage.getBody(),Charset.forName("utf8"));
        String tempArr[] = inputMsgStr.split("-");

        return new DemoObj(new Long(tempArr[0]),tempArr[1]);
    }

    /**
     * 规定如何输出数据到response。
     * @param obj
     * @param outputMessage
     * @throws IOException
     * @throws HttpMessageNotWritableException
     */
    @Override
    protected void writeInternal(DemoObj obj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        String outStr = "Hello : "+obj.getId()+"-"+obj.getName();
        outputMessage.getBody().write(outStr.getBytes());
    }
}
