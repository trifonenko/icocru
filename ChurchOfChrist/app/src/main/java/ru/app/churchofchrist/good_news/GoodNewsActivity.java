package ru.app.churchofchrist.good_news;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

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

        String[] titles = null;

        @Override
        protected Void doInBackground(Void... voids) {
            Document doc = null;
            Elements captions = null;
            try {

                doc = Jsoup.connect("http://www.icocnews.ru/istorii/centralnaya-rossiya").get();
                Elements div = doc.select("div.featured-summary");
                Document document = Jsoup.parse(div.html());
                captions = document.select("a");

            } catch (Exception e) {
                e.printStackTrace();
            }

            if (doc != null) {
                titles = new String[captions.size()];
                for (int i = 0; i < captions.size(); i++) {
                    titles[i] = captions.get(i).html();
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            GoodNewsRecyclerAdapter adapter = new GoodNewsRecyclerAdapter(titles);
            recyclerView.setAdapter(adapter);
        }
    }
}