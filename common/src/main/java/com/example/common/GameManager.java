package com.example.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class GameManager {

    private ArrayList<Card> cards;

    private int numOfCards = 20;

    private int numberOfCardsShown = 0;


    protected DataManagerBase dataManagerBase;

    private ArrayList<Card> ShownCards;
    public GameManager(DataManagerBase dataManager) {
        cards = dataManager.getCards();
        Collections.shuffle(cards);
        ShownCards = new ArrayList<Card>();

        
    }



    public ArrayList<Card> getShownCards() {
        return ShownCards;
    }

    public GameManager setShownCards(ArrayList<Card> shownCards) {
        ShownCards = shownCards;
        return this;
    }

    public int getNumOfCards() {
        return numOfCards;
    }

    public GameManager setNumOfCards(int numOfCards) {
        this.numOfCards = numOfCards;
        return this;
    }

    public int getNumberOfCardsShown() {
        return numberOfCardsShown;
    }

    public GameManager setNumberOfCardsShown(int numberOfCardsShown) {
        this.numberOfCardsShown = numberOfCardsShown;
        return this;
    }

    public ArrayList<Card> getCards() {

        return cards;
    }


    public boolean checkIfTwoLastOnesAreEqual() {
        int numberOfShownCards = ShownCards.size();
        if(ShownCards.get(numberOfShownCards-1).equals(ShownCards.get(numberOfShownCards-2))){
            return true;
        }
        return false;
    }
}
