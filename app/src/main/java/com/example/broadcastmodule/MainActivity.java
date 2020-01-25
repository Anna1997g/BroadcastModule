package com.example.broadcastmodule;

import android.app.Activity;
import android.os.Bundle;

import com.example.broadcastlibrary.BaseSnackbarActivity;


public class MainActivity extends BaseSnackbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
