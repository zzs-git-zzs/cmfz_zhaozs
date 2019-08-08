package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.HashMap;
import java.util.List;

public interface UserService {
    //查所有
    public HashMap<String,Object> showAll(Integer page, Integer rows);


    public void updateStatus(String id,String status);

    public List<User> showAllTwo();

    public void regist(User user);

}
