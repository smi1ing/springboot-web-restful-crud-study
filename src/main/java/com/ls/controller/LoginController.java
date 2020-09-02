package com.ls.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller
public class LoginController {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
//    @RequestMapping( value = "/user/login", method = RequestMethod.POST)
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpServletRequest request){
        if(!StringUtils.isEmpty(username) && "123".equals(password)){
            //登陆成功
            //刷新的时候，页面会重复提交表单，为了防止表单重复提交，进行重定向到主页

            request.getSession().setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            //登录失败
            map.put("ls","用户名或密码失败");
            return "login";
        }
    }
}
