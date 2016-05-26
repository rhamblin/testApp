package com.example.riko.testapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Activity2 extends Activity {

    ListAdapter adapter;
    List<Person> people;
    ListView list ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        TextView tx = (TextView) findViewById(R.id.answer);
        TextView tx1 = (TextView) findViewById(R.id.textView2);

        tx.setText(Integer.toString(GlobalVar.getCounter().count));
        tx1.setText(getIntent().getExtras().getString("value"));

        list = (ListView) findViewById(R.id.listView);

        people = new ArrayList<>();
        people.add(new Person(1,"bob1"));
        people.add(new Person(2,"bob2"));
        people.add(new Person(3,"bob3"));
        people.add(new Person(4,"bob4"));
        people.add(new Person(5,"bob5"));
        people.add(new Person(6,"bob6"));
        people.add(new Person(7,"bob7"));

        adapter = new ListAdapter(getApplicationContext(),people);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"hi" + " " + people.get(position).name,Toast.LENGTH_LONG).show();
            }
        });

    }

    public void onClick(View view) {
        GlobalVar.setCounter(GlobalVar.getCounter().count+5);

        TextView tx = (TextView) findViewById(R.id.answer);
        int temp = GlobalVar.getCounter().count;

        tx.setText(Integer.toString(temp));
    }

    public void onClickClear(View view) {
        GlobalVar.setCounter(0);
        TextView tx = (TextView) findViewById(R.id.answer);
        tx.setText(Integer.toString(GlobalVar.getCounter().count));
     }
    public void onClickSave(View view) {
       GlobalVar.saveState(this);
    }

    public void onClickHOME(View view) {
        Intent intent = new Intent(this, MainActivity.class) ;
        startActivity(intent);
    }

    public void onClickNewButton(View view) {


    }

    public void onClickGame(View view) {
        setContentView(R.layout.secondarylayout);
        TextView tx = (TextView) findViewById(R.id.button);
        tx.setText("Hey!");
    }

     @Override
   public void onPause() {
        super.onPause();
           GlobalVar.saveState(this);
   }

}
