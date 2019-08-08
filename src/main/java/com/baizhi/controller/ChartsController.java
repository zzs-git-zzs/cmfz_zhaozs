package com.baizhi.controller;


import com.baizhi.entity.Charts;
import com.baizhi.entity.City;
import com.baizhi.entity.Pro;
import com.baizhi.service.ChartsService;
import com.baizhi.service.Cityservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/charts")
@ResponseBody
public class ChartsController {

    @Autowired
    private ChartsService chartsService;
    @Autowired
    private Cityservice cityservice;

    @RequestMapping("/queryUser")
    public HashMap<String,Object> queryUser() {
        System.out.println("进入action");
        HashMap<String, Object> map = new HashMap<>();
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
        map.put("month",list);
        map.put("boys",list1);
        map.put("girls",list2);
        return map;
    }
//        Pro pro1 = new Pro("小姐姐",girls);
//        Pro pro2 = new Pro("小哥哥",boys);
//
//        //封装  最外层集合
//        ArrayList<Pro> pros = new ArrayList<>();
//        pros.add(pro1);
    @RequestMapping("/queryUserT")
    public List<Pro> queryUserT(){
        System.out.println("+++++++++++++++++++++++");
        List<Pro> pros = new ArrayList<>();
        List<City> boys = cityservice.selectAllCity("男");
        for (City boy : boys) {
            System.out.println(boy);
        }
        List<City> girls = cityservice.selectAllCity("女");
        Pro pro1 = new Pro("男孩", boys);
        Pro pro2 = new Pro("女孩", girls);
        pros.add(pro1);
        pros.add(pro2);
        return pros;
    }
}
