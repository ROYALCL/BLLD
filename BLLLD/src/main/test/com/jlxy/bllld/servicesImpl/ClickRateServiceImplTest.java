package com.jlxy.bllld.servicesImpl;

import com.jlxy.bllld.BaseJunitTest;
import com.jlxy.bllld.services.ClickRateService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ORCHID on 2017/3/30.
 */
public class ClickRateServiceImplTest extends BaseJunitTest {
 //   private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ClickRateService clickRateService;

    @Test
    public void isClick() throws Exception {
        if(clickRateService.isClick(1,"123456")){
            logger.info("已存在");
        }else {
            logger.info("已保存");
        }
    }

}