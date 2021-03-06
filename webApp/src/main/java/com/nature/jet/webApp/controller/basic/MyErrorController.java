package com.nature.jet.webApp.controller.basic;

import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一错误处理
 * spring_cloud_demo
 * MyErrorController
 *
 * @Author: 竺志伟
 * @Date: 2018-07-06 10:39
 */
@ControllerAdvice
@Controller
@RequestMapping("/error")
public class MyErrorController extends BasicErrorController
{
    public MyErrorController(ServerProperties serverProperties)
    {
        super(new DefaultErrorAttributes(), serverProperties.getError());
    }

    /**
     * 覆盖默认的Json响应
     */
    @Override
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request)
    {
        Map<String, Object> body = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.ALL));
        HttpStatus status = getStatus(request);
        //输出自定义的Json格式
        Map<String, Object> map = new HashMap<String, Object>();
        if(status.is4xxClientError())
        {
            map.put("message", "页面:" + body.get("path").toString() + "已经丢失,请联系管理员!");
        }
        else if(status.is5xxServerError())
        {
            map.put("message", "页面:" + body.get("path").toString() + "发生系统错误,请联系管理员!");
        }
        else
        {
            map.put("message", body.get("message"));
        }
        return new ResponseEntity<Map<String, Object>>(map, status);
    }

    /**
     * 覆盖默认的HTML响应
     */
    @Override
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response)
    {
        //请求的状态
        HttpStatus status = getStatus(request);
        response.setStatus(getStatus(request).value());
        Map<String, Object> model = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.TEXT_HTML));
        ModelAndView modelAndView = new ModelAndView();
        if(status.is5xxServerError())
        {
            modelAndView.addObject("errorInfo", model.get("message").toString());
            modelAndView.addObject("uri", model.get("path").toString());
            modelAndView.setViewName("common/error500");
        }
        else if(status.is4xxClientError())
        {
            modelAndView.addObject("errorInfo", "页面丢失了,程序员悬赏通缉中.....");
            modelAndView.addObject("uri", model.get("path").toString());
            modelAndView.setViewName("common/error404");
        }
        return modelAndView;
    }
}
