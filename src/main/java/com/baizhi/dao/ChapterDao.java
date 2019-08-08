package com.baizhi.dao;

import com.baizhi.entity.Chapter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChapterDao {
    //添加一个音频
    public void insert(Chapter chapter);
    //查找同一个albumId的音频
    public List<Chapter> selectAll(@Param("albumId") String albumId, @Param("start") Integer start, @Param("rows") Integer rows);
    //查询总条数
    public Integer selectCount(String albumId);
    //删除一个音频
    public void delete(String id);
    //根据id查找一个音频
    public Chapter selectOne(String id);
    //根据id修改一个音频
    public void update(Chapter chapter);

}
