package com.ck4u.directory;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);

    }
    public static DatabaseAccess getInstance(Context context){
        if(instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open(){
        this.database = openHelper.getWritableDatabase();
    }
    public void close(){
        if(database != null){
            this.database.close();
        }
    }
    public List<String> getDictionaryData() {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM dictionary", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public String getMeaning(String word) {
        Cursor cursor= database.rawQuery("SELECT * FROM dictionary WHERE key = '"+word+"'", null);
        String meaning = "";
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            meaning = cursor.getString(1);
            cursor.moveToNext();
        }
        cursor.close();
        return meaning;
    }

}
