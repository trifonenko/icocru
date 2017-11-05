package ru.app.churchofchrist.bible;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String databaseName = "bible_nrt.db";//Имя файла БД.
    private String databasePath = "";//Путь к БД.
    private static int databaseVersion = 1;//Версия БД.

    private SQLiteDatabase database;
    private Context context;

    public DatabaseHelper(Context context) {
        super(context, databaseName, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
