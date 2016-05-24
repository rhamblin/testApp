package com.example.riko.testapp;

/**
 * Created by Riko on 2016-05-23.
 */
public class Person {
    String name;
    int id;
    int realID;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
        realID = id+1;
    }
}
