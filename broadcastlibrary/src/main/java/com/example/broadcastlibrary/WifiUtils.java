package com.example.broadcastlibrary;

import android.content.Context;
import android.net.wifi.WifiManager;

public class WifiUtils {

    public static void setWifiEnabled(boolean enabled,Context context){

        WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
        wifiManager.setWifiEnabled(enabled);
    }
}
