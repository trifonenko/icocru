package ru.app.churchofchrist.notepad;
//Блокнот разработан неизвестным специалистом из GitHub. Доработан trifonenko

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {

    private static DBHelper dbHelper;

    private DBHelper(Context context) {
        super(context, "myDataBase", null, 4); // Версия 4
    }


    static synchronized DBHelper getInstance (Context context) {

        if (dbHelper == null) {
            dbHelper = new DBHelper(context.getApplicationContext());
        }
        return dbHelper;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        // Создание таблицы 1
        db.execSQL("CREATE TABLE table1 (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " theme TEXT," +
                " content_note TEXT," +
                " date_time TEXT," +
                " color TEXT," +
                " date_sort INTEGER);");

        // Создание таблицы 2
        db.execSQL("CREATE TABLE table2 (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " theme TEXT," +
                " content_note TEXT," +
                " date_time TEXT," +
                " color TEXT," +
                " date_sort INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion == 1) {

            db.execSQL("ALTER TABLE table1 add column color TEXT;"); // Добавление столбца цвет
            db.execSQL("UPDATE table1 set color = 'color0';"); // Заполнение данными

            db.execSQL("ALTER TABLE table1 add column date_sort INTEGER;"); // Добавление столбца сортировка по дате

            // Создание таблицы 2
            db.execSQL("CREATE TABLE table2 (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " theme TEXT," +
                    " content_note TEXT," +
                    " date_time TEXT," +
                    " color TEXT," +
                    " date_sort INTEGER);");
        }

        else if (oldVersion == 2) {

            db.execSQL("ALTER TABLE table1 add column date_sort INTEGER;"); // Добавление столбца сортировка по дате

            // Создание таблицы 2
            db.execSQL("CREATE TABLE table2 (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " theme TEXT," +
                    " content_note TEXT," +
                    " date_time TEXT," +
                    " color TEXT," +
                    " date_sort INTEGER);");

        }

        else if (oldVersion == 3) {

            // Создание таблицы 2
            db.execSQL("CREATE TABLE table2 (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " theme TEXT," +
                    " content_note TEXT," +
                    " date_time TEXT," +
                    " color TEXT," +
                    " date_sort INTEGER);");
        }
    }
}
