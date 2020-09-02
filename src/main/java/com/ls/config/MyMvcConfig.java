package com.ls.config;


import com.ls.component.LoginHandlerInterceptor;
import com.ls.component.MyLocaleResolver;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 使用WebMvcConfigurer扩展SpringMVC的功能
 * 既保留了所有的自动配置，也能用我们扩展的配置
 * @author ls
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    /**
     * 视图映射
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        等同于编写controller：浏览器发送/testMVC请求，跳转到页面success
        registry.addViewController("/testMVC").setViewName("success");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");

    }

    /**
     * 国际化配置
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    /**
     * 登录验证拦截器配置
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
        .excludePathPatterns("/index.html","/","/user/login","/asserts/**");
    }



}
