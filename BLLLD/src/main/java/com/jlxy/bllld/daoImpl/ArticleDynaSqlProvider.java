package com.jlxy.bllld.daoImpl;

import com.jlxy.bllld.entity.Article;
import org.apache.ibatis.jdbc.SQL;

import static com.jlxy.bllld.utils.OrmConstans.ArticleTABLE;
import static com.jlxy.bllld.utils.OrmConstans.IGNORE_URT;

/**
 * Created by ORCHID on 2017/3/30.
 */
public class ArticleDynaSqlProvider {
    //@Insert("insert into "+ArticleTABLE+"(uid,title,content,name,date,hasread) VALUES (#{UId},#{Title},#{Content},#{Name},#{Date},#{HasRead}
    public String add(final Article article){
        return new SQL(){
            {
                INSERT_INTO(ArticleTABLE);
                if(article.getTitle()!=null){
                    VALUES("title","#{Title}");
                }
                if(article.getUser()!=null){
                    VALUES("uid","#{User.UId}");
                }
                if(article.getContent()!=null){
                    VALUES("content","#{Content}");
                }
                if(article.getDate()!=null){
                    VALUES("date","#{Date}");
                }
                if (article.getHasRead()!=0) {
                    VALUES("hasread","#{HasRead}");
                }
                if(article.getName()!=null){
                    VALUES("name","#{Name}");
                }
            }
        }.toString();
    }
    public String selectByUserAll(final String username){
        return new SQL(){
            {
                SELECT("*");
                FROM(ArticleTABLE);
                if (username != null) {
                    WHERE("name", "#{username}");
                }
            }
        }.toString();
    }
}
