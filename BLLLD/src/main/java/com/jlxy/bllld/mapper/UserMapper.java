package com.jlxy.bllld.mapper;

import com.jlxy.bllld.daoImpl.ArticleDynaSqlProvider;
import com.jlxy.bllld.daoImpl.UserDynaSqlProvider;
import com.jlxy.bllld.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.jlxy.bllld.utils.OrmConstans.UserTABLE;

/**
 * Created by ORCHID on 2017/3/23.
 */
@Repository
public interface UserMapper{
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
     * @param Name 待查找用户name
     * @return 返回查找的User对象，没有返回null
     */
    @Select("select * from " + UserTABLE + " where name=#{Name}")
    User selectByName(String Name);

    /**
     * 查找符合email的对象
     *
     * @param Email 待查找用户email
     * @return 返回查找的User对象，没有返回null
     */
    @Select("select * from " + UserTABLE + " where email=#{Email}")
    User selectByEmail(String Email);

    /**
     * 查找符合id的对象
     *
     * @param id 待查找用户id
     * @return 返回查找的User对象，没有返回null
     */
    @Select("select * from " + UserTABLE + " where uid=#{UId}")
    User selectById(@Param("UId") Integer UId);

    /**
     * 删除某个对象，在企业开发中，我们一般不做物理删除，只是添加某个字段对其数据进行可用控制
     *
     * @param id 待删除对象
     * @return 返回受影响的条数
     */
    @Delete("delete from " + UserTABLE + " where uid=#{UId}")
    Integer deleteById(@Param("UId") Integer id);

    /**
     * update User对象
     *
     * @param user 待更新对象
     */
    //@Update("update " + UserTABLE + " set password=#{PassWord},name=#{Name},nick_name=#{NickName},sex=#{Sex},duty=#{Duty},email=#{Email},photo_url=#{PhotoUrl},used=#{Used},create_time=#{CreateTime} WHERE uid=#{Id}")
    @UpdateProvider(type = UserDynaSqlProvider.class,method = "update")
    void update(User user);

    /**
     * 插入User对象
     * @param user 待插入对象
     */
    @InsertProvider(type = UserDynaSqlProvider.class,method = "add")
    @Results({
            @Result(id =true,column = "uid",property = "UId"),
            @Result(column = "name",property = "Name"),
            @Result(column = "password",property = "PassWord"),
            @Result(column = "nick_name",property = "NickName"),
            @Result(column = "sex",property = "Sex"),
            @Result(column = "duty",property = "Duty"),
            @Result(column = "email",property = "Email"),
            @Result(column = "photo_url",property = "PhotoUrl"),
            @Result(column = "used",property = "Used"),
            @Result(column = "create_time",property = "CreateTime")
    })
    Integer add(User user);

    @Select("select * from "+UserTABLE)
    @Results({
            @Result(id =true,column = "uid",property = "UId"),
            @Result(column = "name",property = "Name"),
            @Result(column = "password",property = "PassWord"),
            @Result(column = "nick_name",property = "NickName"),
            @Result(column = "sex",property = "Sex"),
            @Result(column = "duty",property = "Duty"),
            @Result(column = "email",property = "Email"),
            @Result(column = "photo_url",property = "PhotoUrl"),
            @Result(column = "used",property = "Used"),
            @Result(column = "create_time",property = "CreateTime")
    })
    List<User> selectAll();
}
