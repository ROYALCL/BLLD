package com.jlxy.bllld.servicesImpl;

import com.jlxy.bllld.entity.BlogInfo;
import com.jlxy.bllld.mapper.BlogInfoMapper;
import com.jlxy.bllld.services.BlogInfoService;
import com.jlxy.bllld.utils.MethodName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ORCHID on 2017/3/26.
 */
@Service
public class BlogInfoServiceImpl implements BlogInfoService {

    @Autowired
    private BlogInfoMapper blogInfoMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void save(BlogInfo info) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        blogInfoMapper.update(info);
    }

    public BlogInfo selectBlogInfoByName(String username) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        List<BlogInfo> blogInfos = blogInfoMapper.selectByName(username);
        if (blogInfos.size() == 0) {
            return null;
        } else {
            return blogInfos.get(0);
        }
    }
}
