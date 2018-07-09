package com.nature.jet.webApp.controller;

import com.nature.jet.webApp.controller.basic.BaseController;
import com.nature.jet.webApp.pojo.web.Admin;
import com.nature.jet.webApp.server.web.AdminServer;
import com.nature.jet.webApp.util.CommonResult;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;

/**
 * spring_cloud_demo
 * IndexController
 *
 * @Author: 竺志伟
 * @Date: 2018-06-12 08:51
 */
@Controller
public class IndexController extends BaseController
{

    @Autowired
    private AdminServer adminServer;

    /**
     * 进入首页
     * To index model and view.
     *
     * @return the model and view
     * @author:竺志伟
     * @date :2018-06-12 08:55:19
     */
    @RequestMapping(value = "/")
    public ModelAndView toDefaultPage()
    {
        modelAndView = new ModelAndView();
        Admin admin = super.getLoginUser();
        if(null != admin)
        {
            modelAndView.addObject("nowDate", new Date());
            modelAndView.setViewName("index");
        }
        else
        {
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }


    /**
     * 进入登录页面
     * To login model and view.
     *
     * @return the model and view
     * @author:竺志伟
     * @date :2018-06-18 15:15:06
     */
    @RequestMapping(value = "/login")
    public ModelAndView toLogin()
    {
        modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    /**
     * 登录
     * Login common result.
     *
     * @param loginName the login name
     * @param password  the password
     * @param loginCode the login code
     * @return the common result
     * @author:竺志伟
     * @date :2018-07-06 10:02:28
     */
    @RequestMapping(value = "/web/login")
    @ResponseBody
    public CommonResult login(@RequestParam(value = "loginName", required = true, defaultValue = "") String loginName,
                              @RequestParam(value = "password", required = true, defaultValue = "") String password,
                              @RequestParam(value = "loginCode", required = true, defaultValue = "") String loginCode)
    {
        String vocdeSession = super.getLoginVocde();
        if(!loginCode.equalsIgnoreCase(vocdeSession))
        {
            return resultFailsWrapper("验证码错误", null);
        }
        password = DigestUtils.md5Hex(password);
        Admin admin = adminServer.login(loginName, password);
        if(null == admin)
        {
            return resultFailsWrapper("用户名密码错误", null);
        }
        super.setLoginUser(admin);
        return resultSuccessWrapper("登录成功", null);
    }

    /**
     * 进入首页
     * To index model and view.
     *
     * @return the model and view
     * @author:竺志伟
     * @date :2018-07-06 10:10:21
     */
    @RequestMapping(value = "/web/toIndex")
    public ModelAndView toIndex()
    {
        modelAndView = new ModelAndView();
        modelAndView.addObject("nowDate", new Date());
        modelAndView.setViewName("index");
        return modelAndView;
    }


    /**
     * 退出
     * Log out model and view.
     *
     * @return the model and view
     * @author:竺志伟
     * @date :2018-07-09 09:37:44
     */
    @RequestMapping(value = "/web/logOut")
    public ModelAndView logOut()
    {
        super.clearSession();
        modelAndView = new ModelAndView();
        modelAndView.setView(new RedirectView("/"));
        return modelAndView;
    }
}
