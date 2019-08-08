package com.baizhi.service;


import com.baizhi.entity.Charts;

import java.util.Set;


public interface ChartsService {
    //查当月的男女注册数量
    public Charts selectAllByMonth(String sex,Integer integer);

    //查询统计的月
    public Set<Integer> selectMonth();

}
