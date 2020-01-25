package com.example.broadcastlibrary;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.HashSet;
import java.util.Set;

public class MyBroadCastReceiver extends BroadcastReceiver {
    private Set<OnConnectionChangeListener> listeners = new HashSet<>();

    public void addListener(OnConnectionChangeListener onConnectionChangeListener){
        listeners.add(onConnectionChangeListener);
    }

    public void removeListener(OnConnectionChangeListener onConnectionChangeListener){
        listeners.remove(onConnectionChangeListener);
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        for (OnConnectionChangeListener onConnectionChangeListener:listeners){
            if (onConnectionChangeListener != null){
                    if (ConnectivityUtils.isConnected(context)){
                        onConnectionChangeListener.onNetworkConnected();
                    }else if (!ConnectivityUtils.isConnected(context)){
                        onConnectionChangeListener.onNetworkDisconected();
                    }
            }
        }

    }



    interface OnConnectionChangeListener{
        void onNetworkConnected();
        void onNetworkDisconected();

    }
}
