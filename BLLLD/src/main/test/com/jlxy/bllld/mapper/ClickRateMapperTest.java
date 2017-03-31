package com.jlxy.bllld.mapper;

import com.jlxy.bllld.BaseJunitTest;
import com.jlxy.bllld.entity.ClickRate;
import com.jlxy.bllld.utils.MethodName;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ORCHID on 2017/3/26.
 */
public class ClickRateMapperTest extends BaseJunitTest {

    @Autowired
    ClickRateMapper clickRateMapper;

    @Autowired
    ArticleMapper articleMapper;

    @Test
    public void add() throws Exception {
        ClickRate clickRate=new ClickRate();
        //clickRate.setArtilce();
        clickRate.setIp("123456");
        clickRate.setTime(new Date());
        System.out.println(clickRateMapper.add(clickRate));
    }

    @Test
    public void selectByAId() throws Exception {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
//        Date time =new Date();
//        String times=sdf.format(time);
//        ParsePosition pos = new ParsePosition(0);
        Date date=sdf.parse("2009-12-27");
        logger.info(date.toString());
        List<ClickRate> clickRates=clickRateMapper.selectByAId(articleMapper.selectById(1),"0:0:0:0:0:0:0:1",date);
        for(ClickRate clickRate:clickRates){
             //System.out.println("Id:"+clickRate.getId()+",AId:"+clickRate.getAId()+",Ip:"+clickRate.getIp()+",Time:"+clickRate.getTime());
        }
    }

}