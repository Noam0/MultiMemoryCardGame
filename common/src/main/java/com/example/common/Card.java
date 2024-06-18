package com.example.common;

import java.util.Objects;

public class Card {
    private String imageUrl;
    private String name;

    private boolean shown;


    public Card() {
        this.shown = false;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }


    public Card setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return shown == card.shown && Objects.equals(imageUrl, card.imageUrl) && Objects.equals(name, card.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageUrl, name, shown);
    }
}
