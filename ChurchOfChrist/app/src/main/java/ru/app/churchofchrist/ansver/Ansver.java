package ru.app.churchofchrist.ansver;

class Ansver {
    private int id;//Идентификатор.
    private String name;//Название.
    private String text;//Текст.
    private String autor;//Текст.

    Ansver(int id, String name, String text, String autor) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.autor = autor;
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

    public String getAutor() {
        return autor;
    }
}
