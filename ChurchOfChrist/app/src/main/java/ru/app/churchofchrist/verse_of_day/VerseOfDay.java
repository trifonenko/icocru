package ru.app.churchofchrist.verse_of_day;

class VerseOfDay {

    private String textVerse;
    private String coordinates;

    VerseOfDay(String textVerse, String coordinates) {

        this.textVerse = textVerse;
        this.coordinates = coordinates;
    }

    public String getTextVerse() {
        return textVerse;
    }

    public String getCoordinates() {
        return coordinates;
    }
}