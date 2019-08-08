package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.HashMap;

public interface AlbumService {
    //查询所有
    public HashMap<String, Object> showAll(Integer page, Integer rows);
    //查询总条数
    public Integer totalcount();
    //添加
    public String add(Album album);

    //删除
    public void delteOne(String id);
    //修改
    public void updateOne(Album album);

    //查询一个，回显用
    public Album showOne(String id);


}
