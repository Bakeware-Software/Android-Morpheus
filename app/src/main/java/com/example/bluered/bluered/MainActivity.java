package com.example.bluered.bluered;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.bluered.bluered.db.FeedContract;
import com.example.bluered.bluered.db.FeedReaderDbHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    //CONSTANTS
    private float x1, x2;
    private static final String PREFS_NAME = "MORPHEUS_PREFS";
    private static final String DB_NEEDS_UPDATE = "DB_UPDATE";

    public static final int MIN_DISTANCE = 150;

    //OTHER
    private FeedReaderDbHelper mDbHelper;
    private SQLiteDatabase mDb;

    private SharedPreferences shPrefs;
    private SharedPreferences.Editor shPrefsEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper = new FeedReaderDbHelper(this);
        mDb       = mDbHelper.getWritableDatabase();

        shPrefs       = getApplication().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        shPrefsEditor = shPrefs.edit();

        if(shPrefs.getBoolean(DB_NEEDS_UPDATE, true))
        {
            if(!shPrefs.contains(DB_NEEDS_UPDATE))
            {
                shPrefsEditor.putBoolean(DB_NEEDS_UPDATE, true);
                if(shPrefsEditor.commit())
                {
                    Log.d("COMMIT", "PREFS COMMIT SUCCESSFULL");
                }
            }
        }

        Log.d("ONCREATE", "ONCREATE EXECUTED");
    }
    @Override
    protected void onDestroy() {
        mDb.close();
        super.onDestroy();

        Log.d("ONDESTROY", "ONDESTROY EXECUTED");
    }

    public void swapLeft() {
        Intent intent = new Intent(this, LeftActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.right_left_in, R.anim.right_left_out);
    }

    public void swapRight() {
        Intent intent = new Intent(this, RightActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_right_in, R.anim.left_right_out);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                float deltaX = x2 - x1;

                if (Math.abs(deltaX) > MIN_DISTANCE)
                {
                    // Left to Right swipe action
                    if (x2 > x1)
                    {
                        swapLeft();
                    }
                    // Right to left swipe action
                    else
                    {
                        swapRight();
                    }
                }
                else
                {
                    // consider as something else - a screen tap for example
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    private String getSaying() {
        return "null";
    }

    private void pushSaying(String saying, String color){
        ContentValues values = new ContentValues();

        values.put(FeedContract.FeedEntry.COLUMN_SAYING, saying);
        values.put(FeedContract.FeedEntry.COLUMN_COLOR, color);

        mDb.insert(FeedContract.FeedEntry.TABLE_NAME, null, values);
    }

    private void populateDatabase() {

        BufferedReader bufferedReaderBlue = new BufferedReader(new FileReader("..\\res\\values\\sayingsBlue.txt");


        Log.d("LINEREAD", "LINEREAD:" /* + line*/ );
    }

    private boolean wasPopulated() {

        return false;
    }
}

//---------REFAKTORYZACJA-----------