package com.baizhi.service;

import com.baizhi.dao.ChartsDao;
import com.baizhi.entity.Charts;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Set;

@Service
@Transactional
public class ChartsServiceImpl implements ChartsService {
    @Resource
    private ChartsDao chartsDao;

    @Override
    public Charts selectAllByMonth(String sex, Integer integer) {
        Charts charts = chartsDao.selectAllByMonth(sex, integer);
        return charts;
    }

    @Override
    public Set<Integer> selectMonth() {
        Set<Integer> set = chartsDao.selectMonth();
        return set;
    }
}
