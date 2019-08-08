package com.baizhi.controller;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/showAll")
    public HashMap<String,Object> showAll(Integer page,Integer rows){
        HashMap<String, Object> map = userService.showAll(page, rows);
        List<User> users = (List<User>) map.get("rows");
        for (User user : users) {
            System.out.println(user);
        }
        return map;
    }

    @RequestMapping("/updateStatus")
    @ResponseBody
    public HashMap<String,Object> updateStatus(String id,String status){
        userService.updateStatus(id,status);
        HashMap<String, Object> map = new HashMap<>();
        map.put("success","200");
        map.put("message","修改成功");
        return map;
    }

    @RequestMapping("/easyImport")
    @ResponseBody
    public HashMap<String,Object> easyImport(){
        List<User> users = userService.showAllTwo();
        for (User user : users) {
            String picImg = "src/main/webapp/upload/user/"+user.getPicImg();
            user.setPicImg(picImg);
        }
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户表","用户"), User.class, users);
        try {
            workbook.write(new FileOutputStream(new File("F://userEasyPoi.xls")));
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("success","200");
        map.put("message","导出成功");
        return map;

    }

    @RequestMapping("/regist")
    public String regist(User user){
        userService.regist(user);
        return "";
    }
}
