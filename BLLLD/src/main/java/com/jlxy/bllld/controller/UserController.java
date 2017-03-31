package com.jlxy.bllld.controller;

import com.jlxy.bllld.entity.User;
import com.jlxy.bllld.services.UserService;
import com.jlxy.bllld.utils.MethodName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by ORCHID on 2017/3/8.
 */
@Controller
@RequestMapping("/LR")
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public ModelAndView reg(HttpServletRequest request, User user) {
        logger.info("from class: "+this.getClass().getSimpleName()+" info-  function "+ new MethodName().getMethodName()+" exec successful! ");
        logger.info("data info: - " + user.PrintEntity());
        user.setCreateTime(new Date());
        user.setUsed(false);
        ModelAndView modelAndView = new ModelAndView();
        if (null == user) {
            modelAndView.setViewName("/jsp/login_reg");
            modelAndView.addObject("message", "用户信息不能为空！");
            logger.error("error- 用户信息不能为空！");
        } else if (null == user.getName() || null == user.getPassWord()) {
            modelAndView.setViewName("/jsp/login_reg");
            modelAndView.addObject("message", "用户信息缺失！");
            logger.error("error- 用户信息缺失！");
        } else {
            if (!userService.reg(user)) {
                modelAndView.setViewName("/jsp/login_reg");
                modelAndView.addObject("message", "添加用户信息失败！");
                logger.error("error- 执行用户添加失败！请重试！");
            } else {
                modelAndView.setViewName("/index");
                modelAndView.addObject("message", "Successful");
                request.getSession().setAttribute("user", user);
                logger.info("info- 执行用户添加成功！");
            }
        }
        return modelAndView;
    }

    @RequestMapping(value = "/validateName", method = RequestMethod.POST)
    public @ResponseBody String validateName(HttpServletRequest hsr) {
        logger.info("from class: "+this.getClass().getSimpleName()+" info-  function "+ new MethodName().getMethodName()+" exec successful! ");
        String name = hsr.getParameter("name");
        if (null == name) {
            logger.info("info- 动态验证用户：" + name + "  验证失败！其他");
            return "false";
        } else {
            if (null!=userService.selectByName(name)) {
                logger.info("info- 动态验证用户：" + name + "  验证成功！");
                return "false";
            } else {
                logger.info("info- 动态验证用户：" + name + "  验证失败！对象不存在！");
                return "true";
            }
        }
    }
    @RequestMapping(value = "/validateEmail", method = RequestMethod.POST)
    public @ResponseBody String validateEmail(HttpServletRequest hsr) {
        logger.info("from class: "+this.getClass().getSimpleName()+" info-  function "+ new MethodName().getMethodName()+" exec successful! ");
        String email = hsr.getParameter("email");
        if (null == email) {
            logger.info("info- 动态验证邮箱：" + email + "  验证失败！其他");
            return "false";
        } else {
            if (null!=userService.selectByEmail(email)) {
                logger.info("info- 动态验证邮箱：" + email + "  验证成功！");
                return "false";
            } else {
                logger.info("info- 动态验证邮箱：" + email + "  验证失败！对象不存在！");
                return "true";
            }
        }
    }

    @RequestMapping(value = "/login")
    public ModelAndView login(@RequestParam("username") String name, @RequestParam("password") String password, HttpServletRequest hsr) {
        logger.info("from class: "+this.getClass().getSimpleName()+" info-  function "+ new MethodName().getMethodName()+" exec successful! ");
        ModelAndView modelAndView = new ModelAndView();
        User user=userService.login(name, password);
        if (null !=user ) {
            hsr.getSession().setAttribute("user", user);
            modelAndView.setViewName("/success");
            modelAndView.addObject("message", "Successful!");
            logger.info("info:-->Controller login  用户名:" + name + "  密码:" + password + "     Successful!");
        } else {
            modelAndView.setViewName("forward:/login");
            logger.error("info:-->Controller login  用户名:" + name + "  密码:" + password + "     Fail!");
            modelAndView.addObject("message", "Fail!");
        }
        return modelAndView;
    }
    @RequestMapping(value = "/logout")
    public ModelAndView logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){//@RequestParam("username") String name, @RequestParam("password") String password, HttpServletRequest hsr) {
        logger.info("from class: "+this.getClass().getSimpleName()+" info-  function "+ new MethodName().getMethodName()+" exec successful! ");
        ModelAndView modelAndView = new ModelAndView();
        //获取session中的用户
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (null !=user ) {
            httpServletRequest.getSession().setAttribute("user", null);
            modelAndView.setViewName("/success");
            modelAndView.addObject("message", "logout Successful!");
            logger.info("info:-->Controller logout  用户名:" + user.getName() + "     Successful!");
        } else {
            modelAndView.setViewName("forward:/index");
            logger.error("info:-->Controller logout  未登录!");
            modelAndView.addObject("message", "logout Fail!");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/affirmEmail", method = RequestMethod.POST)
    public ModelAndView affirmEmail(HttpServletRequest hsr) {
        logger.info("from class: "+this.getClass().getSimpleName()+" info-  function "+ new MethodName().getMethodName()+" exec successful! ");
        ModelAndView modelAndView = new ModelAndView("/jsp/validate_email");
        //生成邮件，并且发送出去
        JavaMailSenderImpl mailSender =new JavaMailSenderImpl();
        return modelAndView;
    }
}
