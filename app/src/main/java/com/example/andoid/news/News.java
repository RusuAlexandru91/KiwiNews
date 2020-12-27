package com.example.andoid.news;

public class News {
    private String mThumbnail;
    private String mTitle;
    private String mDetailes;
    private String mCategory;
    private  String mDate;
    private String mUrl;

    public News(String Title, String Detailes, String Category, String Date, String Url, String Thumbnail) {
        this.mThumbnail = Thumbnail;
        this.mTitle = Title;
        this.mDetailes = Detailes;
        this.mCategory = Category;
        this.mDate = Date;
        this.mUrl = Url;
    }

    public String getmThumbnail() {
        return mThumbnail;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmDetailes() {
        return mDetailes;
    }

    public String getmCategory() {
        return mCategory;
    }

    public String getmDate() {
        return mDate;
    }

    public String getmUrl() {
        return mUrl;
    }
}
