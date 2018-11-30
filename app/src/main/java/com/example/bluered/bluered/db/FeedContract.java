package com.example.bluered.bluered.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public final class FeedContract  {

    private FeedContract() {}
    // Change anyway you want
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "Readings_table";
        public static final String ID = "id";
        public static final String COLUMN_COLOR = "color";
        public static final String COLUMN_SAYING = "saying";
    }
    // SQLite create table string command
    private static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + " ("
            + FeedEntry.ID + "INTEGER PRIMARY KEY,"
            + FeedEntry.COLUMN_COLOR + " TEXT NOT NULL,"
            + FeedEntry.COLUMN_SAYING + " TEXT)";

    
    public class FeedReaderDbHelper extends SQLiteOpenHelper {
        public static final String DATABASE_NAME = "FeedReader.db";

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
}
