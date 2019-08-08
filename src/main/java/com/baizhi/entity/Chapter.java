package com.baizhi.entity;

import java.util.Date;

public class Chapter {
    private String id;
    private String url;
    private String size;
    private String duration;
    private Date upDate;
    private String albumId;

    public Chapter() {
    }

    public Chapter(String id, String url, String size, String duration, Date upDate, String albumId) {
        this.id = id;
        this.url = url;
        this.size = size;
        this.duration = duration;
        this.upDate = upDate;
        this.albumId = albumId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getUpDate() {
        return upDate;
    }

    public void setUpDate(Date upDate) {
        this.upDate = upDate;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }


    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", size='" + size + '\'' +
                ", duration='" + duration + '\'' +
                ", upDate=" + upDate +
                ", albumId='" + albumId + '\'' +
                '}';
    }
}
