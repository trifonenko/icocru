package ru.app.churchofchrist.room_helper_database.dao;

import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface BookDao {

    @Query("SELECT short_name FROM books WHERE book_number = :bookNumber")
    String getBookShortName(int bookNumber);
}
