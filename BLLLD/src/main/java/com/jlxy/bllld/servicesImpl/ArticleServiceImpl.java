package com.jlxy.bllld.servicesImpl;

import com.jlxy.bllld.entity.Article;
import com.jlxy.bllld.entity.Page;
import com.jlxy.bllld.entity.Result;
import com.jlxy.bllld.mapper.ArticleMapper;
import com.jlxy.bllld.services.ArticleService;
import com.jlxy.bllld.utils.MethodName;
import com.jlxy.bllld.utils.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ORCHID on 2017/3/26.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean add(Article article) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        if (articleMapper.add(article) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<Article> showUserAllArticle(String username) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        return articleMapper.selectByUserAll(username);
    }

    public Result showUserArticleByPage(String username, Page page) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        page = PageUtil.createPage(page, articleMapper.selectUserAllCount(username));
        List<Article> all = articleMapper.selectByPage(username, page);
        return new Result(page, all);
    }

    public Result showArticleByPage(Page page) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        page = PageUtil.createPage(page, articleMapper.selectAllCount());
        List<Article> all = articleMapper.selectAllByPage(page);
        return new Result(page, all);
    }

    public Article showArticle(int id) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        return articleMapper.selectById(id);
    }
}
