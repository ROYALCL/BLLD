package com.jlxy.bllld.dao;

import com.jlxy.bllld.entity.BlogInfo;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.jlxy.bllld.utils.OrmConstans.BlogInfoTABLE;

/**
 * Created by ORCHID on 2017/3/25.
 */
@Repository
public interface BlogInfoDao {

    @Select("select * from "+BlogInfoTABLE+" where name=#{name}")
    List<BlogInfo> selectByName(String name);

    @Update("update "+BlogInfoTABLE+" set uid=#{UId},name=#{Name},blogtitle=#{BlogTitle},idiograph=#{IdIograph}")
    void update(BlogInfo blogInfo);
}
