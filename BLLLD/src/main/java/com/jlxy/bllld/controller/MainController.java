package com.jlxy.bllld.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ORCHID on 2017/3/12.
 */
@Controller
@RequestMapping("/Main")
public class MainController {

    @RequestMapping(value = "/Controller")
    public ModelAndView loginin() {
        Logger logger = LoggerFactory.getLogger(MainController.class);
        logger.info("info-redirect to login!");
        ModelAndView modelAndView = new ModelAndView("/jsp/login_reg");
        return modelAndView;
    }

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,Object handler) throws Exception{
        return true;
    }
}