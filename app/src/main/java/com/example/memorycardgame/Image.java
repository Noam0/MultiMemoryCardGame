package com.example.memorycardgame;

public class Image {
    private String url;
    private String name;


    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }


    public Image setUrl(String url) {
        this.url = url;
        return this;
    }

    public Image setName(String name) {
        this.name = name;
        return this;
    }
}
