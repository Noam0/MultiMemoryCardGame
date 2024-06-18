package com.example.common;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Activity_PanelBase extends AppCompatActivity {

    protected DataManagerBase dataManagerBase;
    private GameManager gameManager;

    private GridLayout mainGridCards;
    private ShapeableImageView[][] cardViews;

    private ShapeableImageView lastDrawnCardImage;
    private MaterialTextView MAIN_MTV_counter;

    private CardView MAIN_GAMEOVER_CARDVIEW;
    private MaterialTextView MAIN_SUCCESS_number;
    private MaterialButton MAIN_CARDVIEW_RESTART;

    private MaterialTextView MAIN_MTV_timesPlayed;

    private Card lastDrawnCard ;

    private int timesWon = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferencesManager.init(this);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_panel);
        findViews();
        initViews();
        //MAIN_GAMEOVER_CARDVIEW.setVisibility(View.GONE);
        gameManager = new GameManager(dataManagerBase);
        getAllCardViews();
        showAllCardsTemporarily();
        startCountdown();
    }

    private void initViews() {
        int currentTimesWon = loadTimesWon();
        MAIN_MTV_timesPlayed.setText("Times Won: " + currentTimesWon);
    }

    private int loadTimesWon() {
        return SharedPreferencesManager.getInstance().getInt("times_won", 0);
    }

    private void saveTimesWon(int timesWon) {
        SharedPreferencesManager.getInstance().putInt("times_won", timesWon);
    }


    private void findViews() {
        MAIN_MTV_timesPlayed = findViewById(R.id.MAIN_MTV_timesPlayed);
       // MAIN_GAMEOVER_CARDVIEW = findViewById(R.id.MAIN_GAMEOVER_CARDVIEW);
       // MAIN_SUCCESS_number = findViewById(R.id.MAIN_SUCCESS_number);
       // MAIN_CARDVIEW_RESTART = findViewById(R.id.MAIN_CARDVIEW_RESTART);
        mainGridCards = findViewById(R.id.MAIN_GRID_CARDS);
        MAIN_MTV_counter = findViewById(R.id.MAIN_MTV_counter);
    }


    private void showAllCardsTemporarily() {
        for (int i = 0; i < cardViews.length; i++) {
            for (int j = 0; j < cardViews[i].length; j++) {
                int linearIndex = i * cardViews[i].length + j;
                if (linearIndex < gameManager.getCards().size()) {
                    String imageUrl = gameManager.getCards().get(linearIndex).getImageUrl();
                    Glide.with(this)
                            .load(imageUrl)
                            .into(cardViews[i][j]);
                }
            }
        }

        // Delay flipping the cards back to their backside after 10 seconds
        new Handler().postDelayed(this::hideAllCards, 10000);
    }

    private void startCountdown() {
        new CountDownTimer(10000, 1000) {
            public void onTick(long millisUntilFinished) {
                MAIN_MTV_counter.setText("Time: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                MAIN_MTV_counter.setText("Start!");
                hideAllCards();
            }
        }.start();
    }

    private void hideAllCards() {
        for (ShapeableImageView[] row : cardViews) {
            for (ShapeableImageView card : row) {
                hideCard(card);
            }
        }
    }

    private void hideCard(ShapeableImageView card) {
        if (card != null) {
            card.animate().rotationY(90).setDuration(150).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    card.setImageResource(R.drawable.backofcard); // Assumes you have a drawable
                    card.setRotationY(-90);
                    card.animate().rotationY(0).setDuration(150).setListener(null);
                }
            });
        } else {
            Log.e("HideCardError", "Attempted to animate a null ShapeableImageView.");
        }
    }


    private ShapeableImageView[][] getAllCardViews() {
        int rowCount = mainGridCards.getRowCount();
        int columnCount = mainGridCards.getColumnCount();
        cardViews = new ShapeableImageView[rowCount][columnCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                int linearIndex = i * columnCount + j;
                View childView = mainGridCards.getChildAt(linearIndex);

                if (childView instanceof ShapeableImageView) {
                    ShapeableImageView card = (ShapeableImageView) childView;
                    cardViews[i][j] = card;
                    final int finalI = i;
                    final int finalJ = j;



                        card.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                onCardClicked(card, finalI, finalJ, columnCount);
                            }
                        });
                        Log.d("TAG", "OnClickListener set for ShapeableImageView at position [" + i + "][" + j + "]");

                }
            }
        }
        return cardViews;
    }

    private void onCardClicked(ShapeableImageView cardImage, int row, int col, int columnCount) {
        if (!MAIN_MTV_counter.getText().equals("Start!")) {
            return; // Ignore clicks if the game hasn't started
        }

        Card drawnCard = getCardByPosition(row, col, columnCount);

        // Check if the card is already being shown
        if (drawnCard.isShown()) {
            return; // Do not allow clicking on a card that's already shown
        }

        // Display the card image
        revealCard(cardImage, row, col, columnCount);
        drawnCard.setShown(true);

        // Manage the shown cards
        if (lastDrawnCard == null) {
            lastDrawnCard = drawnCard;
            lastDrawnCardImage = cardImage;
        } else {
            // There's already one card shown, compare it with the last drawn card
            if (!drawnCard.equals(lastDrawnCard)) {
                // If they don't match, hide both after a short delay
                new Handler().postDelayed(() -> {
                    hideCard(cardImage);
                    hideCard(lastDrawnCardImage);
                    drawnCard.setShown(false);
                    lastDrawnCard.setShown(false);
                    lastDrawnCard = null;
                    lastDrawnCardImage = null;
                }, 1200);
            } else {
                // They match, add both to the shown cards list
                gameManager.getShownCards().add(drawnCard);
                gameManager.getShownCards().add(lastDrawnCard);
                lastDrawnCard = null;
                lastDrawnCardImage = null;

                // Check if all cards have been matched
                if (gameManager.getShownCards().size() == 20) {
                    gameOver();
                }
            }
        }
    }
    private void gameOver() {
        int currentTimesWon = loadTimesWon();
        saveTimesWon(currentTimesWon + 1);  // Increment and save the times won
        MAIN_MTV_counter.setText("SUCCESS!");
        MAIN_MTV_counter.setTextColor(Color.parseColor("#FFCC70"));
        MAIN_MTV_timesPlayed.setText("Times Won: " + (currentTimesWon + 1));
    }


    private Card getCardByPosition(int row, int col, int columnCount) {
        int linearIndex = row * columnCount + col;
        return gameManager.getCards().get(linearIndex);
    }

    private void revealCard(ShapeableImageView card, int row, int col, int columnCount) {
        card.animate().rotationY(90).setDuration(150).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                int linearIndex = row * columnCount + col;
                String imageUrl = gameManager.getCards().get(linearIndex).getImageUrl();
                Log.d("imageUrl", imageUrl);

                // Load the front image of the card using Glide
                Glide.with(Activity_PanelBase.this)
                        .load(imageUrl)
                        .into(card);

                // Continue the flip to show the front image
                card.setRotationY(-90);
                card.animate().rotationY(0).setDuration(150).setListener(null);
            }
        });
    }
}