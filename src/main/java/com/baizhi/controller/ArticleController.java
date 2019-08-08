package com.baizhi.controller;


import com.baizhi.entity.Article;
import com.baizhi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @RequestMapping("/showAll")
    @ResponseBody
    public HashMap<String,Object> showAll(Integer page,Integer rows){
        HashMap<String, Object> map = articleService.showAll(page, rows);
        return map;
    }

    @RequestMapping("/edit")
    public void edit(String oper, Article article){
        if (oper.equals("del")){
            articleService.delte(article.getId());
        }
    }
}
