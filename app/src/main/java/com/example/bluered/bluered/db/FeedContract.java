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
    static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + " ("
            + FeedEntry.ID + "INTEGER PRIMARY KEY,"
            + FeedEntry.COLUMN_COLOR + " TEXT NOT NULL,"
            + FeedEntry.COLUMN_SAYING + " TEXT)";
}
