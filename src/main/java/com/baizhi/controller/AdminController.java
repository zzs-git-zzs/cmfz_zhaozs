package com.baizhi.controller;


import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

import static com.baizhi.util.ImageCodeUtil.createImage;
import static com.baizhi.util.ImageCodeUtil.getSecurityCode;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @RequestMapping("/login")
    public String login(String enCode,String username, String password, HttpSession session)throws Exception{
        Admin admin = adminService.login(username, password);
        Object code = session.getAttribute("code");
        if (admin!=null&&enCode.equals(code)){
            session.setAttribute("username",username);
            return "main/main";
        }return "login/login";
    }
    //获取随机验证码的图片
    @RequestMapping("/getImageCode")
    public void getImageCode(HttpSession session, HttpServletResponse response)throws Exception{
        //获取随机字符
        String code = getSecurityCode();
        //在session里面存放一份验证码
        session.setAttribute("code",code);
        //打印随机字符
        System.out.println(code);
        //生成图片
        BufferedImage image = createImage(code);
        ServletOutputStream stream=null;//输出流为null
        try{
            stream=response.getOutputStream();//通过响应获取输出流
            ImageIO.write(image, "png", stream);//调用图片流的写方法，通过输出流写出图片
        }catch(Exception e){}
    }
    //安全退出
    @RequestMapping("/logout")
    public String logout(HttpSession session)throws Exception{
        /*
        查看销毁前是否还存在
        * Object username = session.getAttribute("username");
        *System.out.println(username);
        * */
        session.removeAttribute("username");
        /*
        查看是否销毁
         *Object username1 =session.getAttribute("username");
         *System.out.println(username1+"================================");
         * */
        return "login/login";
    }
}
