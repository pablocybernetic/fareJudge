package com.peter.Farejudge;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

public class loader {
    private Activity activity;
    private AlertDialog dialog;

    public loader(Activity myActivity) {
        activity = myActivity;
    }
    void startLoader(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.loader,null));
        builder.setCancelable(true);
        dialog= builder.create();
        dialog.show();
    }
    void dismissDialog(){
        dialog.dismiss();
    }
}
