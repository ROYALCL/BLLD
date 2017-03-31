package com.jlxy.bllld.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ORCHID on 2017/3/23.
 */
public class Article implements Serializable{
    //    CREATE TABLE `article` (
//            `id`      INT(11) NOT NULL AUTO_INCREMENT,
    private Integer Id;
    //文章关联的用户对象
//  `title`   VARCHAR(50)      DEFAULT NULL,
    private String Title;
    //  `content` TEXT,
    private String Content;
    //            `name`    VARCHAR(50)      DEFAULT NULL,
    private String Name;
    //  `date`    DATETIME         DEFAULT NULL,
    //@DateTimeFormat(pattern = "yyyy-mm-dd-hh-")
    private Date Date;
    //            `hasread` INT(11)          DEFAULT '0',
    private Integer HasRead;

    private User User;
//    PRIMARY KEY (`Id`),
//    KEY `username` (`name`),
//    CONSTRAINT `article_ibfk_1` FOREIGN KEY (`name`) REFERENCES `user` (`name`))
//    ENGINE = InnoDB AUTO_INCREMENT = 0 DEFAULT CHARSET = utf8 COMMENT = '文章表';

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public int getHasRead() {
        return HasRead;
    }

    public void setHasRead(int hasRead) {
        HasRead = hasRead;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User user) {
        User = user;
    }

    public Article() {
    }

    public Article(int UId, String title, String content, String name, java.util.Date date, int hasRead, User user) {
        Title = title;
        Content = content;
        Name = name;
        Date = date;
        HasRead = hasRead;
        User = user;
    }
}
