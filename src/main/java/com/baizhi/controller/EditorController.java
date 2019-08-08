package com.baizhi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

@Controller
@RequestMapping("/editor")
public class EditorController {

    @RequestMapping("/upload")
    @ResponseBody
    public void upload(MultipartFile imgFile, HttpServletRequest request){

        HashMap<String, Object> map = new HashMap<>();
        //获取文件名
        String realPath = request.getSession().getServletContext().getRealPath("/upload/editor");
        File file = new File(realPath);
        if (!file.exists()){
            file.mkdirs();
        }
        //获取文件名
        String filename = imgFile.getOriginalFilename();
        //加时间
        String name = new Date().getTime() + "_" + filename;
        try {
            imgFile.transferTo(new File(realPath,name));

            map.put("error",0);
            map.put("url","");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
