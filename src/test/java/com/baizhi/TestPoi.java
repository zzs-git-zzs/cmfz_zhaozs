package com.baizhi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baizhi.entity.Student;
import com.baizhi.entity.Teacher;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


        //创建一个工作簿  参数：名字（相当于sheet1，sheet2.。。。。）

public class TestPoi {



    @Test
    public void testpois(){
        Workbook workbook = new HSSFWorkbook();
        //创建一个工作簿  参数：名字（相当于sheet1，sheet2.。。。。）
        Sheet sheet = workbook.createSheet("用户信息表1");
        //创建一个行   参数（下表从0开始）
        Row row = sheet.createRow(0);
        //创建一个单元格 ，参数 单元格下标（从0开始）
        Cell cell = row.createCell(0);
        //给单元格设置内容
        cell.setCellValue("这是第一行第一个单元格");
        //到处单元格
        try {
            workbook.write(new FileOutputStream(new File("F:\\TestPoi.xls")));
            //关流释放资源
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testExports(){

        //结合项目时，调用数据库的数据，就不能写死成Student
        Student student = new Student("1", "小黑", 16, new Date());
        Student student1 = new Student("2", "小白", 16, new Date());
        Student student2 = new Student("3", "小黄", 16, new Date());
        Student student3 = new Student("4", "小三", 16, new Date());
        Student student4 = new Student("5", "小黑", 16, new Date());
        Student student5 = new Student("6", "小黑", 16, new Date());
        List<Student> students = Arrays.asList(student, student1, student2, student3, student4, student5);
        //创建一个excel文档
        Workbook workbook = new HSSFWorkbook();
        //创建一个工作簿  参数：名字（相当于sheet1，sheet2.。。。。）
        Sheet sheet = workbook.createSheet("用户信息表1");
       //创建一个标题行
        Row row2 = sheet.createRow(0);
        row2.createCell(0).setCellValue("学生信息");
        //合并行 参数 ：起始行 结束行  起始单元格 结束单元格
        CellRangeAddress cellAddresses = new CellRangeAddress(0, 0, 0, 3);
        sheet.addMergedRegion(cellAddresses);
        //设置列宽
        sheet.setColumnWidth(3,20*256);
        //设置日期格式
        Font font = workbook.createFont();
        font.setFontHeightInPoints((short)24);//设置字体大小
        font.setBold(true);//字体加粗
        font.setColor(Font.COLOR_RED);//设置字体颜色
        font.setFontName("宋体");//设置字体
        font.setItalic(true);//设置斜体
        //创建样式对象
        CellStyle cellStyle1 = workbook.createCellStyle();
        cellStyle1.setFont(font);

        //创建yi行   参数（下表从0开始）
        Row row = sheet.createRow(1);
        
        row.setHeight((short)800);
        String[] title={"ID","名字","年龄","生日"};
        //处理单元格对象
        Cell cell=null;
        for(int i=0;i<title.length;i++){
            cell=row.createCell(i);//单元格下表
            cell.setCellValue(title[i]);//单元格内容
            //给字体设置样式
            cell.setCellStyle(cellStyle1);
        }
        //创建一个样式对象
        CellStyle cellStyle = workbook.createCellStyle();
        //创建一个日期格式对象
        DataFormat dataFormat = workbook.createDataFormat();
        //将日期格式放入样式对象中
        cellStyle.setDataFormat(dataFormat.getFormat("yyyy年MM月dd日"));
        //处理数据行数据
        for (int i = 0; i < students.size(); i++) {
            //创建行
            Row row1 = sheet.createRow(i + 1);
            //创建单元格
            Cell cell1 = row1.createCell(0);
            row1.createCell(0).setCellValue(students.get(i).getId());
            row1.createCell(1).setCellValue(students.get(i).getName());
            row1.createCell(2).setCellValue(students.get(i).getAge());
            //处理日期数据

            Cell cell2 = row1.createCell(3);
            cell2.setCellValue(students.get(i).getBir());
            cell2.setCellStyle(cellStyle);
            //设置单元格内容


        }


        try {
            workbook.write(new FileOutputStream(new File("F:\\TestPoi.xls")));
            //关流释放资源
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPoiImport(){

        try {
            //获取要导入的文件
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(new File("F:\\TestPoi.xls")));
            //获取工作簿(shett1 的名字)
            HSSFSheet sheet = workbook.getSheet("用户信息表1");

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                //获取行
                Row row = sheet.getRow(i);
                Student student = new Student();
                Cell cell = row.getCell(0);
                String id = cell.getStringCellValue();
                student.setId(id);
                student.setName(row.getCell(1).getStringCellValue());
                student.setAge((int)row.getCell(2).getNumericCellValue());
                student.setBir(row.getCell(3).getDateCellValue());
                //调用一个插入数据库的方法

                System.out.println(student);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testEasyPoi(){
        Student student = new Student("1", "小黑", 16, new Date());
        Student student1 = new Student("2", "小白", 16, new Date());
        Student student2 = new Student("3", "小黄", 16, new Date());
        Student student3 = new Student("4", "小三", 16, new Date());
        Student student4 = new Student("5", "小黑", 16, new Date());
        Student student5 = new Student("6", "小黑", 16, new Date());

        ArrayList<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        //参数：标题，表名，实体类类对象，导出的集合
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生","学生"),Student.class, students);
        try {
            workbook.write(new FileOutputStream(new File("F:\\testEasyPoi.xls")));
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testEasyPois(){
        Student student = new Student("1", "小黑", 16, new Date());
        Student student1 = new Student("2", "小白", 16, new Date());
        Student student2 = new Student("3", "小黄", 16, new Date());
        Student student3 = new Student("4", "小三", 16, new Date());
        Student student4 = new Student("5", "小黑", 16, new Date());
        Student student5 = new Student("6", "小黑", 16, new Date());
        ArrayList<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("1","sunc",students));
        teachers.add(new Teacher("2","hxz",students));
        teachers.add(new Teacher("3","ccp",students));
        //参数：标题，表名，实体类类对象，导出的集合
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生","学生"),Teacher.class, teachers);
        try {
            workbook.write(new FileOutputStream(new File("F:\\testEasyPoi.xls")));
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testEasyPoisInport(){
        //创建导入对象
        ImportParams params = new ImportParams();
        params.setTitleRows(1); //表格标题行数,默认0
        params.setHeadRows(2);  //表头行数,默认1

        //获取导入数据
        try {
            List<Teacher> teachers = ExcelImportUtil.importExcel(new FileInputStream(new File("F://TestEasyPoi.xls")),Teacher.class, params);
            for (Teacher teacher : teachers) {
                System.out.println(teacher);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test9(){
        Date date = new Date();
        int month = date.getMonth();
        System.out.println(month);
    }

}
