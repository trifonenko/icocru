package ru.app.churchofchrist.room_helper_database.dao;

import androidx.room.Dao;
import androidx.room.Query;
import ru.app.churchofchrist.room_helper_database.table.Verse;

@Dao
public interface VerseDao {

    @Query("SELECT book_number, chapter, verse, text, verse_of_day FROM verses WHERE verse_of_day = '1' ORDER BY random() LIMIT '1'")
    Verse getVerse();
}