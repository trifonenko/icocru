package ru.app.churchofchrist.foundations_of_christianity;

import java.util.List;

interface IContract {

    interface IView {
        void showListLessons(List<String> titlesLessons);
    }

    interface IPresenter {

        void onTabSelected(CharSequence contentDescription);
    }

    interface IModel {
        List<Lesson> getListLessons(String nameTable);
    }
}