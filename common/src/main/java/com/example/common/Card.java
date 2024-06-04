package com.example.common;

public class Card {
    private String url;
    private String name;

    private boolean shown;


    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }


    public Card setUrl(String url) {
        this.url = url;
        return this;
    }

    public Card setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isShown() {
        return shown;
    }

    public Card setShown(boolean shown) {
        this.shown = shown;
        return this;
    }
}
