package com.foodorder.dao.base;

/**
 * 定义mybatis生成增，删，改，查基类
 *
 * @author allen
 *
 * @param <T> 子类的对象
 * @param <K> 子类对象的主键类型
 */
public interface IBaseMapper<T, K> {
    /**/
    int deleteByPrimaryKey(K id);

    int insert(final T record);

    int insertSelective(final T record);

    T selectByPrimaryKey(K id);

    int updateByPrimaryKeySelective(final T record);

    int updateByPrimaryKey(final T record);
}