package com.baizhi.dao;

import com.baizhi.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumDao {

    //添加专辑
    public void insert(Album album);
    //查询所有专辑
    public List<Album> selectAll(@Param("start")Integer start, @Param("rows")Integer rows);
    //查询总条数
    public Integer selectCount();
    //删除专辑
    public void delete(String id);
    //修改专辑
    public void update(Album album);
    //根据一个id修改专辑
    public Album selectOne(String id);
    //根据一个id查找一个Album对象
    public Album selectOneAlbum(String id);
}
