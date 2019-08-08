package com.baizhi.service;

import com.baizhi.dao.CarouselDao;
import com.baizhi.entity.Carousel;
import com.baizhi.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
@Transactional
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselDao carouselDao;

    @Override
    public List<Carousel> showAll(Integer page,Integer rows) {
        List<Carousel> carousels = carouselDao.selectAll(page,rows);
        return carousels;
    }

    @Override
    public Integer totalcount() {
        Integer totalcount = carouselDao.selectcount();
        return totalcount;
    }

    @Override
    public String add(Carousel carousel) {
       //补全属性
        String id = UUIDUtil.getUUID();
        carousel.setId(id);
        carousel.setStatus("1");
        carousel.setCupdate(new Date());
        carouselDao.insert(carousel);
        //返回添加对象的id
        return id;
    }

    @Override
    public void delteOne(String id) {
        carouselDao.delete(id);
    }

    @Override
    public void updateOne(Carousel carousel) {
        //carousel.setUpdate(new Date());
        carouselDao.update(carousel);
    }
    //只是读取数据，更改一下事务属性，效率会更快
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public Carousel showOne(String id) {

        Carousel carousel = carouselDao.selectOne(id);
        return carousel;
    }

    @Override
    public void updateStatus(String id, String status) {
        carouselDao.updateStatus(id,status);
    }
}
