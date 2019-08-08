package com.baizhi;

import com.baizhi.dao.*;
import com.baizhi.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmfzZhaozsApplicationTests {

    @Autowired
    private AdminDao adminDao;

    @Resource
    private ChapterDao chapterDao;
    @Resource
    private UserDao userDao;
    @Resource
    private ArticleDao articleDao;

    @Resource
    private ChartsDao chartsDao;
    @Resource
    private CityDao cityDao;


    @Autowired
    private CarouselDao carouselDao;
    @Test
    public void contextLoads() {
        Admin admin = adminDao.select("zzs", "123456");
        System.out.println(admin);
    }

    @Test
    public void test1(){

        List<Carousel> carousels = carouselDao.selectAll(1, 2);
        for (Carousel carousel : carousels) {
            System.out.println(carousel);
        }
    }
    @Resource
    private AlbumDao albumDao;



    @Test
    public void test3(){
        Date date=new Date();
        albumDao.update(new Album("1","名字6","作者6",12.0,"图片","xxx",31,"很好的专辑",date));
    }
    @Test
    public void test4(){
        Date date=new Date();
        chapterDao.update(new Chapter("1","路径6","时长6","xxx",date,"1"));
    }

    @Test
    public void test5(){
        List<Album> albums = albumDao.selectAll(1, 2);
        for (Album album : albums) {
            System.out.println(album);
        }
    }
    @Test
    public void test6(){
        Integer count = albumDao.selectCount();
        System.out.println(count);
    }

    @Test
    public void test7(){
        List<Chapter> chapters = chapterDao.selectAll("1", 1, 2);
        for (Chapter chapter : chapters) {
            System.out.println(chapter);
        }
    }

    @Test
    public void test8(){
        List<User> users = userDao.selectAll(1, 6);
        for (User user : users) {
            System.out.println(user);
        }

    }
    @Test
    public void test9(){
        Integer count = articleDao.selectCount();
        System.out.println(count);

    }
    @Test
    public void test10(){
        Charts charts = chartsDao.selectAllByMonth("女", 1);
        System.out.println(charts);
    }
    @Test
    public void test11(){
        Set<Integer> set = chartsDao.selectMonth();
        for (Integer integer : set) {
            System.out.println(integer);
        }
    }

    @Test
    public void test12(){
        List<City> list = cityDao.selectAllCity("男");
        for (City city : list) {
            System.out.println(city);
        }
    }
    @Test
    public void test13(){
        userDao.regist(new User("zz","zz","zz","zz","zz","zz","zz","zz","zz","zz","zz",new Date(),"yy"));
    }

}
