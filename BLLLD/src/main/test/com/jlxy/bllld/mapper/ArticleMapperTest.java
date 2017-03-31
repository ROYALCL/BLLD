package com.jlxy.bllld.mapper;

import com.jlxy.bllld.BaseJunitTest;
import com.jlxy.bllld.entity.Article;
import com.jlxy.bllld.entity.Page;
import com.jlxy.bllld.entity.User;
import com.jlxy.bllld.utils.PageUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ORCHID on 2017/3/25.
 */
public class ArticleMapperTest extends BaseJunitTest {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectByUserAll() throws Exception {
        List<Article> articles=articleMapper.selectByUserAll("haha");
        for(Article article:articles){
            System.out.println("Id:"+article.getId()+",UId:"+article.getUser().getUId()+",Title:"+article.getTitle()+",Content:"+article.getContent()+",Name:"+article.getName()+",Date:"+article.getDate()+",HasRead:"+article.getHasRead());
        }
    }

    @Test
    public void add() throws Exception {
        User user=userMapper.selectByName("haha");
        logger.info(user.PrintEntity());
        Article article=new Article();
        article.setUser(user);
        article.setName("haha");
        article.setContent("hi");
        article.setDate(new Date());
        article.setTitle("no");
        article.setHasRead(100);
        System.out.println(articleMapper.add(article));
    }

    @Test
    public void selectByAllCount() throws Exception {
        System.out.println(articleMapper.selectUserAllCount("haha"));
    }

    @Test
    public void selectAllByPage() throws Exception {
        Page page= PageUtil.createPage(5,34,7);
        List<Article> articles=articleMapper.selectAllByPage(page);
        for(Article article:articles){
            //System.out.println("Id:"+article.getId()+",UId:"+article.getUId()+",Title:"+article.getTitle()+",Content:"+article.getContent()+",Name:"+article.getName()+",Date:"+article.getDate()+",HasRead:"+article.getHasRead());
        }
    }

    @Test
    public void selectAllCount() throws Exception {
        System.out.println(articleMapper.selectAllCount());
    }

    @Test
    public void selectById() throws Exception {
        Article article=articleMapper.selectById(2);
            System.out.println("Id:"+article.getId()+",UId:"+article.getUser().getUId()+",Title:"+article.getTitle()+",Content:"+article.getContent()+",Name:"+article.getName()+",Date:"+article.getDate()+",HasRead:"+article.getHasRead());
    }

}