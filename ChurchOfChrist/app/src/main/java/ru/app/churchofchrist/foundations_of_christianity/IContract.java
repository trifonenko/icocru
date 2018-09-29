package ru.app.churchofchrist.foundations_of_christianity;

import java.util.List;

interface IContract {

    interface IView {

    }

    interface IPresenter {
        List<Lesson> getListLessons(String nameTable);
    }

    interface IModel {
        List<Lesson> getListLessons(String nameTable);
    }
}