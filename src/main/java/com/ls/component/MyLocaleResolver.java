package com.ls.component;


import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


/**
 * 在链接上进行国际化跳转
 */
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取请求参数中的语言
        String str = request.getParameter("l");
        //没带区域信息参数就用系统默认的
        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(str)){
            //以_分隔（语言代码_国家代码）
            String[] split = str.split("_");
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
