package com.baizhi.dao;

import com.baizhi.entity.Carousel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("carouselDao")
public interface CarouselDao {

    //查询所有
    public List<Carousel> selectAll(@Param("page") Integer page, @Param("rows") Integer rows);
    //查询总条数
    public Integer selectcount();
    //添加
    public void insert(Carousel carousel);

    //删除
    public void delete(String id);

    //修改
    public void update(Carousel carousel);

    //根据id查询一个
    public Carousel selectOne(String id);

    public void updateStatus(@Param("id") String id, @Param("status") String status);
}
