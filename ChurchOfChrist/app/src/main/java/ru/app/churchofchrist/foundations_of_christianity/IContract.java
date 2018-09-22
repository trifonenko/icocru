package ru.app.churchofchrist.foundations_of_christianity;

import java.util.List;

interface IContract {

    interface IView {
        void showLessons(List<Lesson> lessonList);
    }

    interface IModel {
        List<Lesson> getListLessons();
    }
}