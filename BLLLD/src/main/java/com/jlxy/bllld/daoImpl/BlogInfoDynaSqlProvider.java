package com.jlxy.bllld.daoImpl;

import com.jlxy.bllld.entity.Article;
import com.jlxy.bllld.entity.BlogInfo;
import org.apache.ibatis.jdbc.SQL;

import static com.jlxy.bllld.utils.OrmConstans.ArticleTABLE;
import static com.jlxy.bllld.utils.OrmConstans.BlogInfoTABLE;

/**
 * Created by ORCHID on 2017/3/30.
 */
public class BlogInfoDynaSqlProvider {

    public String add(final BlogInfo blogInfo){
        return new SQL(){
            {
                INSERT_INTO(BlogInfoTABLE);
                if(blogInfo.getName()!=null){
                    VALUES("name","#{Name}");
                }
                if(blogInfo.getUser()!=null){
                    VALUES("uid","#{User.UId}");
                }
                if(blogInfo.getBlogTitle()!=null){
                    VALUES("blogtitle","#{BlogTitle}");
                }
                if(blogInfo.getIdIograph()!=null){
                    VALUES("idiograph","#{IdIograph}");
                }
            }
        }.toString();
    }

    public String update(final BlogInfo blogInfo){
        return new SQL(){
            {
                UPDATE(BlogInfoTABLE);
                if(blogInfo.getName()!=null){
                    SET("name=#{Name}");
                }
                if(blogInfo.getUser()!=null){
                    SET("uid=#{User.UId}");
                }
                if(blogInfo.getBlogTitle()!=null){
                    SET("blogtitle=#{BlogTitle}");
                }
                if(blogInfo.getIdIograph()!=null){
                    SET("idiograph=#{IdIograph}");
                }
                WHERE("id=#{Id}");
            }
        }.toString();
    }
}
