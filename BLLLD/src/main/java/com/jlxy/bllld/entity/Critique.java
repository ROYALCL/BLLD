package com.jlxy.bllld.entity;

/**
 * Created by ORCHID on 2017/3/23.
 */
public class Critique {
    //  CREATE TABLE `critique` (
    //  `id`       INT(11) NOT NULL AUTO_INCREMENT,
    private Integer Id;
    //  `aid`      INT(11)          DEFAULT NULL,
    private Article Article;
    //  `content`  TEXT,
    private String Content;
    //  `username` VARCHAR(50)      DEFAULT NULL,
    private String UserName;
//    PRIMARY KEY (`id`),
//    KEY `AId` (`aid`),
//    CONSTRAINT `critique_ibfk_1` FOREIGN KEY (`aid`) REFERENCES `article` (`id`))
//    ENGINE = InnoDB AUTO_INCREMENT = 0 DEFAULT CHARSET = utf8 COMMENT = '评论表';


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Article getArticle() {
        return Article;
    }

    public void setArticle(Article article) {
        Article = article;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public Critique() {
    }

    public Critique(Article article, String content, String userName) {
        Article = article;
        Content = content;
        UserName = userName;
    }
}
