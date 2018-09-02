package ru.app.churchofchrist.news;

import android.net.Uri;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public class Model implements IContract.IModel {

    private static final String URL_NEWS = "http://icocnews.ru";

    @Override
    public Single<List<News>> loadNews() {
        return Single.create(e -> {
            try {
                Document docHtml = Jsoup.connect(Model.URL_NEWS).get();
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