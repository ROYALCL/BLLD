package com.jlxy.bllld.mapper;

import com.jlxy.bllld.BaseJunitTest;
import com.jlxy.bllld.entity.Article;
import com.jlxy.bllld.entity.Critique;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ORCHID on 2017/3/26.
 */
public class CritiqueMapperTest extends BaseJunitTest {

    @Autowired
    CritiqueMapper critiqueMapper;

    @Autowired
    ArticleMapper articleMapper;

    @Test
    public void add() throws Exception {
        Critique critique=new Critique();
        critique.setArticle(articleMapper.selectById(2));
        critique.setContent("dfjkhgs");
        critique.setUserName("sdfa");
        critiqueMapper.add(critique);
    }

    @Test
    public void selectByAId() throws Exception {
        List<Critique> critiques=critiqueMapper.selectByAId(articleMapper.selectById(2));
        for(Critique critique:critiques){
            //System.out.println("Id:"+critique.getId()+",AId:"+critique.getAId()+",Content:"+critique.getContent()+",UserName:"+critique.getUserName());
        }
    }
}