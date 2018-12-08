package com.example.bluered.bluered.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.bluered.bluered.db.FeedContract.SQL_CREATE_TABLE;

public class FeedReaderDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "SayingDatabase.db";
    public static final String DATABASE_ENTRYCOLOR_R = "Red";
    public static final String DATABASE_ENTRYCOLOR_B = "Blue";

    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //todo
    }


}
