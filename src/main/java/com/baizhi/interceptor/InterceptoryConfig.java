package com.baizhi.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class InterceptoryConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private MyInterceptory myInterceptory;

}
