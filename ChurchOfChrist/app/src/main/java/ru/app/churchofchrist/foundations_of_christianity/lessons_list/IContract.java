package ru.app.churchofchrist.foundations_of_christianity.lessons_list;

import java.util.List;

import ru.app.churchofchrist.foundations_of_christianity.Lesson;


public interface IContract {

    interface IView {

    }

    interface IPresenter {
        /**
         * Возвращает список тем уроков.
         *
         * @return список тем уроков.
         */
        List<String> getTopics();

        List<String> loadListTitles(String topicLessons);
    }

    interface IModel {
        /**
         * Загрузка списка тем уроков.
         *
         * @return список тем уроков.
         */
        List<String> loadTopicsLessons();

        List<String> titlesLessons(String topicLesson);

        List<Lesson> getListLessons(String nameTable);
    }
}