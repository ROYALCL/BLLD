package com.jlxy.bllld.mapper;

import com.jlxy.bllld.daoImpl.ArticleDynaSqlProvider;
import com.jlxy.bllld.entity.Article;
import com.jlxy.bllld.entity.Page;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.jlxy.bllld.utils.OrmConstans.ArticleTABLE;

/**
 * Created by ORCHID on 2017/3/25.
 */
@Repository
public interface ArticleMapper {

    //@Insert("insert into "+ArticleTABLE+"(uid,title,content,name,date,hasread) VALUES (#{UId},#{Title},#{Content},#{Name},#{Date},#{HasRead})")
    @SelectProvider(type = ArticleDynaSqlProvider.class,method = "add")
    @Options(useGeneratedKeys=true,keyProperty = "uid")
    Integer add(Article article);

    @Select("select * from "+ArticleTABLE+" where name=#{username}")
    @Results({
            @Result(id =true,column = "id",property = "Id"),
            @Result(column = "uid",property = "User",one = @One(select = "com.jlxy.bllld.mapper.UserMapper.selectById",fetchType = FetchType.EAGER)),
            @Result(column = "title",property = "Title"),
            @Result(column = "content",property = "Content"),
            @Result(column = "name",property = "Name"),
            @Result(column = "date",property = "Date"),
            @Result(column = "hasread",property = "HasRead")
    })
    List<Article> selectByUserAll(String username);

    @Select("select count(*) from "+ArticleTABLE+" where name=#{username}")
    Integer selectUserAllCount(String username);

    List<Article> selectByPage(String username,Page page);

    @Select("select * from "+ArticleTABLE+" order by date desc")
    List<Article> selectAllByPage(Page page);

    @Select("select count(*) from "+ArticleTABLE)
    Integer selectAllCount();

    @Select("select * from "+ArticleTABLE+" where id=#{id}")
    @Results({
            @Result(id =true,column = "id",property = "Id"),
            @Result(column = "uid",property = "User",one = @One(select = "com.jlxy.bllld.mapper.UserMapper.selectById",fetchType = FetchType.EAGER)),
            @Result(column = "title",property = "Title"),
            @Result(column = "content",property = "Content"),
            @Result(column = "name",property = "Name"),
            @Result(column = "date",property = "Date"),
            @Result(column = "hasread",property = "HasRead")
    })
    Article selectById(Integer id);
}
