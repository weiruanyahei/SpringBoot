package com.learn.web.start;

/**
 * Created by ldy on 2017/3/24.
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class GetHttpServletRequestWrapper extends HttpServletRequestWrapper {
    /** Logger available to subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    private String charset = "UTF-8";

    public GetHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    /**
     * 实际上就是调用被包装的请求对象的getParameter方法获得参数，然后再进行编码转换
     */
    /*public String getParameter(String name) {



        String value = super.getParameter(name);
        value = value == null ? null : convert(value);
        return value;
    }*/
    Map<String, String[]> params = null;

    public GetHttpServletRequestWrapper(HttpServletRequest request,String charset) {
        super(request);
        params = new HashMap(request.getParameterMap());
        this.charset = charset;
    }

    public void setParameter(String key,String value){
        params.put(key, new String[]{value});
    }
    public void setParameter(String key,String[] values){
        params.put(key, values);
    }

    @Override
    public String getParameter(String name) {
        Object v = params.get(name);
        if (v == null) {
            return null;
        } else if (v instanceof String[]) {
            String[] strArr = (String[]) v;
            if (strArr.length > 0) {
                return strArr[0];
            } else {
                return null;
            }
        } else {
            return convert(v.toString());
        }
    }

    public String convert(String target) {
        if (logger.isDebugEnabled()) {
            logger.debug("编码转换之前：" + target);
        }
        try {
            return new String(target.trim().getBytes("ISO-8859-1"), charset);
        } catch (UnsupportedEncodingException e) {
            return target;
        }
    }

}