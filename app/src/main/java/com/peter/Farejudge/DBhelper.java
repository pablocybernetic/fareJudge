package com.peter.Farejudge;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

    public class DBhelper extends SQLiteOpenHelper {
        public DBhelper(Context context) {
            super(context, "farejudge.db", null, 1);
        }

        //        called the first time  the
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

        }
// when the version of the db change
        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }


