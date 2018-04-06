package ru.app.churchofchrist.bible;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import ru.app.churchofchrist.R;
import ru.app.churchofchrist.songs.SongsListFragment;

public class BibleActivity2 extends AppCompatActivity {
    private SharedPreferences prefs;
    private String prefName = "spinner_value";
    int id=0;
    private WebView webView;
    Menu myMenu = null;
    private ProgressDialog mProgressDialog;
    Handler handler;
    private boolean isInternetPresent;
    private SongsListFragment.ConnectionDetector cd;
    private Toolbar toolbar=null;
    private String[] category=null;
    String[] knigi = {"Бытие", "Исход", "Левит", "Числа", "Второзаконие", "Иисус Навин", "Судьи", "Руфь", "1 Царств", "2 Царств", "3 Царств", "4 Царств", "1 Паралипоменон", "2 Паралипоменон", "Ездра", "Неемии", "Есфирь", "Иов", "Псалтирь", "Притчи", "Екклесиаст", "Песня Песней", "Исаия", "Иеремия", "Плач Иеремии", "Иезекииль", "Даниил", "Осия", "Иоиль", "Амос", "Авдий", "Иона", "Михей", "Наум", "Аввакум", "Софония", "Аггей", "Захария", "Малахия", "Матфей", "Марк", "Лука", "Иоанн", "Деяния", "Иаков", "1 Петра", "2 Петра", "1 Иоанна", "2 Иоанна", "3 Иоанна", "Иуда", "Римлянам", "1 Коринфянам", "2 Коринфянам", "Галатам", "Ефесянам", "Филиппийцам", "Колоссянам", "1 Фессалоникийцам", "2 Фессалоникийцам", "1 Тимофею", "2 Тимофею", "Титу", "Филимону", "Евреям", "Откровение"};
    private ProgressDialog progressDialog;


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bible2);
        category = getResources().getStringArray(R.array.perevod);

        //Логическая переменная для статуса соединения
        Boolean isInternetPresent = false;
        SongsListFragment.ConnectionDetector cd;

        //Создаем пример класса connection detector:
        cd = new SongsListFragment.ConnectionDetector(getApplicationContext());


        /*// иниизиализируем кнопку
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BibleActivity2.this, BibleActivity.class);
                startActivity(intent);
            }
        });*/

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_back);//устанавливаем на панель инструментов навигационную кнопку назад
        //вешаем обработчик на навигационную кнопку назад, при нажатии которой действующая активность закрывается
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        // Привязываем объявленную переменную типа WebView к созданному нами
        // элементу WebView в файле activity_bible.xml:

        /*// адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_dropdown_item, perevod);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);


        Spinner spinner = findViewById(R.id.perevod);
        spinner.setAdapter(adapter);
        // заголовок
        spinner.setPrompt("Перевод");
        // выделяем элемент
        spinner.setSelection(0);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText(R.string.synod);
                        break;
                    case 1:
                        Intent intent3 = new Intent(BibleActivity2.this, BibleActivity.class);
                        startActivity(intent3);
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText(R.string.nrp);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/

        // адаптер
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, R.layout.spinner_dropdown_item2, knigi);
        adapter2.setDropDownViewResource(R.layout.spinner_dropdown_item2);

        Spinner spinner2 = findViewById(R.id.knigi);
        spinner2.setAdapter(adapter2);

        prefs = getSharedPreferences(prefName, MODE_PRIVATE);
        id=prefs.getInt("last_val",0);
        spinner2.setSelection(id);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                prefs = getSharedPreferences(prefName, MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("last_val", position);
                editor.commit();

                switch (position) {
                    case 0:
                        webView.loadUrl("file:///android_asset/books_rst/01.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Быт.");
                        break;
                    case 1:
                        webView.loadUrl("file:///android_asset/books_rst/02.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Исх.");
                        break;
                    case 2:
                        webView.loadUrl("file:///android_asset/books_rst/03.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Лев.");
                        break;
                    case 3:
                        webView.loadUrl("file:///android_asset/books_rst/04.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Числ.");
                        break;
                    case 4:
                        webView.loadUrl("file:///android_asset/books_rst/05.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Втор.");
                        break;
                    case 5:
                        webView.loadUrl("file:///android_asset/books_rst/06.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("ИсНав.");
                        break;
                    case 6:
                        webView.loadUrl("file:///android_asset/books_rst/07.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Суд.");
                        break;
                    case 7:
                        webView.loadUrl("file:///android_asset/books_rst/08.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Руфь");
                        break;
                    case 8:
                        webView.loadUrl("file:///android_asset/books_rst/09.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("1Цар.");
                        break;
                    case 9:
                        webView.loadUrl("file:///android_asset/books_rst/10.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("2Цар.");
                        break;
                    case 10:
                        webView.loadUrl("file:///android_asset/books_rst/11.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("3Цар.");
                        break;
                    case 11:
                        webView.loadUrl("file:///android_asset/books_rst/12.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("4Цар.");
                        break;
                    case 12:
                        webView.loadUrl("file:///android_asset/books_rst/13.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("1Пар.");
                        break;
                    case 13:
                        webView.loadUrl("file:///android_asset/books_rst/14.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("2Пар.");
                        break;
                    case 14:
                        webView.loadUrl("file:///android_asset/books_rst/15.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Ездр.");
                        break;
                    case 15:
                        webView.loadUrl("file:///android_asset/books_rst/16.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Неем.");
                        break;
                    case 16:
                        webView.loadUrl("file:///android_asset/books_rst/17.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Есф.");
                        break;
                    case 17:
                        webView.loadUrl("file:///android_asset/books_rst/18.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Иов");
                        break;
                    case 18:
                        webView.loadUrl("file:///android_asset/books_rst/19.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Пс.");
                        break;
                    case 19:
                        webView.loadUrl("file:///android_asset/books_rst/20.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Прит.");
                        break;
                    case 20:
                        webView.loadUrl("file:///android_asset/books_rst/21.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Екк.");
                        break;
                    case 21:
                        webView.loadUrl("file:///android_asset/books_rst/22.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Песн.");
                        break;
                    case 22:
                        webView.loadUrl("file:///android_asset/books_rst/23.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Исаия");
                        break;
                    case 23:
                        webView.loadUrl("file:///android_asset/books_rst/24.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Иер.");
                        break;
                    case 24:
                        webView.loadUrl("file:///android_asset/books_rst/25.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("ПлИер.");
                        break;
                    case 25:
                        webView.loadUrl("file:///android_asset/books_rst/26.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Иез.");
                        break;
                    case 26:
                        webView.loadUrl("file:///android_asset/books_rst/27.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Дан.");
                        break;
                    case 27:
                        webView.loadUrl("file:///android_asset/books_rst/28.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Осия");
                        break;
                    case 28:
                        webView.loadUrl("file:///android_asset/books_rst/29.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Иоиль");
                        break;
                    case 29:
                        webView.loadUrl("file:///android_asset/books_rst/30.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Амос");
                        break;
                    case 30:
                        webView.loadUrl("file:///android_asset/books_rst/31.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Авд.");
                        break;
                    case 31:
                        webView.loadUrl("file:///android_asset/books_rst/32.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Иона");
                        break;
                    case 32:
                        webView.loadUrl("file:///android_asset/books_rst/33.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Мих.");
                        break;
                    case 33:
                        webView.loadUrl("file:///android_asset/books_rst/34.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Наум");
                        break;
                    case 34:
                        webView.loadUrl("file:///android_asset/books_rst/35.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Авв.");
                        break;
                    case 35:
                        webView.loadUrl("file:///android_asset/books_rst/36.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Соф.");
                        break;
                    case 36:
                        webView.loadUrl("file:///android_asset/books_rst/37.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Агг.");
                        break;
                    case 37:
                        webView.loadUrl("file:///android_asset/books_rst/38.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Зах.");
                        break;
                    case 38:
                        webView.loadUrl("file:///android_asset/books_rst/39.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Мал.");
                        break;
                    case 39:
                        webView.loadUrl("file:///android_asset/books_rst/40.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Матф.");
                        break;
                    case 40:
                        webView.loadUrl("file:///android_asset/books_rst/41.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Марк.");
                        break;
                    case 41:
                        webView.loadUrl("file:///android_asset/books_rst/42.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Лук.");
                        break;
                    case 42:
                        webView.loadUrl("file:///android_asset/books_rst/43.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Ин.");
                        break;
                    case 43:
                        webView.loadUrl("file:///android_asset/books_rst/44.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Деян.");
                        break;
                    case 44:
                        webView.loadUrl("file:///android_asset/books_rst/45.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Иак.");
                        break;
                    case 45:
                        webView.loadUrl("file:///android_asset/books_rst/46.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("1Пет.");
                        break;
                    case 46:
                        webView.loadUrl("file:///android_asset/books_rst/47.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("2Пет.");
                        break;
                    case 47:
                        webView.loadUrl("file:///android_asset/books_rst/48.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("1Ин.");
                        break;
                    case 48:
                        webView.loadUrl("file:///android_asset/books_rst/49.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("2Ин.");
                        break;
                    case 49:
                        webView.loadUrl("file:///android_asset/books_rst/50.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("3Ин.");
                        break;
                    case 50:
                        webView.loadUrl("file:///android_asset/books_rst/51.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Иуд.");
                        break;
                    case 51:
                        webView.loadUrl("file:///android_asset/books_rst/52.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Рим.");
                        break;
                    case 52:
                        webView.loadUrl("file:///android_asset/books_rst/53.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("1Кор");
                        break;
                    case 53:
                        webView.loadUrl("file:///android_asset/books_rst/54.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("2Кор");
                        break;
                    case 54:
                        webView.loadUrl("file:///android_asset/books_rst/55.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Гал.");
                        break;
                    case 55:
                        webView.loadUrl("file:///android_asset/books_rst/56.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Ефес.");
                        break;
                    case 56:
                        webView.loadUrl("file:///android_asset/books_rst/57.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Фил.");
                        break;
                    case 57:
                        webView.loadUrl("file:///android_asset/books_rst/58.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Кол.");
                        break;
                    case 58:
                        webView.loadUrl("file:///android_asset/books_rst/59.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("1Фес.");
                        break;
                    case 59:
                        webView.loadUrl("file:///android_asset/books_rst/60.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("2Фес.");
                        break;
                    case 60:
                        webView.loadUrl("file:///android_asset/books_rst/61.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("1Тим.");
                        break;
                    case 61:
                        webView.loadUrl("file:///android_asset/books_rst/62.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("2Тим.");
                        break;
                    case 62:
                        webView.loadUrl("file:///android_asset/books_rst/63.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Тит.");
                        break;
                    case 63:
                        webView.loadUrl("file:///android_asset/books_rst/64.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Филим.");
                        break;
                    case 64:
                        webView.loadUrl("file:///android_asset/books_rst/65.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Евр.");
                        break;
                    case 65:
                        webView.loadUrl("file:///android_asset/books_rst/66.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Откр.");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /*SpinnerAdapter spinnerAdapter2 = ArrayAdapter.createFromResource(getApplicationContext(), R.array.book, R.layout.spinner_dropdown_item2);
        Spinner navigationSpinner2 = new Spinner(getSupportActionBar().getThemedContext());
        navigationSpinner2.setAdapter(spinnerAdapter2);
        toolbar.addView(navigationSpinner2, 0);

        navigationSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        webView.loadUrl("file:///android_asset/books/01_genesis.html");
                        break;
                    case 1:
                        webView.loadUrl("file:///android_asset/books/02_exodus.html");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/




        webView = findViewById(R.id.webViewBible);

        WebSettings webSettings = webView.getSettings();
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webSettings.setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
        progressDialog = new ProgressDialog(BibleActivity2.this);
        progressDialog.setMessage("Загрузка...");
        progressDialog.show();
            webView.setWebViewClient(new MyWebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    if (progressDialog.isShowing()) {
                        progressDialog.dismiss();
                    }
                }

                @Override
                public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                    Toast.makeText(BibleActivity2.this, "Error:" + description, Toast.LENGTH_SHORT).show();

                }
            });
            webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);

    }

    // Пишем код обработки нажатия кнопки назад на устройстве, что позволит нам при нажатии
    // на кнопку "Назад" перейти к предыдущей странице, а не просто закрывать приложения.
    // Оно будет закрываться кнопкой "Назад" лишь в том случае, если мы находимся на стартовой
    // странице, которую указали выше:

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (webView.canGoBack()) {
                        onBackPressed();
                    } else {
                        onBackPressed();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }

    //Открывать ссылки только на этом сайте
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            /*if (url.indexOf(".") <= 0) {
                // the link is not for a page on my site, so launch another Activity that handles URLs
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                return true;
            }

            return false;*/
            if(Uri.parse(url).getHost().length() == 0) {
            /*if(Uri.parse(url).getHost().endsWith(".")) {*/
            /*if (url.indexOf(".") <= 0) {*/
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_bible, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            /*case R.id.offsinod:
                webView.loadUrl("file:///android_asset/books_rst/01.html");
*//*                Toast toast = Toast.makeText(getApplicationContext(),
                        "В режиме OFFLINE не работает АУДИО и ПОИСК", Toast.LENGTH_LONG);
                toast.show();*//*
                break;
            case R.id.offsovr:
                webView.loadUrl("file:///android_asset/books/01_genesis.html");
*//*                Toast toast2 = Toast.makeText(getApplicationContext(),
                        "В режиме OFFLINE не работает АУДИО и ПОИСК", Toast.LENGTH_LONG);
                toast2.show();*//*
                break;*/
/*            case R.id.sinod:
                webView.loadUrl("https://okbible.ru/books_rst/01");
                break;*/
            case R.id.zamet_bible:
                Intent intent2 = new Intent(BibleActivity2.this, ru.app.churchofchrist.notepad.MainActivity.class);
                startActivity(intent2);
                break;
            case R.id.search_bible:
                webView.loadUrl("https://okbible.ru/extsearch.php");
                break;
            case R.id.random_bible:
                webView.loadUrl("https://okbible.ru/rndvers.php");
                break;
        }

        return true;
    }
    @Override
    public void onBackPressed() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            onNavigateUp();
        }
    }
}
