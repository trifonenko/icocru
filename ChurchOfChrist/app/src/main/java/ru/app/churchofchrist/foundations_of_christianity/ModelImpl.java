package ru.app.churchofchrist.foundations_of_christianity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ru.app.churchofchrist.foundations_of_christianity.lessons_list.IContract;
import ru.app.churchofchrist.main.DatabaseHelper;

public class ModelImpl implements IContract.IModel, ru.app.churchofchrist.foundations_of_christianity.detailing_lesson.IContract.IModelLessonDetail {

    private Context mContext;
    private SQLiteDatabase database;

    //TODO так делать нельзя, модель не должна хранить ссылку на контекст, раскурить Dagger2
    public ModelImpl(Context context) {
        this.mContext = context;
        DatabaseHelper helper = new DatabaseHelper(mContext);
        try {
            helper.updateDatabase();
        } catch (IOException e) {
            throw new Error("UnableToUpdateDatabase");
        }
        database = helper.getWritableDatabase();
    }

    @Override
    public List<String> loadTopicsLessons() {
        String sqlQuery = "SELECT DISTINCT topic FROM lessons";
        return makeRequest(sqlQuery, null);
    }

    @Override
    public List<String> titlesLessons(String topicLesson) {
        List<String> titlesLessonsList = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT title FROM lessons WHERE topic = ?", new String[]{topicLesson});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            titlesLessonsList.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return titlesLessonsList;
    }

    @Override
    public List<Lesson> getListLessons(String nameTable) {
        List<Lesson> lessonList = new ArrayList<>();
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

    /**
     * Метод осуществляет запрос к базе данных.
     *
     * @param sqlQuery      SQL запрос.
     * @param selectionArgs переменные в запросе.
     * @return список с результом запроса.
     */
    private List<String> makeRequest(String sqlQuery, String[] selectionArgs) {
        List<String> requestData = new ArrayList<>();
        Cursor cursor = database.rawQuery(sqlQuery, selectionArgs);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            requestData.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return requestData;
    }

    @Override
    public String loadLessonText(String titleLesson) {
        String sqlQuery = "SELECT text FROM lessons WHERE title = ?";
        Cursor cursor = database.rawQuery(sqlQuery, new String[]{titleLesson});
        cursor.moveToFirst();
        String lessonTest = cursor.getString(0);
        cursor.close();
        return lessonTest;
    }
}