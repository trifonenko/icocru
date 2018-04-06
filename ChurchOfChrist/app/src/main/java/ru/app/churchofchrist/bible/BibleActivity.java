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


public class BibleActivity extends AppCompatActivity {
    private SharedPreferences prefs;
    private String prefName = "spinner_value";
    int id=0;

    private WebView webView;
    Menu myMenu = null;
    private ProgressDialog mProgressDialog;
    Handler handler;
    SharedPreferences sPref; // Сохранение
    int knig; // Размер текста
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
        setContentView(R.layout.activity_bible);
        category = getResources().getStringArray(R.array.perevod);

        //Логическая переменная для статуса соединения
        Boolean isInternetPresent = false;
        SongsListFragment.ConnectionDetector cd;

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_back);//устанавливаем на панель инструментов навигационную кнопку назад
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, R.layout.spinner_dropdown_item, knigi);
        adapter2.setDropDownViewResource(R.layout.spinner_dropdown_item);

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
                        webView.loadUrl("file:///android_asset/books/01_genesis.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Быт.");
                        break;
                    case 1:
                        webView.loadUrl("file:///android_asset/books/02_exodus.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Исх.");
                        break;
                    case 2:
                        webView.loadUrl("file:///android_asset/books/03_leviticus.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Лев.");
                        break;
                    case 3:
                        webView.loadUrl("file:///android_asset/books/04_numbers.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Числ.");
                        break;
                    case 4:
                        webView.loadUrl("file:///android_asset/books/05_deuteronomy.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Втор.");
                        break;
                    case 5:
                        webView.loadUrl("file:///android_asset/books/06_joshua.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("ИсНав.");
                        break;
                    case 6:
                        webView.loadUrl("file:///android_asset/books/07_judges.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Суд.");
                        break;
                    case 7:
                        webView.loadUrl("file:///android_asset/books/08_ruth.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Руфь");
                        break;
                    case 8:
                        webView.loadUrl("file:///android_asset/books/09_1samuel.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("1Цар.");
                        break;
                    case 9:
                        webView.loadUrl("file:///android_asset/books/10_2samuel.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("2Цар.");
                        break;
                    case 10:
                        webView.loadUrl("file:///android_asset/books/11_1kings.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("3Цар.");
                        break;
                    case 11:
                        webView.loadUrl("file:///android_asset/books/12_2kings.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("4Цар.");
                        break;
                    case 12:
                        webView.loadUrl("file:///android_asset/books/13_1chronicles.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("1Пар.");
                        break;
                    case 13:
                        webView.loadUrl("file:///android_asset/books/14_2chronicles.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("2Пар.");
                        break;
                    case 14:
                        webView.loadUrl("file:///android_asset/books/15_ezra.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Ездр.");
                        break;
                    case 15:
                        webView.loadUrl("file:///android_asset/books/16_nehemiah.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Неем.");
                        break;
                    case 16:
                        webView.loadUrl("file:///android_asset/books/17_esther.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Есф.");
                        break;
                    case 17:
                        webView.loadUrl("file:///android_asset/books/18_job.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Иов");
                        break;
                    case 18:
                        webView.loadUrl("file:///android_asset/books/19_psalms.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Пс.");
                        break;
                    case 19:
                        webView.loadUrl("file:///android_asset/books/20_proverbs.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Прит.");
                        break;
                    case 20:
                        webView.loadUrl("file:///android_asset/books/21_ecclesiastes.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Екк.");
                        break;
                    case 21:
                        webView.loadUrl("file:///android_asset/books/22_songofsolomon.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Песн.");
                        break;
                    case 22:
                        webView.loadUrl("file:///android_asset/books/23_isaiah.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Исаия");
                        break;
                    case 23:
                        webView.loadUrl("file:///android_asset/books/24_jeremiah.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Иер.");
                        break;
                    case 24:
                        webView.loadUrl("file:///android_asset/books/25_lamentations.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("ПлИер.");
                        break;
                    case 25:
                        webView.loadUrl("file:///android_asset/books/26_ezekiel.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Иез.");
                        break;
                    case 26:
                        webView.loadUrl("file:///android_asset/books/27_daniel.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Дан.");
                        break;
                    case 27:
                        webView.loadUrl("file:///android_asset/books/28_hosea.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Осия");
                        break;
                    case 28:
                        webView.loadUrl("file:///android_asset/books/29_joel.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Иоиль");
                        break;
                    case 29:
                        webView.loadUrl("file:///android_asset/books/30_amos.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Амос");
                        break;
                    case 30:
                        webView.loadUrl("file:///android_asset/books/31_obadiah.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Авд.");
                        break;
                    case 31:
                        webView.loadUrl("file:///android_asset/books/32_jonah.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Иона");
                        break;
                    case 32:
                        webView.loadUrl("file:///android_asset/books/33_micah.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Мих.");
                        break;
                    case 33:
                        webView.loadUrl("file:///android_asset/books/34_nahum.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Наум");
                        break;
                    case 34:
                        webView.loadUrl("file:///android_asset/books/35_habakkuk.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Авв.");
                        break;
                    case 35:
                        webView.loadUrl("file:///android_asset/books/36_zephaniah.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Соф.");
                        break;
                    case 36:
                        webView.loadUrl("file:///android_asset/books/37_haggai.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Агг.");
                        break;
                    case 37:
                        webView.loadUrl("file:///android_asset/books/38_zechariah.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Зах.");
                        break;
                    case 38:
                        webView.loadUrl("file:///android_asset/books/39_malachi.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Мал.");
                        break;
                    case 39:
                        webView.loadUrl("file:///android_asset/books/40_matthew.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Матф.");
                        break;
                    case 40:
                        webView.loadUrl("file:///android_asset/books/41_mark.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Марк.");
                        break;
                    case 41:
                        webView.loadUrl("file:///android_asset/books/42_luke.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Лук.");
                        break;
                    case 42:
                        webView.loadUrl("file:///android_asset/books/43_john.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Ин.");
                        break;
                    case 43:
                        webView.loadUrl("file:///android_asset/books/44_acts.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Деян.");
                        break;
                    case 44:
                        webView.loadUrl("file:///android_asset/books/45_james.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Иак.");
                        break;
                    case 45:
                        webView.loadUrl("file:///android_asset/books/46_1peter.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("1Пет.");
                        break;
                    case 46:
                        webView.loadUrl("file:///android_asset/books/47_2peter.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("2Пет.");
                        break;
                    case 47:
                        webView.loadUrl("file:///android_asset/books/48_1john.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("1Ин.");
                        break;
                    case 48:
                        webView.loadUrl("file:///android_asset/books/49_2john.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("2Ин.");
                        break;
                    case 49:
                        webView.loadUrl("file:///android_asset/books/50_3john.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("3Ин.");
                        break;
                    case 50:
                        webView.loadUrl("file:///android_asset/books/51_jude.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Иуд.");
                        break;
                    case 51:
                        webView.loadUrl("file:///android_asset/books/52_romans.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Рим.");
                        break;
                    case 52:
                        webView.loadUrl("file:///android_asset/books/53_1corinthians.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("1Кор");
                        break;
                    case 53:
                        webView.loadUrl("file:///android_asset/books/54_2corinthians.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("2Кор");
                        break;
                    case 54:
                        webView.loadUrl("file:///android_asset/books/55_galatians.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Гал.");
                        break;
                    case 55:
                        webView.loadUrl("file:///android_asset/books/56_ephesians.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Ефес.");
                        break;
                    case 56:
                        webView.loadUrl("file:///android_asset/books/57_philippians.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Фил.");
                        break;
                    case 57:
                        webView.loadUrl("file:///android_asset/books/58_colossians.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Кол.");
                        break;
                    case 58:
                        webView.loadUrl("file:///android_asset/books/59_1thessalonians.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("1Фес.");
                        break;
                    case 59:
                        webView.loadUrl("file:///android_asset/books/60_2thessalonians.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("2Фес.");
                        break;
                    case 60:
                        webView.loadUrl("file:///android_asset/books/61_1timothy.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("1Тим.");
                        break;
                    case 61:
                        webView.loadUrl("file:///android_asset/books/62_2timothy.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("2Тим.");
                        break;
                    case 62:
                        webView.loadUrl("file:///android_asset/books/63_titus.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Тит.");
                        break;
                    case 63:
                        webView.loadUrl("file:///android_asset/books/64_philemon.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Филим.");
                        break;
                    case 64:
                        webView.loadUrl("file:///android_asset/books/65_hebrews.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Евр.");
                        break;
                    case 65:
                        webView.loadUrl("file:///android_asset/books/66_revelations.html");
                        ((TextView) parent.getChildAt(0)).setTextSize(14);
                        ((TextView) parent.getChildAt(0)).setText("Откр.");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        webView = findViewById(R.id.webViewBible);
        WebSettings webSettings = webView.getSettings();
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webSettings.setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
        progressDialog = new ProgressDialog(BibleActivity.this);
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
                    Toast.makeText(BibleActivity.this, "Error:" + description, Toast.LENGTH_SHORT).show();

                }
            });
            webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);

    }
    public void onPageFinished(WebView view, String url) {
        if ((mProgressDialog != null) && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
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
            case R.id.zamet_bible:
                Intent intent2 = new Intent(BibleActivity.this, ru.app.churchofchrist.notepad.MainActivity.class);
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