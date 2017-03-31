package com.jlxy.bllld.servicesImpl;

import com.jlxy.bllld.entity.Article;
import com.jlxy.bllld.entity.Critique;
import com.jlxy.bllld.entity.Page;
import com.jlxy.bllld.entity.Result;
import com.jlxy.bllld.mapper.ArticleMapper;
import com.jlxy.bllld.mapper.CritiqueMapper;
import com.jlxy.bllld.services.CritiqueService;
import com.jlxy.bllld.utils.MethodName;
import com.jlxy.bllld.utils.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ORCHID on 2017/3/30.
 */
@Service
public class CritiqueServiceImpl implements CritiqueService {

    @Autowired
    private CritiqueMapper critiqueMapper;

    @Autowired
    private ArticleMapper articleMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Result showCritiqueByPage(int AId, Page page) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        Article article=articleMapper.selectById(AId);
        page = PageUtil.createPage(page, critiqueMapper.selectCritiqueCount(article));
        List<Critique> all = critiqueMapper.selectByPage(article, page);
        Result result = new Result();
        result.setPage(page);
        result.setList(all);
        return result;
    }

    public void addCritique(Critique critique) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        critiqueMapper.add(critique);
    }

    public int selectCritiqueCount(int id) {
        logger.info("from class: " + this.getClass().getSimpleName() + " info-  function " + new MethodName().getMethodName() + " exec successful! ");
        return critiqueMapper.selectCritiqueCount(articleMapper.selectById(id));
    }
}
