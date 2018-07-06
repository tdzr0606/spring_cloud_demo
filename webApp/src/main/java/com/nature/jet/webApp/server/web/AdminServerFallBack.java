package com.nature.jet.webApp.server.web;

import com.nature.jet.webApp.pojo.web.Admin;
import com.nature.jet.webApp.util.Page;
import org.springframework.stereotype.Component;

/**
 * spring_cloud_demo
 * AdminServiceFailBack
 *
 * @Author: 竺志伟
 * @Date: 2018-06-11 22:30
 */
@Component
public class AdminServerFallBack  implements AdminServer
{
    @Override
    public Admin login(String loginName, String password)
    {
        return null;
    }

    @Override
    public Page<Admin> listPage()
    {
        return new Page<>();
    }
}
