package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;

import java.util.Date;

public class User {
    @ExcelIgnore
    private String id;
    @Excel(name = "电话",width = 20)
    private String phone;
    @Excel(name = "密码")
    private String password;
    @ExcelIgnore
    private String salt;
    @Excel(name="图片",type = 2,width = 20,height = 30)
    private String picImg;
    @Excel(name = "法名")
    private String ahama;
    @Excel(name = "姓名")
    private String name;
    @Excel(name = "性别")
    private String sex;
    @Excel(name = "城市")
    private String ciry;
    @Excel(name = "签名")
    private String sign;
    @Excel(name = "状态")
    private String status;
    @Excel(name = "注册时间",format = "yyyy-MM-dd",width = 30)
    private Date regDate;
    @ExcelIgnore
    private String guruId;


    public User() {
    }

    public User(String id, String phone, String password, String salt, String picImg, String ahama, String name, String sex, String ciry, String sign, String status, Date regDate, String guruId) {
        this.id = id;
        this.phone = phone;
        this.password = password;
        this.salt = salt;
        this.picImg = picImg;
        this.ahama = ahama;
        this.name = name;
        this.sex = sex;
        this.ciry = ciry;
        this.sign = sign;
        this.status = status;
        this.regDate = regDate;
        this.guruId = guruId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", picImg='" + picImg + '\'' +
                ", ahama='" + ahama + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", ciry='" + ciry + '\'' +
                ", sign='" + sign + '\'' +
                ", status='" + status + '\'' +
                ", regDate=" + regDate +
                ", guruId='" + guruId + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPicImg() {
        return picImg;
    }

    public void setPicImg(String picImg) {
        this.picImg = picImg;
    }

    public String getAhama() {
        return ahama;
    }

    public void setAhama(String ahama) {
        this.ahama = ahama;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCiry() {
        return ciry;
    }

    public void setCiry(String ciry) {
        this.ciry = ciry;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getGuruId() {
        return guruId;
    }

    public void setGuruId(String guruId) {
        this.guruId = guruId;
    }
}
