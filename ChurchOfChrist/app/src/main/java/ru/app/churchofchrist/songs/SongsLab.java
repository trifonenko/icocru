package ru.app.churchofchrist.songs;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Синглетный класс.
 */

public class SongsLab {
    private static SongsLab sSongsLab;
    private SQLiteDatabase mDatabase;
    private SQLiteDatabase mDatabaseFav;

    private SongsLab(Context context) {
        DatabaseHelper helper = new DatabaseHelper(context);
        try {
            helper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }
        mDatabase = new DatabaseHelper(context).getWritableDatabase();
        mDatabaseFav = DBHelperFavSongs.getInstance(context).getWritableDatabase();
    }

    static SongsLab getInstance(Context context) {
        if (sSongsLab == null) {
            sSongsLab = new SongsLab(context);
        }
        return sSongsLab;
    }

    public List<Song> getSongs() {
        List<Song> songs = new ArrayList<>();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM songs", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            songs.add(new Song(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(4)));
            cursor.moveToNext();
        }
        cursor.close();
        return songs;
    }

    List<Song> getFavoritesSongs() {
        List<Song> favoritesSongs = new ArrayList<>();
        Cursor cursor = mDatabaseFav.rawQuery("SELECT * FROM FAV_SONGS", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            favoritesSongs.add(new Song(cursor.getInt(1), cursor.getString(2), cursor.getString(3), cursor.getString(4)));
            cursor.moveToNext();
        }
        cursor.close();
        return favoritesSongs;
    }

}
