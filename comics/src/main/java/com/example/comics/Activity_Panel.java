package com.example.comics;

import android.os.Bundle;
import android.widget.GridLayout;

import com.example.common.Activity_PanelBase;

public class Activity_Panel extends Activity_PanelBase {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataManagerBase = new DataManagerComics();
        super.onCreate(savedInstanceState);


        findViews();
    }

    private void findViews() {


    }
}