package com.example.broadcastlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

public abstract class BaseSnackbarActivity extends BaseActivity implements SnackBarFactory.OnTryAgainListener {
    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_snackbar);
        snackbar = SnackBarFactory.createSnackbar(this,this,this);
    }

    @Override
    public void onNetworkDisconected() {
        super.onNetworkDisconected();

          snackbar.show();
    }

    @Override
    public void onNetworkConnected() {
        super.onNetworkConnected();
        snackbar.dismiss();
    }

    @Override
    public void onTryAgainClicked() {
        WifiUtils.setWifiEnabled(true,this);
    }
}
