package com.nature.jet.dataServer.endPoint.system;

import com.nature.jet.dataServer.pojo.system.Admin;
import com.nature.jet.dataServer.service.system.AdminService;
import com.nature.jet.dataServer.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping(value = "/listPage")
    public Page<Admin> listPage()
    {
        return adminService.findListByPage(1,10,"");
    }
}
