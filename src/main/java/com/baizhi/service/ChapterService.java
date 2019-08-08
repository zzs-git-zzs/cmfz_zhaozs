package com.baizhi.service;

import com.baizhi.entity.Chapter;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public interface ChapterService {

    //查所有分页
    public HashMap<String,Object> selectAll(String albumId,Integer start,Integer rows);

    //添加
    public String add(Chapter chapter);

    //删除
    public void delete(String id);

    //文件上传
    public HashMap<String,Object> uploadChapter(MultipartFile url, HttpServletRequest request,String id);

}
