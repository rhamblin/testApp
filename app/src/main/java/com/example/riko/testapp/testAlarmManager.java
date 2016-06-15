package com.example.riko.testapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import org.joda.time.DateTime;

public class testAlarmManager extends AppCompatActivity {

    private TimePicker time;
    private PendingIntent pendingIntent;
    private AlarmManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_alarm_manager);

        Intent alarmIntent= new Intent(this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this,0,alarmIntent,0);
    }

    public void startTestAlarmInFuture(View view) {

        time = (TimePicker) findViewById(R.id.pickTime);

        DateTime time = new DateTime()
                .withTime(this.time.getCurrentHour(),this.time.getCurrentMinute(),0,0);

        manager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);

        int interval = 1000 * 15;

        manager.setRepeating(AlarmManager.RTC_WAKEUP, time.getMillis(),interval,pendingIntent);

        Toast.makeText(this, "Alarm Set For future", Toast.LENGTH_SHORT).show();

    }

    public void startTestAlarmNow(View view) {

       manager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);

        int interval = 1000 * 5;
        manager.setRepeating(AlarmManager.RTC_WAKEUP, new DateTime().getMillis(),interval,pendingIntent);

        Toast.makeText(this, "Alarm Set Now", Toast.LENGTH_SHORT).show();

    }

    public void exit(View view){
        startActivity(new Intent(this, MainActivity.class));
    }
}
