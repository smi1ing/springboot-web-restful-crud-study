package com.ls.controller;


import com.ls.exception.UserNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 我自己创建的异常处理器
 * @author ls
 */
@ControllerAdvice
public class MyExceptionHandler {

    /**
     * 1.浏览器和客户端返回的都是json数据
     * @param e
     * @return
     */
//    @ResponseBody
//    @ExceptionHandler(UserNotFoundException.class)
//    public Map<String, Object> handleException(Exception e){
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("code","user.notexit");
//        map.put("message",e.getMessage());
//        return map;
//    }


    /**
     * 2.转发到/error页面进行 自适应 响应效果处理(即浏览器显示页面，客户端显示json数据)
     * @param e
     * @return
     */
    @ExceptionHandler(UserNotFoundException.class)
    public String handleException(Exception e, HttpServletRequest request){

        Map<String, Object> map = new HashMap<>();

        //传入自己的错误状态码
        request.setAttribute("javax.servlet.error.status_code",500);
        //添加自己的异常处理器的数据
        map.put("code","user.notexit");
        map.put("message","用户没找到");
        request.setAttribute("ext",map);
        return "forward:/error";
    }
}
