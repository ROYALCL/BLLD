package com.jlxy.bllld.utils;

import org.apache.ibatis.javassist.bytecode.stackmap.TypeData;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ORCHID on 2017/3/30.
 */
public class nameTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Test
    public void ttest() {
        logger.info("from class: "+this.getClass().getSimpleName()+" info-  function: "+ new MethodName().getMethodName()+" exec successful! ");
    }

    @Test
    public void tttest(){
        logger.info(new MethodName().getMethodName());
        logger.info(this.getClass().getSimpleName());
    }
}
