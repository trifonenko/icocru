package ru.app.church_of_christ.songs;

class Song {
    private int id;//Идентификатор.
    private String name;//Название.
    private String text;//Текст.
    private String chords;

    Song(int id, String name, String text, String chords) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.chords = chords;
    }
    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    String getText() {
        return text;
    }

    String getChords() {
        return chords;
    }
}
