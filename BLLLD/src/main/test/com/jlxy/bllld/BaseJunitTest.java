package com.jlxy.bllld;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ORCHID on 2017/3/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:springframework/springframework.service.xml"})
public class BaseJunitTest {
    public Logger logger = LoggerFactory.getLogger(this.getClass());
}
