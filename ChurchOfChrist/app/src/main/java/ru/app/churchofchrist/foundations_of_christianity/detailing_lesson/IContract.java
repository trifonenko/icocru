package ru.app.churchofchrist.foundations_of_christianity.detailing_lesson;

public interface IContract {

    interface IPresenterLessonDetail {
        String getLessonText(String titleLesson);
    }

    interface IModelLessonDetail {
        String loadLessonText(String titleLesson);
    }
}