package com.nature.jet.webApp.server.system;

import com.nature.jet.webApp.pojo.system.Admin;
import com.nature.jet.webApp.util.Page;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * spring_cloud_demo
 * AdminService
 *
 * @Author: 竺志伟
 * @Date: 2018-06-11 22:30
 */
@FeignClient(name = "DATA-SERVER",fallback = AdminServerFallBack.class)
public interface AdminServer
{
    @RequestMapping(value = "/admin/listPage")
    Page<Admin> listPage();
}
