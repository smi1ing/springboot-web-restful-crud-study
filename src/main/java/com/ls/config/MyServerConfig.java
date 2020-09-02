package com.ls.config;


import com.ls.filter.MyFilter;
import com.ls.litener.MyListener;
import com.ls.servlet.MyServlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyServerConfig {

    /**
     * 由于SpringBoot默认是以jar包的方式启动嵌入式的Servlet容器来启动SpringBoot的web应用，没有web.xml文件。
     * 所以要注册servlet三大组件(Servlet,Filter,Listener)需要一下三个类
     * Servlet: ServletRegistrationBean
     * Filter: FilterRegistrationBean
     * Listener: ServletListenerRegistrationBean
     * @return
     */
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new MyServlet(), "/myServlet");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }

    /**
     * Filter组件的注册
     * @return
     */
    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean<MyListener>(new MyListener());
        return servletListenerRegistrationBean;
    }


    /**
     * 通过WebServerFactoryCustomizer类，来进行嵌入式servlet容器的相关配置，优先级高于配置文件
     * @return
     */
    @Bean
    public WebServerFactoryCustomizer webServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8081);
            }
        };
    }

}
