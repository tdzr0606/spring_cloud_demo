package com.nature.jet.webApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * spring_cloud_demo
 * WebAppAplication
 *
 * @Author: 竺志伟
 * @Date: 2018-06-11 22:28
 */
@EnableCircuitBreaker  //熔断器
@EnableHystrixDashboard // 熔断器监控
@EnableFeignClients(basePackages = "com.nature.jet.webApp.server.**")  // 开启声明 调用服务,默认添加 ribbon 负载均衡
@EnableDiscoveryClient  // 声明注册服务客户端
@SpringBootApplication
@ServletComponentScan(basePackages = {"com.nature.jet.webApp.filter"})// 过滤器 扫描
public class WebAppAplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(WebAppAplication.class, args);
    }
}
