package ru.app.churchofchrist.firebase;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

import ru.app.churchofchrist.R;

public class InfoNewsActivity extends AppCompatActivity {
    private TextView textViewInfo;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_news);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            //bundle must contain all info sent in "data" field of the notification
        }

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

        textViewInfo = (TextView) findViewById(R.id.textViewInfo);

        MyInfo mt = new MyInfo();
        mt.execute();

        webView = findViewById(R.id.wvinfoapp);

        WebSettings webSettings = webView.getSettings();
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://sites.google.com/view/icocruinfoapp/главная?authuser=1");
        webView.setWebViewClient(new MyWebViewClient());
        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);

    }
        //Сообщение пользователю
    class MyInfo extends AsyncTask<Void, Void, Void> {

        String adr;//Тут храним значение заголовка сайта

        @Override
        protected Void doInBackground(Void... params) {

            Document doc = null;
            try {
                doc = Jsoup.connect("https://raw.githubusercontent.com/trifonenko/icocru/master/ChurchOfChrist/info").get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (doc != null) {
                Elements elements = doc.select("body");
                adr = elements.get(0).text();
            } else
                adr = "Требуется подключение к интернету";
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            textViewInfo.setText(adr);
        }
    }


    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if(Uri.parse(url).getHost().length() == 0) {
                return false;
            }

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            view.getContext().startActivity(intent);
            return true;
        }




        //При невозможности открыть какую либо страницу, открывает html файл с уведомлением
        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
     /*остановка загрузки и отображение страницы error.html из папки “assets”*/
            view.stopLoading();
            view.loadUrl("file:///android_asset/error.html");
        }

    }

}

