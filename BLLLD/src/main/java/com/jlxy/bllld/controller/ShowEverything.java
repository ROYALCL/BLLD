package com.jlxy.bllld.controller;

import com.jlxy.bllld.entity.Article;
import com.jlxy.bllld.entity.Page;
import com.jlxy.bllld.entity.Result;
import com.jlxy.bllld.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ORCHID on 2017/3/30.
 */
@Controller
@RequestMapping("/LR")
public class ShowEverything {

    @Autowired
    private ArticleService articleService;

//    @Autowired
//    private ArticleService articleService;

//    @RequestMapping(value = "/reg", method = RequestMethod.POST)
//    public ModelAndView reg(HttpServletRequest request, HttpServletResponse response) {
//        //通过调用业务逻辑组件来完成查询
//        Page page = new Page();
//        page.setCurrentPage(this.getCurrentPage());
//        page.setEveryPage(10);
//
//        Result result = articleService.showArticleByPage(page);
//        page = result.getPage();
//        List<Article> all = result.getList();
//
//        List critiqueCounts = new ArrayList();
//        for(Article article : all) {
//            critiqueCounts.add(articleService.getCritiqueCount(article.getId()));
//        }
//
//        //把查询到的结果保存在一个范围，request
//        request.setAttribute("all", all);
//        request.setAttribute("page", page);
//        request.setAttribute("critiqueCounts",critiqueCounts);
//    }
}
