package com.orlinskas.rickandmortywiki;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class ToastBuilder {
    public static void create (Context context, String text){
        Toast toast = Toast.makeText(context,
                text, Toast.LENGTH_SHORT);
        toast.show();
    }

    public static void createSnackBar (View view, String message) {
        try {
            Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}