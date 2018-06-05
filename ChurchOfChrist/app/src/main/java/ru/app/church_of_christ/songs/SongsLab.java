package ru.app.church_of_christ.songs;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ru.app.church_of_christ.DBHelper;

/**
 * Синглетный класс.
 */

class SongsLab {
    private static SongsLab sSongsLab;
    private SQLiteDatabase mDatabase;
    private SQLiteDatabase mDatabaseFav;

    private SongsLab(Context context) {
        DBHelper helperSongs = new DBHelper(context, "songs.db", 5);//12.02.2018 (версия в google 5)
        DBHelper helperFavSongs = new DBHelper(context, "db_songs", 1);
        try {
            helperSongs.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }
        mDatabase = helperSongs.getWritableDatabase();
        mDatabaseFav = helperFavSongs.getReadableDatabase();
    }

    static SongsLab getInstance(Context context) {
        if (sSongsLab == null) {
            sSongsLab = new SongsLab(context);
        }
        return sSongsLab;
    }

    List<Song> getSongs() {
        int i = 1;
        List<Song> songs = new ArrayList<>();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM songs ORDER BY title", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            songs.add(new Song(i, cursor.getString(1), cursor.getString(2), cursor.getString(4)));
            cursor.moveToNext();
            i++;
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
