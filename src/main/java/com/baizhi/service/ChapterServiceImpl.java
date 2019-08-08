package com.baizhi.service;

import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Chapter;
import com.baizhi.util.UUIDUtil;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {

    @Resource
    private ChapterDao chapterDao;

    @Override
    public HashMap<String, Object> selectAll(String albumId, Integer page, Integer rows) {
        HashMap<String, Object> map = new HashMap<>();
        //每页展示的数据
        List<Chapter> chapters = chapterDao.selectAll(albumId, (page-1) * rows, rows);
        //总条数
        Integer count = chapterDao.selectCount(albumId);
        //总页数
        Integer total=count%rows==0?count/rows:count/rows+1;
        map.put("page",page);
        map.put("rows",chapters);
        map.put("total",total);
        map.put("records",count);
        return map;

    }

    @Override
    public String add(Chapter chapter) {
        String id= UUIDUtil.getUUID();
        chapter.setId(id);
        Date date=new Date();
        chapter.setUpDate(date);
        chapterDao.insert(chapter);
        return id;
    }

    @Override
    public void delete(String id) {
        chapterDao.delete(id);
    }

    @Override
    public HashMap<String,Object> uploadChapter(MultipartFile url, HttpServletRequest request, String id) {
        HashMap<String, Object> map = new HashMap<>();
        //获取要上传文件的文件夹的名字
        String realPath = request.getSession().getServletContext().getRealPath("/upload/music");
        File file = new File(realPath);
        if (!file.exists()){
            file.mkdirs();
        }
        System.out.println(realPath+"+++++++++++");
        //获取上传文件的名字
        String filename = url.getOriginalFilename();
        String name=new Date().getTime()+"-"+filename;

        try {
            System.out.println(name+"++++++++++++");
            url.transferTo(new File(realPath,name));

            //获取文件大小-1,没有小数，只取一个整数
            long size= url.getSize();
            String sizes=size/1024/1024+"MB";

            //获取文件大小-2,可以设置小数位
            DecimalFormat format = new DecimalFormat("0.00");
            String str=String.valueOf(size);
            double dd = Double.valueOf(str)/1024/1024;
            String newSize = format.format(dd) + "MB";
            //获取文件时长
            AudioFileIO fileIO = new AudioFileIO();
            AudioFile audio = fileIO.readFile(new File(realPath, name));
            AudioHeader audioHeader = audio.getAudioHeader();
            //获取时长  分钟
            int length = audioHeader.getTrackLength();
            String duration=length/60+"分"+length%60+"秒";
            Chapter chapter = new Chapter();
            chapter.setId(id);
            chapter.setUrl(name);
            chapter.setDuration(duration);
            chapterDao.update(chapter);
            map.put("success","200");
            map.put("message","上传成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success","400");
            map.put("message","上传失败");
        }
            return map;
    }
}
