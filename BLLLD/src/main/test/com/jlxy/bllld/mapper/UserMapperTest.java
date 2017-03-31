package com.jlxy.bllld.mapper;

import com.jlxy.bllld.BaseJunitTest;
import com.jlxy.bllld.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by ORCHID on 2017/3/25.
 */
public class UserMapperTest extends BaseJunitTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectByNameAndPassword() throws Exception {
        User user=userMapper.selectByNameAndPassword("xiaoxiao","000000");
        if(null!=user){
            System.out.println(user.PrintEntity());
        }
    }

    @Test
    public void selectByName() throws Exception {
        User user=userMapper.selectByName("xiaoxiao");
        System.out.println(user.PrintEntity());
    }

    @Test
    public void selectByEmail() throws Exception {
        User user=userMapper.selectByEmail("0000@163.com");
        System.out.println(user.PrintEntity());
    }

    @Test
    public void deleteById() throws Exception {
        System.out.println(userMapper.deleteById(3));
    }

    @Test
    public void update() throws Exception {
        User user=new User();
        user.setUId(0);
        user.setPhotoUrl("lakjsdhfkjashdf");
        userMapper.update(user);
    }

    @Test
    public void add() throws Exception {
        User user =new User();
        user.setName("heihei");
        user.setNickName("dlfjkgh");
        user.setPassWord("000000");
        user.setPhotoUrl("lkashdkjdsh");
        user.setCreateTime(new Date());
        user.setDuty("学生");
        user.setEmail("1111@163.com");
        user.setSex("F");
        user.setUsed(false);
        System.out.println(userMapper.add(user));
    }

}