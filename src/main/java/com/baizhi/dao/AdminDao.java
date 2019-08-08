package com.baizhi.dao;

import com.baizhi.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component("adminDao")
public interface AdminDao {
    //验证用户名
    public Admin selectOne(String username);
    //登入
    public Admin select(@Param(value = "username") String username, @Param(value = "password") String password);
}
