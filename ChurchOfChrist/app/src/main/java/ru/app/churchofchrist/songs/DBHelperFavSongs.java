package ru.app.churchofchrist.songs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperFavSongs extends SQLiteOpenHelper {

    private static DBHelperFavSongs mDBHelperFavSongs;

    private static final String DB_NAME = "db_songs";
    private static final int DB_VERSION = 1;

    private DBHelperFavSongs(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    static synchronized DBHelperFavSongs getInstance(Context context) {
        if (mDBHelperFavSongs == null) {
            mDBHelperFavSongs = new DBHelperFavSongs(context);
        }
        return mDBHelperFavSongs;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE FAV_SONGS ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "ID INTEGER, "
                + "NAME TEXT, "
                + "TEXT TEXT, "
                + "CHORDS TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
