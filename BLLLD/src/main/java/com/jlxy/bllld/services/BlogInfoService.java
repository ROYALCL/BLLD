package com.jlxy.bllld.services;

import com.jlxy.bllld.entity.BlogInfo;

/**
 * Created by ORCHID on 2017/3/7.
 */
public interface BlogInfoService {

    //设置个性化内容
    void save(BlogInfo info);

    //获得
    BlogInfo selectBlogInfoByName(String username);
}
