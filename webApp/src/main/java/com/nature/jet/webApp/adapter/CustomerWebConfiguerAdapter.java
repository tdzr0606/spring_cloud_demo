package com.nature.jet.webApp.adapter;

import com.nature.jet.webApp.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 拦截器配置
 * springboot
 * CustomerWebConfiguerAdapter
 * Author: 竺志伟
 * Date:   2017-03-30 14:10
 */
@Configuration
public class CustomerWebConfiguerAdapter extends WebMvcConfigurerAdapter
{
    /**
     * 添加拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        // 对所有后台访问进行拦截
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/web/**");
    }

}
