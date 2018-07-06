package com.nature.jet.webApp.controller.basic;

import com.nature.jet.webApp.pojo.system.Admin;
import com.nature.jet.webApp.util.CommonResult;
import com.nature.jet.webApp.util.Fields;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * springboot
 * BaseController
 * Author: 竺志伟
 * Date:   2017-03-30 15:06
 */
public abstract class BaseController implements ErrorController
{
    private static final String ERROR_PATH = "/error";
    protected ModelAndView modelAndView = null;
    @Autowired
    protected HttpServletResponse response;
    @Autowired
    protected HttpServletRequest request;

    protected Logger logger = Logger.getLogger(this.getClass());


    /**
     * 错误页面
     *
     * @return
     */
    @RequestMapping(value = ERROR_PATH)
    public String handleError()
    {
        return "common/error";
    }

    @Override
    public String getErrorPath()
    {
        return ERROR_PATH;
    }


    protected CommonResult resultDataWrapper(Object obj)
    {
        return resultSuccessWrapper("success", obj);
    }

    protected CommonResult resultWrapper(int code, String message, Object obj)
    {
        CommonResult result = new CommonResult();
        result.setMessage(message);
        result.setData(obj);
        result.setCode(code);
        return result;
    }

    protected CommonResult resultBoolWrapper(boolean bool, String success, String fails, Object obj)
    {
        if(bool)
        {
            return resultSuccessWrapper(success, obj);
        }
        return resultFailsWrapper(fails, obj);
    }

    protected CommonResult resultSuccessWrapper(String message, Object obj)
    {
        return resultWrapper(CommonResult.SUCCESS, message, obj);
    }

    protected CommonResult resultFailsWrapper(String message, Object obj)
    {
        return resultWrapper(CommonResult.FAILS, message, obj);
    }


    protected Admin getLoginUser()
    {
        if( null != request.getSession().getAttribute(Fields.SESSION_LOGIN_USER))
        {
            return (Admin) request.getSession().getAttribute(Fields.SESSION_LOGIN_USER);
        }
        return null;
    }
}
