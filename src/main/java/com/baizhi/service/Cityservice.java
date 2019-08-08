package com.baizhi.service;

import com.baizhi.entity.City;

import java.util.List;

public interface Cityservice {
    //查询所有城市中的男孩和女孩
    public List<City> selectAllCity(String sex);
}
