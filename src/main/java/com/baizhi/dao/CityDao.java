package com.baizhi.dao;

import com.baizhi.entity.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CityDao {
    //查询所有的城市即对应的男女人数
    public List<City> selectAllCity(@Param("sex") String sex);

}
