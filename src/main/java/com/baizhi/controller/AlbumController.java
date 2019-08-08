package com.baizhi.controller;


import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.HashMap;

@Controller
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    //查询所有
    @RequestMapping("/queryAll")
    @ResponseBody
    public HashMap<String,Object> queryAll(Integer page,Integer rows){
        HashMap<String, Object> map = albumService.showAll(page, rows);
        Object toale = map.get("toale");
        return map;
    }

    //增删改
    @RequestMapping("/edit")
    public String edit(Album album,String oper){
        String id=null;
        if (oper.equals("add")){
            id = albumService.add(album);
        }
        if (oper.equals("del")){
            albumService.delteOne(album.getId());
        }
        if(oper.equals("edit")){

        }
        return id;
    }

    //上传文件
    @RequestMapping("/uploadAlbum")
    public void uploadAlbum(MultipartFile coverImg, String id, HttpServletRequest request) {
        //获取要上传文件的文件夹路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload/album");
        //获取文件夹
        File file = new File(realPath);
        //没有就创建
        if (!file.exists()){
            file.mkdirs();
        }
        //获取上传文件的名字
        String filename = coverImg.getOriginalFilename();
        if (!filename.equals("")){
            String name=new Date()+"-"+filename;
            //上传文件
            try {
                coverImg.transferTo(new File(realPath,name));
            } catch (Exception e) {
                e.printStackTrace();
            }
            //修改文件
            Album album = new Album();
            album.setId(id);
            album.setCoverImg(name);
            albumService.updateOne(album);
        }
    }

}
