package com.jlxy.bllld.mapper;

import java.io.Serializable;
import java.util.List;

/**
 * BaseDAO 定义DAO的通用操作
 * 通过接口编程
 *
 * @param <T> 泛型用于解耦，同时避免写重复代码
 * @param <PK>
 * Created by CHENLI on 2017/3/4.
 */
public interface BaseMapper<T,PK extends Serializable> {

//    /**
//     * 插入一个实体
//     * @param t 待添加的对象
//     * @return 返回受影响的行数
//     */
//    int insert(T t);
//
//    /**
//     * 删除某个对象，在企业开发中，我们一般不做物理删除，只是添加某个字段对其数据进行可用控制
//     *
//     * @param pk 根据实体主键删除一个实体
//     * @return 返回受影响的条数
//     */
//    int delete(PK pk);
//
//    /**
//     * 更新某个对象
//     *
//     * @param t 待更新对象
//     * @return 返回受影响的条数
//     */
//    int update(T t);
//
//    /**
//     * 通过ID查找一个对象
//     *
//     * @param key 待查询的对象的ID
//     * @return 返回该ID对应的对象
//     */
//    T selectById(T key);
//
//    /**
//     * 查找对象集合
//     *
//     * @return 返回对象集合
//     */
//    List<T> selectAll();
}