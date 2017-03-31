package com.jlxy.bllld.servicesImpl;

import com.jlxy.bllld.entity.Article;
import com.jlxy.bllld.entity.ClickRate;
import com.jlxy.bllld.mapper.ArticleMapper;
import com.jlxy.bllld.mapper.ClickRateMapper;
import com.jlxy.bllld.services.ClickRateService;
import com.jlxy.bllld.utils.MethodName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ORCHID on 2017/3/26.
 */
@Service
public class ClickRateServiceImpl implements ClickRateService {

    @Autowired
    private ClickRateMapper clickRateMapper;

    @Autowired
    private ArticleMapper articleMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean isClick(int AId, String Ip) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + "() exec successful! ");
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
//        Date time =new Date();
//        String times=sdf.format(time);
//        ParsePosition pos = new ParsePosition(0);
        Article article=articleMapper.selectById(AId);
        Date date=sdf.parse(sdf.format(new Date()),new ParsePosition(0));
        if (clickRateMapper.selectByAId(article, Ip,date).size() != 0) {
            return true;
        } else {
            //没有点击过，保存记录
            ClickRate clickRate = new ClickRate(article, Ip, date);
            clickRateMapper.add(clickRate);
            return false;
        }
    }
}