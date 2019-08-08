package com.baizhi.entity;

import java.util.Date;

public class Article {

    private String id;
    private String title;
    private String insertImg;
    private String content;
    private Date upDate;
    private String guruId;

    public Article() {
    }

    public Article(String id, String title, String insertImg, String content, Date upDate, String guruId) {
        this.id = id;
        this.title = title;
        this.insertImg = insertImg;
        this.content = content;
        this.upDate = upDate;
        this.guruId = guruId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInsertImg() {
        return insertImg;
    }

    public void setInsertImg(String insertImg) {
        this.insertImg = insertImg;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getUpDate() {
        return upDate;
    }

    public void setUpDate(Date upDate) {
        this.upDate = upDate;
    }

    public String getGuruId() {
        return guruId;
    }

    public void setGuruId(String guruId) {
        this.guruId = guruId;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", insertImg='" + insertImg + '\'' +
                ", content='" + content + '\'' +
                ", upDate=" + upDate +
                ", guruId='" + guruId + '\'' +
                '}';
    }
}
