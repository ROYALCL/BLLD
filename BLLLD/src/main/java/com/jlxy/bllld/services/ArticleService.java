package com.jlxy.bllld.services;

import com.jlxy.bllld.entity.Article;
import com.jlxy.bllld.entity.Page;
import com.jlxy.bllld.entity.Result;

import java.util.List;

/**
 * Created by ORCHID on 2017/3/7.
 */
public interface ArticleService {
    //进行文章的保存
    boolean add(Article article);

    //取出用户所有的文章
    List<Article> showUserAllArticle(String username);

    //分页显示用户文章
    Result showUserArticleByPage(String username, Page page);

    //分页显示全部文章
    Result showArticleByPage(Page page);

    //显示文章
    Article showArticle(int id);

}
