package com.nature.jet.webApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * spring_cloud_demo
 * WebAppAplication
 *
 * @Author: 竺志伟
 * @Date: 2018-06-11 22:28
 */
@EnableCircuitBreaker  //熔断器
@EnableHystrixDashboard // 熔断器监控
@EnableFeignClients(basePackages = "com.nature.jet.webApp.server.**")  // 开启声明 调用服务
@EnableDiscoveryClient
@SpringBootApplication
// 过滤器 扫描
@ServletComponentScan(basePackages={"com.nature.jet.webApp.filter"})
public class WebAppAplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(WebAppAplication.class, args);
    }
}
