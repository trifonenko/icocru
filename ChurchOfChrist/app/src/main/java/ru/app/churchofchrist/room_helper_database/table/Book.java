package ru.app.churchofchrist.room_helper_database.table;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import static androidx.room.ColumnInfo.TEXT;

@Entity(tableName = "books")
public class Book {

    @PrimaryKey
    @ColumnInfo(name = "book_number")
    private int bookNumber;

    @ColumnInfo(name = "book_color", typeAffinity = TEXT)
    private String bookColor;

    @ColumnInfo(name = "short_name", typeAffinity = TEXT)
    private String shortName;

    @ColumnInfo(name = "long_name", typeAffinity = TEXT)
    private String longName;

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getBookColor() {
        return bookColor;
    }

    public void setBookColor(String bookColor) {
        this.bookColor = bookColor;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

}