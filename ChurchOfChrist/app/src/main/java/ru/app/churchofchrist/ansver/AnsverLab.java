package ru.app.churchofchrist.ansver;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Синглетный класс.
 */

public class AnsverLab {
    private static AnsverLab sAnsverLab;
    private SQLiteDatabase mDatabase;


    private AnsverLab(Context context) {
        DatabaseHelper helper = new DatabaseHelper(context);
        try {
            helper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }
        mDatabase = new DatabaseHelper(context).getWritableDatabase();

    }

    static AnsverLab getInstance(Context context) {
        if (sAnsverLab == null) {
            sAnsverLab = new AnsverLab(context);
        }
        return sAnsverLab;
    }

    public List<Ansver> getAnsver() {
        List<Ansver> ansver = new ArrayList<>();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM ansver", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ansver.add(new Ansver(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
            cursor.moveToNext();

        }
        cursor.close();
        return ansver;
    }
}
