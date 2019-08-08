package com.baizhi.dao;

import com.baizhi.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleDao {

    //查询所有
    public List<Article> selectAll(@Param("start") Integer start, @Param("rows") Integer rows);
    //删除一个
    public void delete(String id);

    //查询个数
    public Integer selectCount();


}
