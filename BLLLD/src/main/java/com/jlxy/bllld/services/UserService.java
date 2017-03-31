package com.jlxy.bllld.services;

import com.jlxy.bllld.entity.User;

import java.util.List;

/**
 * Created by ORCHID on 2017/3/7.
 */
public interface UserService {
    boolean reg(User user);

    User selectByName(String name);

    User selectByEmail(String email);

    User login(String name, String password);

    void update(User user);

    List<User> selectAll();

    User selectByUId(int uid);

    int deleteByUId(int uid);
}
