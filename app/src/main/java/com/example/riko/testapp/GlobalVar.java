package com.example.riko.testapp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.widget.Button;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Riko on 2016-05-20.
 */
public class GlobalVar implements Serializable{

    //instead of new Counter() there must be methods in this class to serialize and deserialize
    //the information. onCreate it would serialize the "counter object",
    static public Counter c;
    static File f= null;

    static public void setCounter (int co) {
        c.count = co ;
    }

    static public Counter getCounter (){
        return c;
    }


    static public void saveState(Context context) {
        FileOutputStream outStream = null;
        try {
            File f = new File(context.getFilesDir(), File.separator +"data6.dat");
            outStream =  new FileOutputStream(f);
            ObjectOutputStream objectOutStream = new ObjectOutputStream(outStream);


            objectOutStream.writeObject(GlobalVar.c);
            objectOutStream.close();
        } catch (FileNotFoundException e1) {
            // e1.printStackTrace();
        } catch (IOException e1) {
           // e1.printStackTrace();
        }

    }
    static public void loadState(Context context) throws IOException {
        Counter s = null;
        FileInputStream inStream = null;

        try {
            System.out.println("error");
            // f = new File(Environment.getExternalStorageDirectory(), File.separator + "data.dat");
            if(f == null ){
            f =  new File(context.getFilesDir(), File.separator + "data6.dat");
            System.out.println("error2");}

            System.out.println("errorrrrrrrr");
            inStream = new FileInputStream(f);
            System.out.println("error3");
            ObjectInputStream objectInStream = new ObjectInputStream(inStream);
            System.out.println("error4");

            s = ((Counter) objectInStream.readObject());
            System.out.println("errorx");
            objectInStream.close();
            System.out.println("errory");
        } catch (IOException e1) {
            System.out.println("error5");
            f.createNewFile();
            System.out.println("error6");
            GlobalVar.c = new Counter();
            System.out.println("error7");
            e1.printStackTrace();
        }catch (ClassNotFoundException e1) {
            f.createNewFile();
            GlobalVar.c = new Counter();
            e1.printStackTrace();

        } /*catch (FileNotFoundException e1) {
        button3
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }*/
        if (s != null)
            GlobalVar.c = s;
        else {
            GlobalVar.c = new Counter();

        }
    }
}
