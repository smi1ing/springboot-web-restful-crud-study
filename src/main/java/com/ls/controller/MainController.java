package com.ls.controller;

import com.ls.exception.UserNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    /**
     * 访问首页
     * @return
     */
//    @RequestMapping("/")
//    public String index(){
//        return "login";
//    }


    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user){
        if(user.equals("aaa")){
            throw new UserNotFoundException();
        }
        return "hello,world";
    }


    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("hello","HelloWorld!");
        return "success";
    }
}
