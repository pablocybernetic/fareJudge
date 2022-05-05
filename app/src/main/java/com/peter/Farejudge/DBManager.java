package com.peter.Farejudge;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {

    private DatabaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;
    private  SQLiteDatabase database1;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        database1 = dbHelper.getReadableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String establishName , String name, String desc,String currentDateandTime) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.NAME,establishName);
        contentValue.put(DatabaseHelper.SUBJECT, name);
        contentValue.put(DatabaseHelper.DESC, desc);
        contentValue.put(DatabaseHelper.DATE, currentDateandTime);
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[] { DatabaseHelper._ID, DatabaseHelper.NAME, DatabaseHelper.SUBJECT, DatabaseHelper.DESC,DatabaseHelper.DATE };
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null,null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
    public Cursor search(String query){

        Cursor cursor1 = database.rawQuery("select * FROM farejudge where name like '"+query+"%' order by name", null);
        if (cursor1 != null) {
            cursor1.moveToFirst();
        }
        return cursor1;
    }

    public int update(long _id, String name, String desc) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.SUBJECT, name);
        contentValues.put(DatabaseHelper.DESC, desc);
        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID + "=" + _id, null);
    }
    public boolean deleteAll() {
        database.rawQuery("DELETE  FROM farejudge", null);
        return true;
    }

}
