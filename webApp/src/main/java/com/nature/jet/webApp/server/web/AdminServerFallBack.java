package com.nature.jet.webApp.server.web;

import com.nature.jet.webApp.pojo.web.Admin;
import com.nature.jet.webApp.util.Page;
import org.springframework.stereotype.Component;

/**
 * 用户管理 服务熔断错误处理
 * spring_cloud_demo
 * AdminServiceFailBack
 *
 * @Author: 竺志伟
 * @Date: 2018-06-11 22:30
 */
@Component
public class AdminServerFallBack implements AdminServer
{
    @Override
    public Admin login(String loginName, String password)
    {
        return null;
    }

    @Override
    public Page<Admin> listPage(Integer page, Integer rows, String key)
    {
        return new Page<>();
    }

    @Override
    public boolean loginNameCheck(String loginName)
    {
        return false;
    }

    @Override
    public boolean add(Admin admin)
    {
        return false;
    }

    @Override
    public boolean modify(Admin admin)
    {
        return false;
    }

    @Override
    public void deleteByIds(String[] ids)
    {

    }

    @Override
    public Admin findById(Integer id)
    {
        return null;
    }

    @Override
    public boolean modifyPass(Integer id, String newPass)
    {
        return false;
    }
}
