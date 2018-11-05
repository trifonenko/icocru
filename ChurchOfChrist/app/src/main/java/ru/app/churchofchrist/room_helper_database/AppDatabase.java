package ru.app.churchofchrist.room_helper_database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import ru.app.churchofchrist.room_helper_database.table.Book;
import ru.app.churchofchrist.room_helper_database.dao.BookDao;
import ru.app.churchofchrist.room_helper_database.table.Verse;
import ru.app.churchofchrist.room_helper_database.dao.VerseDao;

@Database(entities = {Verse.class, Book.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract VerseDao verseDao();
    public abstract BookDao bookDao();
}