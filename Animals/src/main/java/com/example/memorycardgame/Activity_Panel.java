package com.example.memorycardgame;

import android.os.Bundle;

import com.example.common.Activity_PanelBase;

public class Activity_Panel extends Activity_PanelBase {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        dataManagerBase = new DataManagerAnimals();
        super.onCreate(savedInstanceState);



    }
}