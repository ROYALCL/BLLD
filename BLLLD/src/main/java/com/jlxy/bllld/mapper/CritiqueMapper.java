package com.jlxy.bllld.mapper;

import com.jlxy.bllld.daoImpl.ClickRateDynaSqlProvider;
import com.jlxy.bllld.daoImpl.CritiqueDynaSqlProvider;
import com.jlxy.bllld.entity.Article;
import com.jlxy.bllld.entity.Critique;
import com.jlxy.bllld.entity.Page;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.jlxy.bllld.utils.OrmConstans.CritiqueTABLE;

/**
 * Created by ORCHID on 2017/3/25.
 */
@Repository
public interface CritiqueMapper {

    @SelectProvider(type = CritiqueDynaSqlProvider.class,method = "add")
    @Results({
            @Result(id =true,column = "id",property = "Id"),
            @Result(column = "aid",property = "Article",one = @One(select = "com.jlxy.bllld.mapper.ArticleMapper.selectById",fetchType = FetchType.EAGER)),
            @Result(column = "content",property = "Content"),
            @Result(column = "username",property = "Username"),
    })
    Integer add(Critique critique);

    @Select("select * from " + CritiqueTABLE + " where aid=#{Article.Id}")
    @Results({
            @Result(id =true,column = "id",property = "Id"),
            @Result(column = "aid",property = "Article",one = @One(select = "com.jlxy.bllld.mapper.ArticleMapper.selectById",fetchType = FetchType.EAGER)),
            @Result(column = "content",property = "Content"),
            @Result(column = "username",property = "Username"),
    })
    List<Critique> selectByAId(@Param("Article")Article article);

    @Select("select count(*) from "+CritiqueTABLE+" where aid=#{Article.Id}")
    Integer selectCritiqueCount(@Param("Article") Article article);

    List<Critique> selectByPage(final Article article, final Page page);
}
