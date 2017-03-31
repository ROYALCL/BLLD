package com.jlxy.bllld.dao;

import com.jlxy.bllld.entity.Article;
import com.jlxy.bllld.entity.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

import static com.jlxy.bllld.utils.OrmConstans.ArticleTABLE;

/**
 * Created by ORCHID on 2017/3/30.
 */
public interface ArticleDao {
    @Insert("insert into "+ArticleTABLE+"(uid,title,content,name,date,hasread) VALUES (#{user.getId()},#{Title},#{Content},#{Name},#{Date},#{HasRead})")
    @Options(useGeneratedKeys=true,keyProperty = "id")
    int add(Article article);

    @Select("select * from "+ArticleTABLE+" where name=#{username}")
    List<Article> selectByUserAll(String username);

    @Select("select count(*) from "+ArticleTABLE+" where name=#{username}")
    int selectUserAllCount(String username);

    List<Article> selectByPage(String username,Page page);

    @Select("select * from "+ArticleTABLE+" order by date desc")
    List<Article> selectAllByPage(Page page);

    @Select("select count(*) from "+ArticleTABLE)
    int selectAllCount();

    @Select("select * from "+ArticleTABLE+" where id=#{id}")
    Article selectById(int id);
}
