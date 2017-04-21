package com.example.gjq.myapp.models;

/**
 * Created by guojiqing on 2017/4/5.
 */

public class News {
    private String title;
    private String time;
    private String imgUrl;
    private String contentUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public News() {
        super();
    }

    public News(String title, String time, String imgUrl, String contentUrl) {
        this.title = title;
        this.time = time;
        this.imgUrl = imgUrl;
        this.contentUrl = contentUrl;
    }
}
