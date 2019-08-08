package com.baizhi.entity;

import java.util.List;

public class Pro {
    private String title;
    private List<City> list;

    public Pro() {
    }

    public Pro(String title, List<City> list) {
        this.title = title;
        this.list = list;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<City> getList() {
        return list;
    }

    public void setList(List<City> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Pro{" +
                "title='" + title + '\'' +
                ", list=" + list +
                '}';
    }

    public Pro(String title) {
        this.title = title;
    }
}
