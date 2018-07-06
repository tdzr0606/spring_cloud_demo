package com.nature.jet.dataServer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 数据服务客户端
 * spring_cloud_demo
 * DataServerApplication
 *
 * @Author: 竺志伟
 * @Date: 2018-06-11 20:42
 */
// Mybatis 扫描
@MapperScan(value = "com.nature.jet.dataServer.mapper.**")
@EnableDiscoveryClient
@SpringBootApplication
public class DataServerApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(DataServerApplication.class, args);
    }
}
