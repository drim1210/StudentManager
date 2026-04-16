package com.example.studentmanager.database;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "StudentDB";
    public static final int DB_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE Account(id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)");

        db.execSQL("CREATE TABLE Class(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, major TEXT, teacher TEXT)");

        db.execSQL("CREATE TABLE Student(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT, classId INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Account");
        db.execSQL("DROP TABLE IF EXISTS Class");
        db.execSQL("DROP TABLE IF EXISTS Student");
        onCreate(db);
    }
}