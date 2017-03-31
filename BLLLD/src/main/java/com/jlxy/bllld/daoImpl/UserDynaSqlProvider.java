package com.jlxy.bllld.daoImpl;

import com.jlxy.bllld.entity.Article;
import com.jlxy.bllld.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.jdbc.SQL;

import static com.jlxy.bllld.utils.OrmConstans.ArticleTABLE;
import static com.jlxy.bllld.utils.OrmConstans.UserTABLE;

/**
 * Created by ORCHID on 2017/3/30.
 */
public class UserDynaSqlProvider {
    //@Insert("insert into "+UserTABLE+"(name,password,nick_name,sex,duty,email,photo_url,used,create_time) VALUES (#{PassWord},#{Name},#{NickName},#{Sex},#{Duty},#{Email},#{PhotoUrl},#{Used},#{CreateTime})")
    public String add(final User user){
        return new SQL(){
            {
                INSERT_INTO(UserTABLE);
                if(user.getName()!=null){
                    VALUES("name","#{Name}");
                }
                if(user.getPassWord()!=null){
                    VALUES("password","#{PassWord}");
                }
                if(user.getNickName()!=null){
                    VALUES("nick_name","#{NickName}");
                }
                if(user.getSex()!=null){
                    VALUES("sex","#{Sex}");
                }
                if (user.getDuty()!=null) {
                    VALUES("duty","#{Duty}");
                }
                if(user.getEmail()!=null){
                    VALUES("email","#{Email}");
                }
                if(user.getPhotoUrl()!=null){
                    VALUES("photo_url","#{PhotoUrl}");
                }
                if(user.isUsed()==true||user.isUsed()==false){
                    VALUES("used","#{Used}");
                }
                if(user.getCreateTime()!=null){
                    VALUES("create_time","#{CreateTime}");
                }
            }
        }.toString();
    }
    public String update(final User user){
        return new SQL(){
            {
                UPDATE(UserTABLE);
                if(user.getName()!=null){
                    SET("name=#{Name}");
                }
                if(user.getPassWord()!=null){
                    SET("password=#{PassWord}");
                }
                if(user.getNickName()!=null){
                    SET("nick_name=#{NickName}");
                }
                if(user.getSex()!=null){
                    SET("sex=#{Sex}");
                }
                if (user.getDuty()!=null) {
                    SET("duty=#{Duty}");
                }
                if(user.getEmail()!=null){
                    SET("email=#{Email}");
                }
                if(user.getPhotoUrl()!=null){
                    SET("photo_url=#{PhotoUrl}");
                }
                if(user.isUsed()==true||user.isUsed()==false){
                    SET("used=#{Used}");
                }
                if(user.getCreateTime()!=null){
                    SET("create_time=#{CreateTime}");
                }
                WHERE("uid=#{UId}");
            }
        }.toString();
    }
}
