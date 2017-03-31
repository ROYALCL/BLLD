package com.jlxy.bllld.entity;

/**
 * Created by ORCHID on 2017/3/23.
 */
public class BlogInfo {
    private Integer Id;
//    CREATE TABLE `bloginfo` (
    private User User;
//  `name`      VARCHAR(20) NOT NULL DEFAULT '',
    private String Name;
//  `blogtitle` VARCHAR(50)          DEFAULT NULL,
    private String BlogTitle;
//  `idiograph` VARCHAR(50)          DEFAULT NULL,
    private String IdIograph;

//    PRIMARY KEY (`name`),
//    CONSTRAINT `bloginfo_ibfk_1` FOREIGN KEY (`name`) REFERENCES `user` (`name`))
//    ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT = '个性设置表';

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBlogTitle() {
        return BlogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        BlogTitle = blogTitle;
    }

    public String getIdIograph() {
        return IdIograph;
    }

    public void setIdIograph(String idIograph) {
        IdIograph = idIograph;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User user) {
        this.User = user;
    }

    public BlogInfo() {
    }

    public BlogInfo( String name, String blogTitle, String idIograph, User user) {
        Name = name;
        BlogTitle = blogTitle;
        IdIograph = idIograph;
        User=user;
    }
}
