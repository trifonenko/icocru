package ru.app.churchofchrist.verse_of_day;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Verse.class, Book.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract VerseDao verseDao();
    public abstract BookDao bookDao();
}