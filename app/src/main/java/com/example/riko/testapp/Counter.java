package com.example.riko.testapp;

import java.io.Serializable;

/**
 * Created by Riko on 2016-05-20.
 */
public class Counter implements Serializable{

    int count;

   public  Counter () {

        count=0;


    }
    public void setCount(int start) {

        count = start;


    }
    public int getCount(){

        return count;


    }
    public void increment () {

        count ++ ;

    }
}
