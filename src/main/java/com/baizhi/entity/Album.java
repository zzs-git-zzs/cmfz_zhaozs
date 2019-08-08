package com.baizhi.entity;

import java.util.Date;

public class Album {
    private String id;
    private String title;
    private String author;
    private Double score;
    private String coverImg;
    private String broadcast;
    private Integer acount;
    private String content;
    private Date pubDate;

    public Album() {
    }


    public Album(String id, String title, String author, Double score, String coverImg, String broadcast, Integer acount, String content, Date pubDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.score = score;
        this.coverImg = coverImg;
        this.broadcast = broadcast;
        this.acount = acount;
        this.content = content;
        this.pubDate = pubDate;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public Integer getAcount() {
        return acount;
    }

    public void setAcount(Integer acount) {
        this.acount = acount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }


    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", score=" + score +
                ", coverImg='" + coverImg + '\'' +
                ", broadcast='" + broadcast + '\'' +
                ", acount=" + acount +
                ", content='" + content + '\'' +
                ", pubDate=" + pubDate +
                '}';
    }
}
