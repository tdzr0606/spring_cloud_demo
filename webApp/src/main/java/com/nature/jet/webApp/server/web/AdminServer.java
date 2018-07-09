package com.nature.jet.webApp.server.web;

import com.nature.jet.webApp.pojo.web.Admin;
import com.nature.jet.webApp.util.Page;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * admin 数据服务 接口调用
 * spring_cloud_demo
 * AdminService
 *
 * @Author: 竺志伟
 * @Date: 2018-06-11 22:30
 */
@FeignClient(name = "DATA-SERVER", fallback = AdminServerFallBack.class)
public interface AdminServer
{
    @RequestMapping(value = "/admin/login")
    Admin login(@RequestParam(value = "loginName", defaultValue = "", required = true) String loginName,
                @RequestParam(value = "password", defaultValue = "", required = true) String password);

    @RequestMapping(value = "/admin/listPage")
    Page<Admin> listPage(@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
                         @RequestParam(value = "rows", required = true, defaultValue = "40") Integer rows,
                         @RequestParam(value = "key", required = false, defaultValue = "") String key);

    @RequestMapping(value = "/admin/loginNameCheck")
    boolean loginNameCheck(@RequestParam(value = "loginName", required = true, defaultValue = "") String loginName);

    @RequestMapping(value = "/admin/add")
    boolean add(Admin admin);

    @RequestMapping(value = "/admin/modify")
    boolean modify(Admin admin);

    @RequestMapping(value = "/admin/deleteByIds")
    void deleteByIds(String[] ids);

    @RequestMapping(value = "/admin/info")
    Admin findById(@RequestParam(value = "id", required = true, defaultValue = "0") Integer id);

    @RequestMapping(value = "/admin/modifyPass")
    boolean modifyPass(@RequestParam(value = "id", required = true, defaultValue = "0") Integer id,
                       @RequestParam(value = "newPass", required = true, defaultValue = "") String newPass);

}
