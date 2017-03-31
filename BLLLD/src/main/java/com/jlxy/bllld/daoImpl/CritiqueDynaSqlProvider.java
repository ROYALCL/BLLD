package com.jlxy.bllld.daoImpl;

import com.jlxy.bllld.entity.BlogInfo;
import com.jlxy.bllld.entity.ClickRate;
import com.jlxy.bllld.entity.Critique;
import org.apache.ibatis.jdbc.SQL;

import static com.jlxy.bllld.utils.OrmConstans.ClickRateTABLE;
import static com.jlxy.bllld.utils.OrmConstans.CritiqueTABLE;

/**
 * Created by ORCHID on 2017/3/30.
 */
public class CritiqueDynaSqlProvider {

    public String add(final Critique critique){
        return new SQL(){
            {
                INSERT_INTO(CritiqueTABLE);
                if(critique.getArticle()!=null){
                    VALUES("aid","#{Article.Id}");
                }
                if(critique.getContent()!=null){
                    VALUES("content","#{Content}");
                }
                if(critique.getUserName()!=null){
                    VALUES("username","#{UserName}");
                }
            }
        }.toString();
    }

    public String update(final Critique critique){
        return new SQL(){
            {

            }
        }.toString();
    }
}
