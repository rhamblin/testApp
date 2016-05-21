package com.example.riko.testapp;

import android.app.Application;

/**
 * Created by Riko on 2016-05-20.
 */
public class GlobalVar {

    //instead of new Counter() there must be methods in this class to serialize and deserialize
    //the information. onCreate it would serialize the "counter object",
    static public Counter c = new Counter();

    static public void setCounter (int co) {
        c.count = co ;
    }

    static public Counter getCounter (){
        return c;
    }

}
