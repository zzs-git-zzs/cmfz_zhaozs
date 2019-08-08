package com.baizhi.entity;

public class Charts {

    private Integer count;
    private String month;

    public Charts() {
    }

    public Charts(Integer count, String month) {
        this.count = count;
        this.month = month;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "Charts{" +
                "count=" + count +
                ", month='" + month + '\'' +
                '}';
    }
}
