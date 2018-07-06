package com.nature.jet.webApp.controller;

import com.nature.jet.webApp.controller.basic.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

    /**
     * 进入首页
     * To index model and view.
     *
     * @return the model and view
     * @author:竺志伟
     * @date :2018-06-12 08:55:19
     */
    @RequestMapping(value = "/")
    public ModelAndView toIndex()
    {
        logger.info("to index");
        modelAndView = new ModelAndView();
        if(null != super.getLoginUser())
        {
            modelAndView.addObject("aa","测试123");
            request.getSession().setAttribute("aaSession","aaaSession");
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
}
