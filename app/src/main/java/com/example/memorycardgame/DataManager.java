package com.example.memorycardgame;

import java.util.ArrayList;

public class DataManager {

    private static ArrayList<Image> getImages(){

        ArrayList <Image> images = new ArrayList<>();

        images.add(new Image()
                .setName("")
                .setUrl(""));
        images.add(new Image()
                .setName("")
                .setUrl(""));

        return images;

    }
}
