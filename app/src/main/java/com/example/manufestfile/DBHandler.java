package com.example.manufestfile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

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
        String Drop_TABLE_QUERY = "DROP TABLE IF EXISTS Promo"+TABLE_NAME;
        sqLiteDatabase.execSQL(Drop_TABLE_QUERY);
        onCreate(sqLiteDatabase);

    }
    public void AddPromos(ToDo toDo){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(CATAGORY,toDo.getCatagory());
        contentValues.put(PRICE,toDo.getCatagory());
        contentValues.put(COUNT,toDo.getCatagory());
        contentValues.put(PERIOD,toDo.getCatagory());
        //save to table
        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        //close database
        sqLiteDatabase.close();


    }

    public int CountToDo(){
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(query,null);
        return cursor.getCount();

    }
    //get all todos(promo list)
    public List<ToDo> getAllToDos(){
        List<ToDo> toDos = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do {
                //create new ToDo object
                ToDo toDo = new ToDo();
                toDo.setId(cursor.getInt(0));
                toDo.setCatagory(cursor.getString(1));
                toDo.setPrice(cursor.getString(2));
                toDo.setCount(cursor.getString(3));
                toDo.setPeriod(cursor.getString(4));

                toDos.add(toDo);
            }while (cursor.moveToNext());
        }
        return toDos;
    }

}



