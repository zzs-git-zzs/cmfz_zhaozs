package com.baizhi.dao;

import com.baizhi.entity.Charts;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface ChartsDao {
    //查询所有，返回一个对象集合

    public Charts selectAllByMonth(@Param("sex") String sex, @Param("integer") Integer integer);

    //查询所有的月份
    public Set<Integer> selectMonth();

}
