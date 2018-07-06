package com.nature.jet.eurekaServer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 微服务 注册服务器
 * spring_cloud_demo
 * EurekaServerApplication
 *
 * @Author: 竺志伟
 * @Date: 2018-06-11 20:29
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication
{
    public static void main(String[] args)
    {
        new SpringApplicationBuilder(EurekaServerApplication.class).web(true).run(args);
    }
}
