package com.jlxy.bllld.mapper;

import com.jlxy.bllld.BaseJunitTest;
import com.jlxy.bllld.entity.BlogInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ORCHID on 2017/3/25.
 */
public class BlogInfoMapperTest extends BaseJunitTest {

    @Autowired
    BlogInfoMapper blogInfoMapper;

    @Autowired
    UserMapper userMapper;

    @Test
    public void selectByName() throws Exception {
        List<BlogInfo> blogInfos=blogInfoMapper.selectByName("xiaoxiao");
        for(BlogInfo blogInfo:blogInfos){
            System.out.println("UId:"+blogInfo.getUser().getUId()+",Name:"+blogInfo.getName()+",Title:"+blogInfo.getBlogTitle()+",idiograph:"+blogInfo.getIdIograph());
        }
    }

    @Test
    public void update() throws Exception {
        BlogInfo blogInfo=new BlogInfo();
        blogInfo.setUser(userMapper.selectByName("haha"));
        blogInfo.setName("haha");
        blogInfo.setBlogTitle("heheheheh");
        blogInfo.setIdIograph("a;sdlk");
        blogInfoMapper.update(blogInfo);
    }
    @Test
    public void add() throws Exception {
        BlogInfo blogInfo=new BlogInfo();
        blogInfo.setUser(userMapper.selectByName("haha"));
        blogInfo.setName("heihei");
        blogInfo.setBlogTitle("heheheheh");
        blogInfo.setIdIograph("a;sdaslk");
        System.out.println(blogInfoMapper.add(blogInfo));
    }
}