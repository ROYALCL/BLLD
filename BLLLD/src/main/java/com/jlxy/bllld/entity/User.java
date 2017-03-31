package com.jlxy.bllld.entity;

import java.util.Date;

/**
 * Created by ORCHID on 2017/3/23.
 */
public class User {
//    CREATE TABLE `user` (
    private Integer UId;
// `name` varchar(50) NOT NULL COMMENT '用户姓名',
    private String Name;
// `password` varchar(20) NOT NULL COMMENT '用户密码',
    private String PassWord;
// `nick_name` varchar(100) NOT NULL COMMENT '昵称',
    private String NickName;
// `sex` char(1) NOT NULL COMMENT '性别',
    private String Sex;
// `duty` varchar(15) COMMENT '职务',
    private String Duty;
// `email` varchar(15) COMMENT '邮箱',
    private String Email;
// `photo_url` varchar(75) COMMENT '头像地址',
    private String PhotoUrl;
// `used` int NOT NULL COMMENT '账号是否可用',
    private boolean Used;
// `create_time` DATETIME NOT NULL ,
    private Date CreateTime;
//    PRIMARY KEY (`name`)
//) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

    public Integer getUId() {
        return UId;
    }

    public void setUId(Integer UId) {
        this.UId = UId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getDuty() {
        return Duty;
    }

    public void setDuty(String duty) {
        Duty = duty;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhotoUrl() {
        return PhotoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        PhotoUrl = photoUrl;
    }

    public boolean isUsed() {
        return Used;
    }

    public void setUsed(boolean used) {
        Used = used;
    }

    public Date getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Date createTime) {
        CreateTime = createTime;
    }

    public User(String name, String passWord, String nickName, String sex, String duty, String email, String photoUrl, boolean used, Date createTime) {

        Name = name;
        PassWord = passWord;
        NickName = nickName;
        Sex = sex;
        Duty = duty;
        Email = email;
        PhotoUrl = photoUrl;
        Used = used;
        CreateTime = createTime;
    }

    public User() {

    }

    public String PrintEntity(){
        String user="Id: "+this.getUId()+" , Name: "+this.getName()+" , Password: "+this.getPassWord()+" , NickName: "+this.getNickName();
        if(this.getSex()=="f"){
            user+=" , Sex: Female";
        }else if(this.getSex()=="m"){
            user+=" , Sex: Male";
        }else {
            user+=" , Sex: Secret";
        }
        user+=" , Duty : "+this.getDuty()+" , Email : "+this.getEmail()+" , Used: ";
        if(this.isUsed()==false){
            user+="False , CreateTime : "+this.getCreateTime();
        }else {
            user+="True , CreateTime : "+this.getCreateTime();
        }
        return user;
    }
}
