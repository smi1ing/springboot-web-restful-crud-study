package com.ls.component;


import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 给容器中加入我们自己定义的ErrorAttributes
 * 添加字段
 * @author ls
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    /**
     * 返回的map就是页面和json能获取到的所有字段
     * @param webRequest
     * @param options
     * @return
     */
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, options);
        //通过定制ErrorAttributes添加的数据
        map.put("city","hangzhou");
        //获取自己的异常处理器携带的数据,0表示从request域中获取
        Map<String, Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", 0);
        map.put("ext",ext);
        return map;
    }
}
