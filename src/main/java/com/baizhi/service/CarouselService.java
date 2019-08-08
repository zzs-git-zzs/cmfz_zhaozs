package com.baizhi.service;

import com.baizhi.entity.Carousel;

import java.util.List;

public interface CarouselService {

    //查询所有
    public List<Carousel> showAll(Integer page,Integer rows);
    //查询总条数
    public Integer totalcount();
    //添加
    public String add(Carousel carousel);

    //删除
    public void delteOne(String id);
    //修改
    public void updateOne(Carousel carousel);

    //查询一个，回显用
    public Carousel showOne(String id);

    public void updateStatus(String id,String status);


}
