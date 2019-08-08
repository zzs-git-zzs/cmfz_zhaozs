package com.baizhi.controller;


import com.baizhi.entity.Carousel;
import com.baizhi.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/banner")
public class CarouselController {

    @Autowired
    private CarouselService carouselService;
    @RequestMapping("/showAll")
    @ResponseBody
    public Map<String,Object> showAll(Integer page, Integer rows) throws Exception{
        List<Carousel> users = carouselService.showAll(page,rows);
        Integer totalcount = carouselService.totalcount();
        Map<String, Object> map = new HashMap<>();
        //当前页数
        map.put("page",page);
        //总条数
        map.put("records",totalcount);
        //总页数
        Integer pageCount=0;
        if(totalcount%rows==0){
            pageCount=totalcount/rows;
            System.out.println(pageCount+"==========");
        }else{
            pageCount=totalcount/rows+1;
            System.out.println(pageCount+"------------");
        }
        map.put("total",pageCount);
        map.put("rows",users);
        return map;
    }

    @RequestMapping("/edit")
    @ResponseBody
    public String edit(Carousel carousel,String oper){
        String id=null;
        //执行添加方法
        if(oper.equals("add")){
           id = carouselService.add(carousel);
        }
        //执行修改方法
        if(oper.equals("edit")){
            Carousel carousel1 = carouselService.showOne(carousel.getId());
            id=carousel1.getId();
            //System.out.println(carousel.getPath()+"修改方法的path");
            //System.out.println(carousel+"++++++++++++++++++++++++++");
            carousel.setStatus(carousel1.getStatus());
            if(carousel.getPath()==""){
                carousel.setPath(carousel1.getPath());
            }
            carousel.setCupdate(carousel1.getCupdate());
            //System.out.println(carousel+"修改方法的carousel");
           carouselService.updateOne(carousel);

        }
        //执行删除方法
        if(oper.equals("del")){
            carouselService.delteOne(carousel.getId());
        }
        return id;
    }
    //文件上传
    @RequestMapping("/uploadBanner")
    public void uploadBanner(MultipartFile path, String id, HttpServletRequest request){
        //获取要上传文件夹的路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload/photo");
        //获取文件夹
        File file = new File(realPath);
        //创建文件夹
        if (!file.exists()){
            file.mkdirs();
        }

        //获取上传文件的名字
        String filename =path.getOriginalFilename();
        //System.out.println(filename+"上传filename111111111111");
        if (filename.equals("")){
        }else {
           // System.out.println(filename+"上传filename");
            //给名字加一个时间的字符串，这样上传同一张图片也没问题
            String name = new Date().getTime() + filename;
            Carousel carousel=new Carousel();
            //文件上传
            try {
                path.transferTo(new File(realPath,name));
            } catch (IOException e) {
                e.printStackTrace();
            }
            //做修改

            carousel.setId(id);
            carousel.setPath(name);
            //System.out.println(id+"上传");
            //System.out.println(carousel+"上传");
            //System.out.println(name+"上传");
            carouselService.updateOne(carousel);
        }
    }

    @RequestMapping("/updateStatus")
    @ResponseBody
    public HashMap<String,Object> updateStatus(String id,String status){
        carouselService.updateStatus(id,status);
        HashMap<String, Object> map = new HashMap<>();
        map.put("success","200");
        map.put("message","修改成功");
        return map;
    }
}
