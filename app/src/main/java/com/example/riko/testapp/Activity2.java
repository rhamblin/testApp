package com.example.riko.testapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        TextView tx = (TextView) findViewById(R.id.answer);
        TextView tx1 = (TextView) findViewById(R.id.textView2);
        // ((TextView)findViewById (R.id.answer)).setText(getIntent().getStringExtra("value"));
//        tx.setText(String.valueOf(getIntent().getExtras().getString("value")));
        tx.setText(Integer.toString(GlobalVar.getCounter().count));

        tx1.setText(getIntent().getExtras().getString("value"));
        //    tx.setVisibility(View.VISIBLE);
        //   tx.setTextColor(3333);
    }


    public void onClick(View view) {


        GlobalVar.setCounter(GlobalVar.getCounter().count+5);

        TextView tx = (TextView) findViewById(R.id.answer);
        int temp = GlobalVar.getCounter().count;

        tx.setText(Integer.toString(temp));

    }

}
