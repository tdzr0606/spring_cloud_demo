package com.nature.jet.dataServer.endPoint.web;

import com.nature.jet.dataServer.pojo.web.Admin;
import com.nature.jet.dataServer.service.web.AdminService;
import com.nature.jet.dataServer.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Page<Admin> listPage(@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
                                @RequestParam(value = "rows", required = true, defaultValue = "40") Integer rows,
                                @RequestParam(value = "key", required = false, defaultValue = "") String key)
    {
        return adminService.findListByPage(page, rows, key);
    }

    @RequestMapping(value = "/add")
    public boolean add(@RequestBody Admin admin)
    {
        return adminService.add(admin);
    }


    @RequestMapping(value = "/modify")
    public boolean modify(@RequestBody Admin admin)
    {
        return adminService.modify(admin);
    }

    @RequestMapping(value = "/deleteByIds")
    public void deleteByIds(@RequestBody String[] ids)
    {
        adminService.deleteByIds(ids);
    }

    @RequestMapping(value = "/info")
    public Admin findById(@RequestParam(value = "id", required = true, defaultValue = "0") Integer id)
    {
        return adminService.findById(id);
    }

    @RequestMapping(value = "/loginNameCheck")
    public boolean loginNameCheck(@RequestParam(value = "loginName", required = false, defaultValue = "") String loginName)
    {
        return adminService.loginNameCheck(loginName);
    }

    @RequestMapping(value = "/modifyPass")
    public boolean modifyPass(@RequestParam(value = "id", required = true, defaultValue = "0") Integer id,
                              @RequestParam(value = "newPass", required = true, defaultValue = "") String newPass)
    {
        return adminService.modifyPass(id, newPass);
    }
}
