package com.example.broadcastlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

public abstract class BaseActivity extends AppCompatActivity implements MyBroadCastReceiver.OnConnectionChangeListener {
    private MyBroadCastReceiver broadCastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        broadCastReceiver = new MyBroadCastReceiver();
        registerReceiver(broadCastReceiver);


    }
    public void registerReceiver(MyBroadCastReceiver broadCastReceiver){
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(broadCastReceiver,intentFilter);
        broadCastReceiver.addListener(this);
    }

    @Override
    public void onNetworkConnected() {

    }

    @Override
    public void onNetworkDisconected() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    public void unRegisterReceiver(MyBroadCastReceiver broadCastReceiver){
        unRegisterReceiver(broadCastReceiver);
        broadCastReceiver.removeListener(this);
    }
}

