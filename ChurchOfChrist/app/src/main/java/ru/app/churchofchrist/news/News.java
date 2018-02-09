package ru.app.churchofchrist.news;

public class News {
    private String newsTitle;
    private String newsUrl;
    private String desc;
    private String newsTime;

    public News(String newsTitle, String newsUrl, String desc, String newsTime) {
        this.newsTitle = newsTitle;
        this.newsUrl = newsUrl;
        this.desc = desc;
        this.newsTime = newsTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(String newsTime) {
        this.newsTime = newsTime;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsUrl() {
        return newsUrl;
    }

    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl;
    }
}
