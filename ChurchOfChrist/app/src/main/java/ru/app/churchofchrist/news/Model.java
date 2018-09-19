package ru.app.churchofchrist.news;

import android.net.Uri;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

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
                Document docHtml = Jsoup.connect(Model.URL_NEWS)
                                        .get();
                List<String> titles = docHtml.select("div.content-container")
                                             .select("h3>a")
                                             .eachText();
                List<String> imageUri = docHtml.select("div.content-container")
                                               .select("img")
                                               .eachAttr("src");

                List<String> descriptionUri = docHtml.select("div.content-container")
                                                     .select("div.featured-media")
                                                     .select("a")
                                                     .eachAttr("href");

                List<String> description = Observable.fromIterable(descriptionUri)
                                                  .map(uri ->
                                                          Jsoup.connect(uri)
                                                               .get()
                                                               .select("p")
                                                               .text()
                                                  )
                                                  .toList()
                                                  .blockingGet();

                List<News> newsList = Observable.fromIterable(titles)
                                                .zipWith(imageUri, (title, imgUri) -> {
                                                    News news = new News();
                                                    news.setTitle(title);
                                                    news.setImageUri(Uri.parse(imgUri));
                                                    return news;
                                                })
                                                .zipWith(description, (news, descript) -> {
                                                    news.setDescription(descript);
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