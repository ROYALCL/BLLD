package com.jlxy.bllld.services;

import com.jlxy.bllld.entity.Critique;
import com.jlxy.bllld.entity.Page;
import com.jlxy.bllld.entity.Result;

/**
 * Created by ORCHID on 2017/3/30.
 */
public interface CritiqueService {

    Result showCritiqueByPage(int AId, Page page);

    void addCritique(Critique critique);

    //获得评论数
    int selectCritiqueCount(int id);
}
