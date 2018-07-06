package com.nature.jet.dataServer.endPoint.web;

import com.nature.jet.dataServer.pojo.web.Admin;
import com.nature.jet.dataServer.service.web.AdminService;
import com.nature.jet.dataServer.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring_cloud_demo
 * AdminEndPoint
 *
 * @Author: 竺志伟
 * @Date: 2018-06-11 22:24
 */
@RestController
@RequestMapping("/admin")
public class AdminEndPoint
{
    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/login")
    public Admin login(@RequestParam(value = "loginName", required = true, defaultValue = "") String loginName,
                       @RequestParam(value = "password", required = true, defaultValue = "") String password)
    {
        return adminService.login(loginName, password);
    }

    @RequestMapping(value = "/listPage")
    public Page<Admin> listPage()
    {
        return adminService.findListByPage(1, 10, "");
    }
}
