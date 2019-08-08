package com.baizhi.service;

import com.baizhi.dao.ArticleDao;
import com.baizhi.entity.Article;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;


@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleDao articleDao;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public HashMap<String, Object> showAll(Integer page, Integer rows) {
        HashMap<String, Object> map = new HashMap<>();
        Integer count = articleDao.selectCount();
        List<Article> articles = articleDao.selectAll((page - 1) * rows, rows);
        Integer total=count%rows==0?count/rows:count/rows+1;
        map.put("page",page);
        map.put("rows",articles);
        map.put("total",total);
        map.put("records",count);
        return map;
    }

    @Override
    public void delte(String id) {
        articleDao.delete(id);
    }
}
