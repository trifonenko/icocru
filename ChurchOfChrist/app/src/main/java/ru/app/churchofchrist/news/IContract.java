package ru.app.churchofchrist.news;

import java.util.List;

import io.reactivex.Single;

public interface IContract {
    interface IModel {
        Single<List<News>> loadNews();
    }

    interface IView {
        void loadNewsList(List<News> aNews);
    }

    interface IPresenter {
        void loadNews();
    }
}