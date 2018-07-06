package com.nature.jet.dataServer.service.web;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.nature.jet.dataServer.mapper.web.AdminMapper;
import com.nature.jet.dataServer.pojo.web.Admin;
import com.nature.jet.dataServer.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * springboot
 * AdminServiceImpl
 * Author: 竺志伟
 * Date:   2017-04-02 21:24
 */
@Service
public class AdminService
{
    @Autowired
    AdminMapper adminMapper;


    public Page<Admin> findListByPage(Integer nowPage, Integer pageSize, String key)
    {
        return new Page(PageHelper.startPage(nowPage, pageSize).doSelectPageInfo(new ISelect()
        {
            @Override
            public void doSelect()
            {
                adminMapper.list(key);
            }
        }));
    }


    public Admin findById(Integer id)
    {
        return adminMapper.findById(id);
    }

    public boolean add(Admin admin)
    {
        return adminMapper.add(admin) == 1;
    }

    public boolean modify(Admin admin)
    {
        return adminMapper.modify(admin) == 1;
    }

    public boolean deleteById(Integer id)
    {
        return adminMapper.deleteById(id) == 1;
    }


    public Admin login(String loginName, String loginPass)
    {
        Map<String, String> map = new HashMap<>();
        map.put("loginName", loginName);
        map.put("password", loginPass);
        return adminMapper.login(map);
    }

    public boolean loginNameCheck(String loginName)
    {
        return adminMapper.loginNameCheck(loginName) < 1;
    }

    public boolean modifyPass(Integer id, String loginPassN)
    {
        Admin admin = new Admin();
        admin.setId(id);
        admin.setPassword(loginPassN);
        return adminMapper.modifyPassword(admin) == 1;
    }

    public void deleteByIds(String[] ids)
    {
        adminMapper.deleteByIds(ids);
    }

}
