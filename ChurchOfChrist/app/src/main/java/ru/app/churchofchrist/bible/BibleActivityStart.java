package ru.app.churchofchrist.bible;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ru.app.churchofchrist.R;

public class BibleActivityStart extends AppCompatActivity {
    private TextView textViewDate;
    private TextView textViewAdr;

    @SuppressLint({"SimpleDateFormat", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bible_start);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        textViewDate = findViewById(R.id.textViewDate);
        textViewAdr = findViewById(R.id.textViewAdr);

        MyTask mt = new MyTask();
        mt.execute();

        Date currentDate = new Date();
        SimpleDateFormat dateFormat = null;
        dateFormat = new SimpleDateFormat("dd MMMM");
        textViewDate.setText("Чтение на сегодня (" + dateFormat.format( currentDate ) + ")");

    }


    @SuppressLint("StaticFieldLeak")
    class MyTask extends AsyncTask<Void, Void, Void> {

        String adr;

        @Override
        protected Void doInBackground(Void... params) {

            Document doc = null;
            try {
                doc = Jsoup.connect("http://bibleplan.ru/").get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (doc != null) {
                Elements elements = doc.select("span.header-plan-chapters");
                adr = elements.get(0).text();
            } else
                adr = "Требуется подключение к интернету";
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            textViewAdr.setText(adr);
        }
    }

    // Загрузка изображения
    /*private class MyTask5 extends AsyncTask<Void, Void, Void> {
        Bitmap bitmap;


        @Override
        protected Void doInBackground(Void... params) {

            try {
                // Connect to the web site
                Document document = Jsoup.connect("https://servevery.com/").get();
                // Использование элементов для получения данных класса
                Elements img = document.select("div[class=hfeed] img[src]");
                // Найдите атрибут src
                String imgSrc = img.attr("src");
                // Download image from URL
                InputStream input = new java.net.URL(imgSrc).openStream();
                // Decode Bitmap
                bitmap = BitmapFactory.decodeStream(input);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Set downloaded image into ImageView
            ImageView logoimg = (ImageView) findViewById(R.id.imageView);
            logoimg.setImageBitmap(bitmap);
        }
    }*/


    public void click_sinod(View view) {
        Intent intent = new Intent(BibleActivityStart.this, BibleActivity2.class);
        startActivity(intent);
    }

    public void click_sovr(View view) {
        Intent intent2 = new Intent(BibleActivityStart.this, BibleActivity.class);
        startActivity(intent2);
    }

}