package ru.app.churchofchrist.verse_of_day;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import static androidx.room.ColumnInfo.TEXT;

@Entity(tableName = "verses")
public class Verse {

    @PrimaryKey
    @ColumnInfo(name = "book_number")
    private int boolNumber;

    private int chapter;

    private int verse;

    @ColumnInfo(typeAffinity = TEXT)
    private String text;

    @ColumnInfo(name = "verse_of_day")
    public int verseOfDay;

    public int getBoolNumber() {
        return boolNumber;
    }

    public void setBoolNumber(int boolNumber) {
        this.boolNumber = boolNumber;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public int getVerse() {
        return verse;
    }

    public void setVerse(int verse) {
        this.verse = verse;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}