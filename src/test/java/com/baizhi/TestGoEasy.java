package com.baizhi;


import com.alibaba.fastjson.JSONObject;
import com.baizhi.dao.UserDao;
import com.baizhi.entity.Charts;
import com.baizhi.entity.User;
import com.baizhi.service.ChartsService;
import io.goeasy.GoEasy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestGoEasy {

    @Resource
    private UserDao userDao;

    @Autowired
    private ChartsService chartsService;
    @Test
    public void testGoEasy(){

        Date date = new Date();
        userDao.regist(new User("20","123","123456","zz","zz","zz","zz","女","青海","11","11",date,"123"));
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<String> list = new ArrayList<>();
        //month: ["1月","2月","3月","42月","5月","6月"]
        //男孩: [5, 20, 36, 10, 10, 20]
        //女孩: [5, 20, 36, 10, 10, 20]
        Set<Integer> set = chartsService.selectMonth();
        for (Integer integer : set) {
            String str= integer+"月";
            //统计的月份
            list.add(str);
            //统计当月的男孩数量
            Charts charts1 = chartsService.selectAllByMonth("男", integer);
            list1.add(charts1.getCount());
            //统计当月的女孩
            Charts charts2 = chartsService.selectAllByMonth("女", integer);
            list2.add(charts2.getCount());
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("month",list);
        jsonObject.put("boys",list1);
        jsonObject.put("girls",list2);
        String content = jsonObject.toJSONString();
        GoEasy goEasy = new GoEasy( "http://rest-hangzhou.goeasy.io", "BC-ec0591bea40342be80bad8cc240ec43e");
        //参数：管道（表示）名称，发布的内容
        goEasy.publish("myChannelZ", content);


    }

}
