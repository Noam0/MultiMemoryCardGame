package com.example.common;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Activity_PanelBase extends AppCompatActivity {


    protected DataManagerBase dataManagerBase;
    private  GameManager gameManager;

    private GridLayout MAIN_GRID_CARDS;
    private CardView cardView[][];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_panel);

        gameManager = new GameManager(dataManagerBase);

        findViews();
        getAllCardViews();

    }


    private void findViews(){

        MAIN_GRID_CARDS = findViewById(R.id.MAIN_GRID_CARDS);
    }


    private CardView[][] getAllCardViews() {
        GridLayout gridLayout = findViewById(R.id.MAIN_GRID_CARDS); // Make sure to set the ID of your GridLayout in the XML or here in Java.
        int rowCount = gridLayout.getRowCount();
        int columnCount = gridLayout.getColumnCount();

        CardView[][] cardViews = new CardView[rowCount][columnCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                int linearIndex = i * columnCount + j;
                View childView = gridLayout.getChildAt(linearIndex);

                if (childView instanceof CardView) {
                    CardView card = (CardView) childView;
                    cardViews[i][j] = card;
                    final int finalI = i;
                    final int finalJ = j;
                    card.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            onCardClicked(card); // Custom method to handle click
                        }
                    });
                    Log.d("TAG", "OnClickListener set for CardView at position [" + i + "][" + j + "]");
                }
            }
        }

        return cardViews;
    }


    private void onCardClicked(CardView card) {
        card.animate().setDuration(150).rotationY(-90).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    // Change the content of the card here to show the other side
                    card.setBackgroundResource(R.drawable.sheep);


                    // Second half of the flip
                    card.setRotationY(90);
                    card.animate().setDuration(150).rotationY(0).setListener(null);
                }
            });
    }


}