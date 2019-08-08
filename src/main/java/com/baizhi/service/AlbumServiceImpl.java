package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import com.baizhi.util.UUIDUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Resource
    private AlbumDao albumDao;

    @Override
    public HashMap<String, Object> showAll(Integer page, Integer rows) {
        HashMap<String, Object> map = new HashMap<>();
        //获取分页的对象
        List<Album> albums = albumDao.selectAll((page-1)*rows, rows);
        //获取分页的总条数
        Integer count = albumDao.selectCount();
        //获取总页数
        Integer total=count%rows==0?count/rows:count/rows+1;
        map.put("page",page);
        map.put("rows",albums);
        map.put("total",total);
        map.put("records",count);
        return map;
    }

    @Override
    public Integer totalcount() {
        Integer count = albumDao.selectCount();
        return count;
    }

    @Override
    public String add(Album album) {
        String id= UUIDUtil.getUUID();
        Date date =new Date();
        album.setId(id);
        album.setPubDate(date);
        albumDao.insert(album);
        return id;
    }

    @Override
    public void delteOne(String id) {
        albumDao.delete(id);
    }

    @Override
    public void updateOne(Album album) {
        albumDao.update(album);

    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public Album showOne(String id) {
        Album album = albumDao.selectOneAlbum(id);
        return album;
    }
}
