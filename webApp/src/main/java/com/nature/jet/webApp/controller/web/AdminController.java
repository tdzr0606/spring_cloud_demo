package com.nature.jet.webApp.controller.web;

import com.nature.jet.webApp.pojo.web.Admin;
import com.nature.jet.webApp.server.web.AdminServer;
import com.nature.jet.webApp.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring_cloud_demo
 * AdminController
 *
 * @Author: 竺志伟
 * @Date: 2018-06-11 22:34
 */
@RestController
@RequestMapping("/web/admin")
public class AdminController
{
    @Autowired
    private AdminServer adminServer;


    @RequestMapping(value = "/listPage")
    public Page<Admin> listPage()
    {
        return adminServer.listPage();
    }
}