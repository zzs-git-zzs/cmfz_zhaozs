package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public HashMap<String,Object> showAll(Integer page, Integer rows) {
        HashMap<String, Object> map = new HashMap<>();
        Integer count = userDao.selectCount();//总条数
        List<User> users = userDao.selectAll((page - 1) * rows, rows);
        Integer total=count%rows==0?count/rows:count/rows+1;
        map.put("page",page);
        map.put("rows",users);
        map.put("total",total);
        map.put("records",count);
        return map;
    }

    @Override
    public void updateStatus(String id, String status) {
        userDao.updateStatus(id,status);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public List<User> showAllTwo() {
        List<User> users = userDao.showAllTwo();
        return users;
    }

    @Override
    public void regist(User user) {
        userDao.regist(user);
    }

}
