package com.jlxy.bllld.dao;

import com.jlxy.bllld.entity.ClickRate;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

import static com.jlxy.bllld.utils.OrmConstans.ClickRateTABLE;

/**
 * Created by ORCHID on 2017/3/25.
 */
@Repository
public interface ClickRateDao {

    @Insert("insert into "+ClickRateTABLE+"(aid,ip,time) VALUES (#{AId},#{Ip},#{Time})")
    @Options(useGeneratedKeys=true,keyProperty = "id")
    int add(ClickRate clickRate);

    @Select("select * from "+ClickRateTABLE+" where aid=#{aid} and ip=#{ip} and time=#{time}")
    List<ClickRate> selectByAId(@Param("aid") int aid, @Param("ip") String ip, @Param("time") Date time);

}
