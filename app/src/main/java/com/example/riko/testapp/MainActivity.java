package com.example.riko.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        Intent intent = new Intent(MainActivity.this, Activity2.class) ;


        EditText editText = (EditText) findViewById(R.id.editText);

            //this checks if box if empty
        if(!editText.getText().toString().isEmpty() )
         {
             //)this "bundles" the extra information to be sent to other activity
            intent.putExtra("value", editText.getText().toString());

              GlobalVar.c.count = Integer.parseInt(editText.getText().toString());

            startActivity(intent);
        }

       else {

                 Toast t = Toast.makeText (getApplicationContext(), "Enter a value", Toast.LENGTH_LONG);
        }

    }
}
