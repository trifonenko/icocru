package ru.app.churchofchrist.foundations_of_christianity;

import lombok.Getter;

@Getter
class Lesson {
    private String title;
    private String lessonText;

    Lesson(String title, String lessonText) {
        this.title = title;
        this.lessonText = lessonText;
    }
}