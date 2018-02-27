package ru.app.churchofchrist.good_news;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

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

    class GoodNewsTask extends AsyncTask<Void, Void, Void> {

        String[] title = new String[1];
        @Override
        protected Void doInBackground(Void... voids) {
            Document doc = null;
            try {
                doc = Jsoup.connect("http://www.icocnews.ru").get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (doc!=null)
                title[0] = doc.title();
            else
                title[0] = "Ошибка";

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            GoodNewsRecyclerAdapter adapter = new GoodNewsRecyclerAdapter(title);
            recyclerView.setAdapter(adapter);
        }
    }
}
