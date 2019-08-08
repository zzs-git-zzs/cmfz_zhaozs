package com.baizhi.entity;

import java.util.Date;

public class Carousel {

    private String id;
    private String username;
    private String path;
    private String status;
    private Date cupdate;
    private String cdescribe;

    public Carousel() {
    }

    public Carousel(String id, String username, String path, String status, Date cupdate, String cdescribe) {
        this.id = id;
        this.username = username;
        this.path = path;
        this.status = status;
        this.cupdate = cupdate;
        this.cdescribe = cdescribe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCupdate() {
        return cupdate;
    }

    public void setCupdate(Date cupdate) {
        this.cupdate = cupdate;
    }

    public String getCdescribe() {
        return cdescribe;
    }

    public void setCdescribe(String cdescribe) {
        this.cdescribe = cdescribe;
    }

    @Override
    public String toString() {
        return "Carousel{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", path='" + path + '\'' +
                ", status='" + status + '\'' +
                ", cupdate=" + cupdate +
                ", cdescribe='" + cdescribe + '\'' +
                '}';
    }
}
