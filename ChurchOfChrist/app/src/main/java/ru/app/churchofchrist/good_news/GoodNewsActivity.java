package ru.app.churchofchrist.good_news;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.facebook.drawee.backends.pipeline.Fresco;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import ru.app.churchofchrist.R;

/**
 *
 */

public class GoodNewsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private String link = "http://www.icocnews.ru/istorii";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_good_news);

        Toolbar toolbar = findViewById(R.id.toolbar_good_news);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setSubtitle(R.string.good_news);
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Spinner spinner = findViewById(R.id.spinner_good_news);
        String[] array = getResources().getStringArray(R.array.spinner_good_news);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_good_news, R.id.title_good, array);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        link = "http://www.icocnews.ru/istorii";
                        break;
                    case 1:
                        link = "http://www.icocnews.ru/istorii/centralnaya-rossiya";
                        break;
                    case 2:
                        link = "http://www.icocnews.ru/istorii/cerkvi-na-yuge-rossii";
                        break;
                    case 3:
                        link = "http://www.icocnews.ru/istorii/ural";
                        break;
                    case 4:
                        link = "http://www.icocnews.ru/istorii/cerkvi-v-sibiri";
                        break;
                    case 5:
                        link = "http://www.icocnews.ru/istorii/dalnij-vostok";
                        break;
                    case 6:
                        link = "http://www.icocnews.ru/istorii/cerkvi-v-ukraine";
                        break;
                    case 7:
                        link = "http://www.icocnews.ru/istorii/cerkvi-v-belarusi";
                        break;
                    case 8:
                        link = "http://www.icocnews.ru/istorii/blizhnee-zarubezhe";
                        break;
                    case 9:
                        link = "http://www.icocnews.ru/istorii/aziatsko-tixookeanskij-region";
                        break;
                    case 10:
                        link = "http://www.icocnews.ru/istorii/america";
                        break;
                    case 11:
                        link = "http://www.icocnews.ru/istorii/evropa";
                        break;
                    case 12:
                        link = "http://www.icocnews.ru/istorii/cerkvi-v-afrike";
                        break;
                }
                GoodNewsTask task = new GoodNewsTask();
                task.execute();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        recyclerView = findViewById(R.id.recycler_good_news);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
    }

    @SuppressLint("StaticFieldLeak")
    class GoodNewsTask extends AsyncTask<Void, Void, Void> {

        private String[] titles;
        private String[] text;
        private String[] image;

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document document = Jsoup.connect(link).get();
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