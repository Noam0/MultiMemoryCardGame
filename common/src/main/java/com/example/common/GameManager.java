package com.example.common;

import java.util.ArrayList;

public class GameManager {

    private ArrayList<Card> cards;
    private int currentQuestion = -1;

    protected DataManagerBase dataManagerBase;
    public GameManager(DataManagerBase dataManager) {
        cards = dataManager.getCards();


        
    }
}
