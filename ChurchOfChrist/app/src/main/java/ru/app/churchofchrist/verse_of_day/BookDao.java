package ru.app.churchofchrist.verse_of_day;

import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface BookDao {
    @Query("SELECT book_number, book_color, short_name, long_name FROM books WHERE book_number = :book_number")
    Book getBook(int book_number);
}
