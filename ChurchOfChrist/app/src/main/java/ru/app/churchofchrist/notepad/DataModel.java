package ru.app.churchofchrist.notepad;


public class DataModel {

    private int id;
    private String theme;
    private String date;
    private String color;

    public DataModel(int id, String theme, String date, String color) {
        this.id = id;
        this.theme = theme;
        this.date = date;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public String getTheme() {
        return theme;
    }

    public String getDate() {
        return date;
    }

    public String getColor() {
        return color;
    }


}
