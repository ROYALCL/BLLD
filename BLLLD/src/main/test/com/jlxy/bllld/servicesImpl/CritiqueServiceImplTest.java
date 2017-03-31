package com.jlxy.bllld.servicesImpl;

import com.jlxy.bllld.BaseJunitTest;
import com.jlxy.bllld.entity.Critique;
import com.jlxy.bllld.services.ArticleService;
import com.jlxy.bllld.services.CritiqueService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by ORCHID on 2017/3/30.
 */
public class CritiqueServiceImplTest extends BaseJunitTest {
    @Autowired
    private CritiqueService critiqueService;

    @Autowired
    private ArticleService articleService;

    @Test
    public void showCritiqueByPage() throws Exception {
    }

    @Test
    public void addCritique() throws Exception {
        Critique critique=new Critique(articleService.showArticle(2),"sdfasda","haha");
        critiqueService.addCritique(critique);
    }

    @Test
    public void selectCritiqueCount() throws Exception {
        System.out.println(critiqueService.selectCritiqueCount(2));
    }

}