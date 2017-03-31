package com.jlxy.bllld.interceptor;

import com.jlxy.bllld.controller.UserController;
import com.jlxy.bllld.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.jlxy.bllld.utils.OrmConstans.IGNORE_URT;

/**
 * Created by ORCHID on 2017/3/27.
 */
public class MainInterceptor implements HandlerInterceptor{

    private Logger logger = LoggerFactory.getLogger(MainInterceptor.class);


    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.info("MainInterceptor preHandle -->");
        //拦截请求
        boolean flag=false;
        for(String s:IGNORE_URT){
            if(httpServletRequest.getServletPath().contains(s)){
                flag=true;
                break;
            }
        }
        if(!flag) {
            //获取session中的用户
            User user = (User) httpServletRequest.getSession().getAttribute("user");
            //判断是否登录
            if (null != user) {
                logger.info("MainInterceptor 请求放行：");
                flag= true;
            } else {
                //没有登录，跳转到登陆页面
                logger.info("MainInterceptor 请求拦截：");
                httpServletRequest.setAttribute("message", "您还没有登录，请先登录！");
                httpServletRequest.getRequestDispatcher("login.jsp").forward(httpServletRequest, httpServletResponse);
                flag= false;
            }
        }
        return flag;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}