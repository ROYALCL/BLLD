package com.jlxy.bllld.daoImpl;

import com.jlxy.bllld.entity.BlogInfo;
import com.jlxy.bllld.entity.ClickRate;
import com.jlxy.bllld.entity.Critique;
import org.apache.ibatis.jdbc.SQL;

import static com.jlxy.bllld.utils.OrmConstans.BlogInfoTABLE;
import static com.jlxy.bllld.utils.OrmConstans.ClickRateTABLE;

/**
 * Created by ORCHID on 2017/3/30.
 */
public class ClickRateDynaSqlProvider {

    public String add(final ClickRate clickRate){
        return new SQL(){
            {
                INSERT_INTO(ClickRateTABLE);
                if(clickRate.getArticle()!=null){
                    VALUES("aid","#{Article.Id}");
                }
                if(clickRate.getIp()!=null){
                    VALUES("ip","#{Ip}");
                }
                if(clickRate.getTime()!=null){
                    VALUES("time","#{Time}");
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
