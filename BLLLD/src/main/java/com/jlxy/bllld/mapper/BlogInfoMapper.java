package com.jlxy.bllld.mapper;

import com.jlxy.bllld.daoImpl.BlogInfoDynaSqlProvider;
import com.jlxy.bllld.entity.BlogInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.jlxy.bllld.utils.OrmConstans.BlogInfoTABLE;

/**
 * Created by ORCHID on 2017/3/25.
 */
@Repository
public interface BlogInfoMapper {

    @SelectProvider(type = BlogInfoDynaSqlProvider.class,method = "add")
    @Options(useGeneratedKeys=true,keyProperty = "id")
    Integer add(BlogInfo blogInfo);

    @Select("select * from "+BlogInfoTABLE+" where name=#{name}")
    @Results({
            @Result(id =true,column = "id",property = "Id"),
            @Result(column = "uid",property = "User",one = @One(select = "com.jlxy.bllld.mapper.UserMapper.selectById",fetchType = FetchType.EAGER)),
            @Result(column = "name",property = "Name"),
            @Result(column = "blogtitle",property = "BlogTitle"),
            @Result(column = "idiograph",property = "IdIograph")
    })
    List<BlogInfo> selectByName(String name);

    @SelectProvider(type = BlogInfoDynaSqlProvider.class,method = "update")
    @Options(useGeneratedKeys=true,keyProperty = "id")
    void update(BlogInfo blogInfo);
}