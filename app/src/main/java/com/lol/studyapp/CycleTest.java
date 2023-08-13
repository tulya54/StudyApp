package com.lol.studyapp;

import android.util.Log;

import java.util.ArrayList;

public class CycleTest {
    public static final String TAG = "CycleTest";
    public static final String[] cats = new String[]{"cat", "kitty", "mik mik"};

    int[] beers = new int[]{1, 2, 3, 4, 5, 6, 7, 8 ,9, 10};

    ArrayList<String> list = new ArrayList<String>();


    public CycleTest() {
        list.add("Raccoon");
        list.add("Dog");

        String kitty = cats[1];

        int totalCount = cats.length;

        for (int i = 0; i < totalCount; i++) {
           // String cat = cats[i];
            int count = i;
            Log.d(TAG, "Get Cat");
        }

        for (int i = 10; i > -1; i--) {
            int count2 = i;
            Log.d(TAG, "Get Cat");
        }

        //  1 primer
        for (int i = 10; i > beers.length; i--) {
            int count2 = i;
            Log.d(TAG, "Get Cat");
        }

        //  2 primer
        for (int i = 10; i > list.size(); i--) {
            int count2 = i;
            Log.d(TAG, "Get Cat");
        }


        for (String cat: cats) {
            String cat2 = cat;
            Log.d(TAG, "Get Cat");
        }


        int index = 0;



        while (index < 5) {
            index++;
            Log.d(TAG, "Get Cat");
        }
     //   Log.d(TAG, "End");
    }
}
