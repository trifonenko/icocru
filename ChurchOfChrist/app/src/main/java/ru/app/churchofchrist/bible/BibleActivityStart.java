package ru.app.churchofchrist.bible;

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

import ru.app.churchofchrist.R;

public class BibleActivityStart extends AppCompatActivity {
    private TextView textViewKnig;
    private TextView textViewStih;
    private TextView textViewDate;
    private TextView textViewAdr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bible_start);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_back);//устанавливаем на панель инструментов навигационную кнопку назад
        //вешаем обработчик на навигационную кнопку назад, при нажатии которой действующая активность закрывается
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        textViewKnig = (TextView) findViewById(R.id.textViewKnig);
        textViewStih = (TextView) findViewById(R.id.textViewStih);
        textViewDate = (TextView) findViewById(R.id.textViewDate);
        textViewAdr = (TextView) findViewById(R.id.textViewAdr);
        MyTask mt = new MyTask();
        mt.execute();
        MyTask2 mt2 = new MyTask2();
        mt2.execute();
        MyTask3 mt3 = new MyTask3();
        mt3.execute();
        MyTask4 mt4 = new MyTask4();
        mt4.execute();

    }


    class MyTask extends AsyncTask<Void, Void, Void> {

        String title;//Тут храним значение заголовка сайта

        @Override
        protected Void doInBackground(Void... params) {

            Document doc = null;
            try {
                doc = Jsoup.connect("https://okbible.ru/rndvers.php").get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (doc!=null) {
                Elements elements = doc.select("h5.coord");
                title = elements.get(0).text();
            } else
                title = "Ошибка";
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            textViewKnig.setText(title);
        }
    }
    class MyTask2 extends AsyncTask<Void, Void, Void> {

        String text;//Тут храним значение заголовка сайта

        @Override
        protected Void doInBackground(Void... params) {

            Document doc = null;
            try {
                doc = Jsoup.connect("https://okbible.ru/rndvers.php").get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (doc!=null) {
                Elements elements = doc.select("p.vers");
                text = elements.get(0).text();
            } else
            text = "Ошибка";

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            textViewStih.setText(text);
        }
    }

    class MyTask3 extends AsyncTask<Void, Void, Void> {

        String date;//Тут храним значение заголовка сайта

        @Override
        protected Void doInBackground(Void... params) {

            Document doc = null;
            try {
                doc = Jsoup.connect("https://www.bibleonline.ru/read/today/").get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (doc!=null) {
                Elements elements = doc.select("td.content");
                date = elements.get(0).select("h1").text();
            } else
                date = "Ошибка";
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            textViewDate.setText(date);
        }
    }

    class MyTask4 extends AsyncTask<Void, Void, Void> {

        String adr;//Тут храним значение заголовка сайта

        @Override
        protected Void doInBackground(Void... params) {

            Document doc = null;
            try {
                doc = Jsoup.connect("http://bibleplan.ru/").get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (doc!=null) {
                Elements elements = doc.select("span.header-plan-chapters");
                adr = elements.get(0).text();
            } else
                adr = "Ошибка";
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            textViewAdr.setText(adr);
        }
    }

    public void click_sinod(View view) {
        Intent intent = new Intent(BibleActivityStart.this, BibleActivity2.class);
        startActivity(intent);
    }

    public void click_sovr(View view) {
        Intent intent2 = new Intent(BibleActivityStart.this, BibleActivity.class);
        startActivity(intent2);
    }

}
