package com.baizhi.service;

import java.util.HashMap;

public interface ArticleService {

    //查所有
    public HashMap<String,Object> showAll(Integer page, Integer rows);

    //shanchuyige
    public void delte(String id);

}
