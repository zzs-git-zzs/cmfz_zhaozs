package com.baizhi.service;

import com.baizhi.dao.CityDao;
import com.baizhi.entity.City;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
@Transactional
public class CityserviceImpl implements Cityservice {

    @Resource
   private CityDao cityDao;
    @Override
    public List<City> selectAllCity(String sex) {
        List<City> cities = cityDao.selectAllCity(sex);
        return cities;
    }
}
