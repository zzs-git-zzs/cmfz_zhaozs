package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    //查询所有
    public List<User> selectAll(@Param("start") Integer start, @Param("rows") Integer rows);

    //根据id，查一个

    public User selectOne(String id);

    //查询个数
    public Integer selectCount();

    public void updateStatus(@Param("id") String id,@Param("status") String status);

    public List<User> showAllTwo();

    //注册
    public void regist(User user);

}
