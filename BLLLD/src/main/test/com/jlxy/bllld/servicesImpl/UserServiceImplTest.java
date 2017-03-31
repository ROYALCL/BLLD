package com.jlxy.bllld.servicesImpl;

import com.jlxy.bllld.BaseJunitTest;
import com.jlxy.bllld.entity.User;
import com.jlxy.bllld.services.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ORCHID on 2017/3/30.
 */
public class UserServiceImplTest extends BaseJunitTest {
    @Autowired
    private UserService userService;

    @Test
    public void reg() throws Exception {
        User user=new User("test","test","ttest","f","student","1111@163.com","dfkalkj",false,new Date());
        if(userService.reg(user)){
            logger.info("reg successful!");
        }else {
            logger.error("reg fail");
        }
    }

    @Test
    public void login(){
        User user=userService.login("xiaoxiao","000000");
        if(null!=user) {
            logger.info(user.PrintEntity());
        }
    }
    @Test
    public void selectByName() throws Exception {
        User user=userService.selectByName("test");
        logger.info(user.PrintEntity());
    }

    @Test
    public void selectByEmail() throws Exception {
        User user=userService.selectByEmail("1111@163.com");
        logger.info(user.PrintEntity());
    }

    @Test
    public void update() throws Exception {
        User user=new User("test","test","ttest","f","student","1111@163.com","dfkalkj",true,new Date());
        userService.update(user);
        logger.info(user.PrintEntity());
    }

    @Test
    public void selectAll() throws Exception {
        List<User> users=userService.selectAll();
        for(User user:users){
            logger.info(user.PrintEntity());
        }
    }

    @Test
    public void selectByUId() throws Exception {
        User user =userService.selectByUId(2);
        if(user!=null){
            logger.info(user.PrintEntity());
        }else {
            logger.error("selectByUId fail");
        }
    }

    @Test
    public void deleteByUId() throws Exception {
        int x=userService.deleteByUId(userService.selectByName("test").getUId());
        System.out.println(x);
    }
}