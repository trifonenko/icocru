package ru.app.churchofchrist.songs;

class Song {
    private int id;//Идентификатор.
    private String name;//Название.
    private String text;//Текст.

    public Song(int id, String name, String text) {
        this.id = id;
        this.name = name;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }
}
