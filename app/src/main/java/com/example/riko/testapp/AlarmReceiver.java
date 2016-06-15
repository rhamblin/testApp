package com.example.riko.testapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Riko on 2016-06-13.
 */
public class AlarmReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context arg0, Intent arg1) {
        // For our recurring task, we'll just display a message
        Toast.makeText(arg0, "I'm running", Toast.LENGTH_SHORT).show();

    }

}
