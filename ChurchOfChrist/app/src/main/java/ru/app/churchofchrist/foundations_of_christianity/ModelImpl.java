package ru.app.churchofchrist.foundations_of_christianity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ru.app.churchofchrist.main.DatabaseHelper;

public class ModelImpl implements IContract.IModel {

    private Context mContext;

    //TODO так делать нельзя, модель не должна хранить ссылку на контекст, раскурить Dagger2
    public ModelImpl(Context context) {
        this.mContext = context;
    }

    @Override
    public List<Lesson> getListLessons(String nameTable) {
        List<Lesson> lessonList = new ArrayList<>();
        DatabaseHelper databaseHelper = new DatabaseHelper(mContext);
        try {
            databaseHelper.updateDatabase();
        } catch (IOException e) {
            throw new Error("UnableToUpdateDatabase");
        }
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + nameTable, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Lesson lesson = new Lesson(
                    cursor.getString(0),
                    cursor.getString(1)
            );
            lessonList.add(lesson);
            cursor.moveToNext();
        }
        cursor.close();
        return lessonList;
    }
}