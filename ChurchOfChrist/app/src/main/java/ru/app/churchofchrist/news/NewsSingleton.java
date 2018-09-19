package ru.app.churchofchrist.news;

import android.net.Uri;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

class NewsSingleton {
    private static final String URL_NEWS = "http://icocnews.ru";
    private List<News> mNewsList = new ArrayList<>();
    private static NewsSingleton mNewsSingleton;

    private NewsSingleton() {
    }

    public static NewsSingleton getInstance() {
        if (mNewsSingleton == null) {
            mNewsSingleton = new NewsSingleton();
        }
        return mNewsSingleton;
    }

    List<News> getNewsList() {
        return mNewsList;
    }

    public void setNewsList(List<News> newsList) {
        this.mNewsList = newsList;
    }

    private Single<List<News>> loadListNews() {
        return Single.create(e -> {
            try {
                Document docHtml = Jsoup.connect(NewsSingleton.URL_NEWS)
                                        .get();
                Elements titles = docHtml.select("div.content-container")
                                         .select("h3>a");
                Elements imageUri = docHtml.select("div.content-container")
                                           .select("img");

                List<News> newsList = Observable.fromIterable(titles)
                                                .zipWith(imageUri, (title, uri) -> {
                                                    News news = new News();
                                                    news.setTitle(title.text());
                                                    news.setImageUri(Uri.parse(uri.absUrl("src")));
                                                    return news;
                                                })
                                                .toList()
                                                .blockingGet();
                e.onSuccess(newsList);
            } catch (IOException exp) {
                e.onError(exp);
            }
        });
    }
}