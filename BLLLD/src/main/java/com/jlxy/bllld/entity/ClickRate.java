package com.jlxy.bllld.entity;

import java.util.Date;

/**
 * Created by ORCHID on 2017/3/23.
 */
public class ClickRate {
    //    CREATE TABLE `clickrate` (
//  `id`   INT(11) NOT NULL AUTO_INCREMENT,
    private Integer Id;
    //  `aid`  INT(11)          DEFAULT NULL,
    private Article Article;
    //  `ip`   VARCHAR(255)     DEFAULT NULL,
    private String Ip;
    //  `time` DATE             DEFAULT NULL,
    private Date Time;
//    PRIMARY KEY (`id`),
//    KEY `AId` (`aid`),
//    CONSTRAINT `clickrate_ibfk_1` FOREIGN KEY (`aid`) REFERENCES `article` (`id`))
//    ENGINE = InnoDB AUTO_INCREMENT = 0
//    DEFAULT CHARSET = utf8
//    COMMENT = '点击量表';

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public com.jlxy.bllld.entity.Article getArticle() {
        return Article;
    }

    public void setArticle(com.jlxy.bllld.entity.Article article) {
        Article = article;
    }

    public String getIp() {
        return Ip;
    }

    public void setIp(String ip) {
        Ip = ip;
    }

    public Date getTime() {
        return Time;
    }

    public void setTime(Date time) {
        Time = time;
    }

    public ClickRate(Article artilce, String ip, Date time) {
        Article = artilce;
        Ip = ip;
        Time = time;
    }

    public ClickRate() {
    }
}
