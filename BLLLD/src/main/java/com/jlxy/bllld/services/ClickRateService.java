package com.jlxy.bllld.services;

/**
 * Created by ORCHID on 2017/3/7.
 */
public interface ClickRateService {
    //判断是否点击过
    boolean isClick(int AId, String Ip);
}
