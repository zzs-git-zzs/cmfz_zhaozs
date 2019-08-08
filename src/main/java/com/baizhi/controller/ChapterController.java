package com.baizhi.controller;


import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.HashMap;

@Controller
@RequestMapping("/chapter")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    //展示所有
    @RequestMapping("/queryAll")
    @ResponseBody
    public HashMap<String,Object> queryAll(String albumId,Integer page,Integer rows){
        HashMap<String, Object> map = chapterService.selectAll(albumId, page, rows);
        return map;
    }

    //增删改
    @RequestMapping("/edit")
    @ResponseBody
    public String  edit(String oper, Chapter chapter,String albumId){
        String id=null;
        //添加音频
        if (oper.equals("add")){
            System.out.println(chapter+"+++++++++++++++");
            chapter.setAlbumId(albumId);
            id = chapterService.add(chapter);
        }
        //删除音频
        if (oper.equals("del")){
            chapterService.delete(chapter.getId());
        }
        return id;
    }

    //文件上传
    @RequestMapping("/uploadChapter")
    @ResponseBody
    public HashMap<String,Object> uploadChapter(MultipartFile url, String id, HttpServletRequest request){
        System.out.println("++++++++++++++++++++++++");
        HashMap<String, Object> map = chapterService.uploadChapter(url, request, id);
        return map;
    }

    //文件下载
    @RequestMapping("/downloadChapter")
    public void downloadChapter(String fileName, HttpServletRequest request, HttpServletResponse response){
        //获取文件所在路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload/music");
        //根据路径读取文件
        try {
            FileInputStream inputStream = new FileInputStream(new File(realPath, fileName));
            //设置文件响应格式       响应头        att：以附件的形式下载，inline：在线打开，可以放在参数列表中
            response.setHeader("content-disposition","attachment;fileNmae="+ URLEncoder.encode(fileName,"utf-8"));
            ServletOutputStream outputStream = response.getOutputStream();
            //文件下载
            IOUtils.copy(inputStream,outputStream);
            //关闭资源
            inputStream.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
