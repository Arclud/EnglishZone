package com.example.telegram;

import java.util.ArrayList;
import java.util.List;

public class Telegram {


    private String RecentlyText;
    private String Title;
    private String URL;

    public Telegram(String title, String recentlyText , String URL) {
        this.Title = title;
        this.RecentlyText = recentlyText;
        this.URL = URL;
    }

    public String getURL() {
        return URL;
    }


    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getRecentlyText() {
        return RecentlyText;
    }

    public void setRecentlyText(String recentlyText) {
        RecentlyText = recentlyText;
    }


}
