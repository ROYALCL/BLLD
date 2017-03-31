package com.jlxy.bllld.dao;

import com.jlxy.bllld.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.jlxy.bllld.utils.OrmConstans.UserTABLE;

/**
 * Created by ORCHID on 2017/3/23.
 */
@Repository
public interface UserDao {
    /**
     * 查找符合Name和Password的对象
     *
     * @param Name     待查找用户名
     * @param Password 待查找密码
     * @return 返回查找的User对象，没有返回null
     */
    @Select("select * from " + UserTABLE + " where name=#{Name} and password=#{Password}")
    User selectByNameAndPassword(@Param("Name") String Name, @Param("Password") String Password);

    /**
     * 查找符合name的对象
     *
     * @param name 待查找用户name
     * @return 返回查找的User对象，没有返回null
     */
    @Select("select * from " + UserTABLE + " where name=#{name}")
    User selectByName(String name);

    /**
     * 查找符合email的对象
     *
     * @param email 待查找用户email
     * @return 返回查找的User对象，没有返回null
     */
    @Select("select * from " + UserTABLE + " where email=#{email}")
    User selectByEmail(String email);

    /**
     * 查找符合id的对象
     *
     * @param id 待查找用户id
     * @return 返回查找的User对象，没有返回null
     */
    @Select("select * from " + UserTABLE + " where uid=#{id}")
    User selectById(@Param("id") int id);

    /**
     * 删除某个对象，在企业开发中，我们一般不做物理删除，只是添加某个字段对其数据进行可用控制
     *
     * @param id 待删除对象
     * @return 返回受影响的条数
     */
    @Delete("delete from " + UserTABLE + " where uid=#{id}")
    int deleteById(@Param("id") int id);

    /**
     * update User对象
     *
     * @param user 待更新对象
     */
    @Update("update " + UserTABLE + " set password=#{PassWord},name=#{Name},nick_name=#{NickName},sex=#{Sex},duty=#{Duty},email=#{Email},photo_url=#{PhotoUrl},used=#{Used},create_time=#{CreateTime} WHERE uid=#{Id}")
    void update(User user);

    /**
     * 插入User对象
     * @param user 待插入对象
     */
//    INSERT INTO gp_user
//            (password,name,nick_name,sex,duty,email,photo_url,used,create_time)
//    VALUE (#{PassWord},#{Name},#{NickName},#{Sex},#{Duty},#{Email},#{PhotoUrl},#{Used},#{CreateTime})
    @Insert("insert into "+UserTABLE+"(name,password,nick_name,sex,duty,email,photo_url,used,create_time) VALUES (#{PassWord},#{Name},#{NickName},#{Sex},#{Duty},#{Email},#{PhotoUrl},#{Used},#{CreateTime})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int add(User user);

    @Select("select * from "+UserTABLE)
    List<User> selectAll();
}
