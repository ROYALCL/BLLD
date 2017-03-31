package com.jlxy.bllld.dao;

import com.jlxy.bllld.entity.Critique;
import com.jlxy.bllld.entity.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.jlxy.bllld.utils.OrmConstans.CritiqueTABLE;

/**
 * Created by ORCHID on 2017/3/25.
 */
@Repository
public interface CritiqueDao {

    @Insert("insert into " + CritiqueTABLE + "(aid,content,username) VALUES (#{AId},#{Content},#{UserName})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int add(Critique critique);

    @Select("select * from " + CritiqueTABLE + " where aid=#{aid}")
    List<Critique> selectByAId(@Param("AId") int AId);

    @Select("select count(*) from "+CritiqueTABLE+" where aid=#{AId}")
    int selectCritiqueCount(@Param("AId") int AId);

    List<Critique> selectByPage(final int AId, final Page page);
}
