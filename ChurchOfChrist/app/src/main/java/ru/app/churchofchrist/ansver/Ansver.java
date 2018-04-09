package ru.app.churchofchrist.ansver;

class Ansver {
    private int id;//Идентификатор.
    private String name;//Название.
    private String text;//Текст.
    private String image;//Картинка.

    Ansver(int id, String name, String text, String image) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.image = image;
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

    public String getImage() {
        return image;
    }
}
