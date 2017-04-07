package com.example.gjq.myapp.news;

/**
 * Created by guojiqing on 2017/4/5.
 */

public class News {
    private String title;

    private String subTitle;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public News(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }
}
