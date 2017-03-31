package com.jlxy.bllld.mapper;

import com.jlxy.bllld.daoImpl.BlogInfoDynaSqlProvider;
import com.jlxy.bllld.daoImpl.ClickRateDynaSqlProvider;
import com.jlxy.bllld.entity.Article;
import com.jlxy.bllld.entity.ClickRate;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

import static com.jlxy.bllld.utils.OrmConstans.ClickRateTABLE;

/**
 * Created by ORCHID on 2017/3/25.
 */
@Repository
public interface ClickRateMapper {

    @SelectProvider(type = ClickRateDynaSqlProvider.class,method = "add")
    @Results({
            @Result(id =true,column = "id",property = "Id"),
            @Result(column = "aid",property = "Article",one = @One(select = "com.jlxy.bllld.mapper.ArticleMapper.selectById",fetchType = FetchType.EAGER)),
            @Result(column = "ip",property = "Ip"),
            @Result(column = "time",property = "Time"),
    })
    Integer add(ClickRate clickRate);

    @Select("select * from "+ClickRateTABLE+" where aid=#{Article.Id} and ip=#{Ip} and time=#{Time}")
    @Results({
            @Result(id =true,column = "id",property = "Id"),
            @Result(column = "aid",property = "Article",one = @One(select = "com.jlxy.bllld.mapper.ArticleMapper.selectById",fetchType = FetchType.EAGER)),
            @Result(column = "ip",property = "Ip"),
            @Result(column = "time",property = "Time"),
    })
    List<ClickRate> selectByAId(@Param("Article")Article Article, @Param("Ip") String ip, @Param("Time") Date time);

}
