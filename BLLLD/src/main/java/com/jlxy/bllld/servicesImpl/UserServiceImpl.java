package com.jlxy.bllld.servicesImpl;

import com.jlxy.bllld.entity.User;
import com.jlxy.bllld.mapper.UserMapper;
import com.jlxy.bllld.services.UserService;
import com.jlxy.bllld.utils.MethodName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ORCHID on 2017/3/23.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean reg(User user) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! name:" + user.getName() + ",password:" + user.getPassWord());
        if (userMapper.add(user) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public User selectByName(String name) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! name:" + name);
        return userMapper.selectByName(name);
    }

    public User selectByEmail(String email) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! Email:" + email);
        return userMapper.selectByEmail(email);
    }

    public User login(String name, String password) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! name:" + name + ",password:" + password);
        return userMapper.selectByNameAndPassword(name, password);
    }

    public void update(User user) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! name:" + user.getName() + ",password:" + user.getPassWord());
        userMapper.update(user);
    }

    public List<User> selectAll() {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        return userMapper.selectAll();
    }

    public User selectByUId(int uid) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! UId:" + uid);
        return userMapper.selectById(uid);
    }

    public int deleteByUId(int uid) {
        return userMapper.deleteById(uid);
    }
}
