package ru.app.churchofchrist.verse_of_day;

import androidx.room.ColumnInfo;

class BookName {

    @ColumnInfo(name = "short_name")
    private String shortName;

    BookName(String shortName) {
        this.shortName = shortName;
    }

    String getShortName() {
        return shortName;
    }
}