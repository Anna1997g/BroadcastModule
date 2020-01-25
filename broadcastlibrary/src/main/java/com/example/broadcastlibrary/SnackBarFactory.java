package com.example.broadcastlibrary;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import static androidx.core.content.ContextCompat.getSystemService;
import static com.example.broadcastlibrary.R.layout.abc_activity_chooser_view;
import static com.example.broadcastlibrary.R.layout.snackbar_item;

public final class SnackBarFactory {

  /*  public static Snackbar createSnackbar(Activity activity, final OnTryAgainListener onTryAgainListener){
       View parentlayout = activity.findViewById(android.R.id.content);
        Snackbar snackbar = Snackbar.make(parentlayout, "Disconnected",Snackbar.LENGTH_INDEFINITE).setAction("Try Again", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onTryAgainListener.onTryAgainClicked();
            }
        });




        return snackbar;
    }*/
  public static Snackbar createSnackbar(Activity activity, final OnTryAgainListener onTryAgainListener, Context context){
      View parentlayout = activity.findViewById(android.R.id.content);
        Snackbar snackbar = Snackbar.make(parentlayout,"",Snackbar.LENGTH_INDEFINITE);
      Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();
      layout.setBackgroundColor(0xFFFFFF);
      final TextView textView = layout.findViewById(R.id.snackbar_text);
      WifiManager   wifiManager =(WifiManager) context.getSystemService(Context.WIFI_SERVICE);
      textView.setVisibility(View.INVISIBLE);
      View viewSnackBar = LayoutInflater.from(context).inflate(R.layout.snackbar_item, null);
      TextView tvSnackbar = viewSnackBar.findViewById(R.id.tv_snacbar);
      tvSnackbar.setText("Disconnected");
      Button btnSnackbar = viewSnackBar.findViewById(R.id.btn_snackbar);
      btnSnackbar.setBackgroundColor(0xFFFF0000);
      btnSnackbar.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              onTryAgainListener.onTryAgainClicked();
          }
      });
      layout.setPadding(0, 0, 0, 0);
      layout.addView(viewSnackBar, 0);

      return snackbar;
  }


    interface OnTryAgainListener{
        void onTryAgainClicked();
    }
}
