package ru.app.churchofchrist.good_news;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.facebook.drawee.backends.pipeline.Fresco;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import ru.app.churchofchrist.R;

public class GoodNewsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public ProgressDialog dialog;
    private RecyclerView recyclerView;
    public String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_good_news);

        Toolbar toolbar = findViewById(R.id.toolbar_good_news);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Spinner spinner = findViewById(R.id.spinner_regions_good_news);
        spinner.setOnItemSelectedListener(this);
        String[] titles = getResources().getStringArray(R.array.titles_regions_good_news);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_regions_good_news, R.id.title_region_good_new, titles);
        spinner.setAdapter(adapter);

        recyclerView = findViewById(R.id.recycler_good_news);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        dialog = new ProgressDialog(this);


    }

    @SuppressLint("StaticFieldLeak")
    class GoodNewsTask extends AsyncTask<Void, Void, Void> {
        private String[] titles;
        private String[] texts;
        private String[] images;

        protected void onPreExecute() {
            dialog.setMessage("Загрузка новостей...");
            dialog.setIndeterminate(true);
            dialog.setCancelable(true);
            dialog.show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document document = Jsoup.connect(link).get();
                Elements div = document.select("div.content-container");

                Document doc = Jsoup.parse(div.html());
                Elements links = doc.select("h2 > a");
                titles = new String[links.size()];

                Elements body = doc.select("p");
                texts = new String[body.size()];

                Elements img = doc.select("iframe, img");
                images = new String[img.size()];

                for (int i = 0; i < links.size(); i++) {
                    titles[i] = links.get(i).text();
                    texts[i] = body.get(i).text();
                    images[i] = img.get(i).absUrl("src");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            dialog.dismiss();
            GoodNewsRecyclerAdapter adapter = new GoodNewsRecyclerAdapter(GoodNewsActivity.this, titles, texts, images);
            recyclerView.setAdapter(adapter);

        }
    }

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
}