package com.example.manufestfile;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {
    private static final int version = 1;
    private static final String DB_NAME = "Promo";
    private static final String TABLE_NAME = "Promo";

    //colomn names
    private static final String ID = "id";
    private static final String CATAGORY = "catagory";
    private static final String PRICE = "price";
    private static final String COUNT = "count";
    private static final String PERIOD = "period";

    public DBHandler(@Nullable Context context) {
        super(context, DB_NAME, null, version);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String TABLE_CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + " " +
                "("
                + ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + CATAGORY + "CATAGARY,"
                + PRICE + "PRICE,"
                + COUNT + "COUNT,"
                + PERIOD + "PERIOD" +
                ");";


        /*
           CREATE TABLE Register(id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, fName TEXT, lName TEXT, country TEXT, phNo CHAR,
           email  TEXT, password CHAR, cPassword CHAR);
         */
        sqLiteDatabase.execSQL(TABLE_CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}


