package ru.app.churchofchrist.good_news;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import ru.app.churchofchrist.R;

/**
 *
 */

public class GoodNewsActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_good_news);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        recyclerView = findViewById(R.id.recycler_good_news);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        GoodNewsTask task = new GoodNewsTask();
        task.execute();
    }

    @SuppressLint("StaticFieldLeak")
    class GoodNewsTask extends AsyncTask<Void, Void, Void> {

        private String[] titles;
        private String[] text;
        private String[] image;

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document document = Jsoup.connect("http://www.icocnews.ru/istorii/centralnaya-rossiya").get();
                Elements div = document.select("div.content-container");

                Document doc = Jsoup.parse(div.html());
                Elements links = doc.select("h2 > a");
                titles = new String[links.size()];

                Elements body = doc.select("p");
                text = new String[body.size()];

                Elements img = doc.select("iframe, img");
                image = new String[img.size()];

                for (int i = 0; i < links.size(); i++) {
                    titles[i] = links.get(i).text();
                    text[i] = body.get(i).text();
                    image[i] = img.get(i).absUrl("src");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            GoodNewsRecyclerAdapter adapter = new GoodNewsRecyclerAdapter(titles, text, image);
            recyclerView.setAdapter(adapter);
        }
    }
}